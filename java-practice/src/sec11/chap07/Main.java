package sec11.chap07;

import sec07.chap04.Side;
import sec07.chap04.Swordman;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try {
            //  여기서 아래의 메소드들을 하나씩 호출할 것
            supplyAsyncEx();
//            thenAcceptEx1();
//            thenAcceptEx2();
//            thenApplyEx1();
//            thenApplyEx2();
//            exceptionallyEx(false);
//            exceptionallyEx(true);
//            thenComposeEx();
//            thenCombineEx();
//            allOfEx1();
//            allOfEx2();
//            anyOfEx();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void takeTime(boolean error) {
        //  시간이 걸리고 예외 가능성 있는 작업 시뮬레이션
        try {
            int randMilliSec = new Random().nextInt(1000, 1500);
            Thread.sleep(randMilliSec);
            System.out.printf("... %f 초 경과 ...%n", randMilliSec / 1000.0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (error) throw new RuntimeException("⚠️ 오류 발생");
    }

    public static void supplyAsyncEx() throws ExecutionException, InterruptedException {

        //  💡 supplyAsync : Supplier를 받아 비동기 작업 실행
        //  - 결과를 CompletableFuture의 형태로 반환
        CompletableFuture<String> getHello = CompletableFuture.supplyAsync(() -> {
            takeTime(false);
            return "Hello";
        });

        System.out.println("- - - get 사용 전 - - -");

        //  💡 Future처럼 get을 사용하면 블록킹 발생
        //  - 값을 받아올 때까지 다음 코드의 진행을 막음 (비동기가 아니게 됨)
        String hello = getHello.get();
        //  ⚠️ 실습 편의를 위해 본 메소드에서 예외 던짐
        //  - 실행하는 곳에서 받음 주의

        System.out.println("- - - get 사용 후 - - -");
        System.out.println(hello);
        //  ❌ 실습 후 주석처리 할 것
    }

    public static void thenAcceptEx1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> getHello = CompletableFuture.supplyAsync(() -> {
            System.out.println("값 받아오기 시작");
            takeTime(false);
            return "Hello";
        });

        //  💡 thenAccept : 받아온 값을 Consumer로 실행
        //  - 이전 과정으로부터 얻은 값으로 할 일을 지정함 (비동기)
        //  - 여기서는 일을 정해두기만 할 뿐, 호출은 get으로 (동기)
        //  - get으로 호출해도, supplyAsync 작업이 끝나고 나서야 실행
        CompletableFuture<Void> printHello = getHello.thenAccept(s -> {
            System.out.println("받아온 값 처리 시작");
            takeTime(false);
            System.out.println(s);
        });

        System.out.println("- - - 중간에 다른 코드들 진행 - - -");

        //printHello.get(); // ⭐ 활성화하고 나서 재실행
    }

    public static void thenAcceptEx2() throws ExecutionException, InterruptedException {

        //  ⭐️ 비동기 메소드 체이닝

        CompletableFuture<Void> print5nums = CompletableFuture.supplyAsync(() -> {
            List<Integer> ints = new ArrayList<>();
            IntStream.range(0, 5).forEach(i -> {
                takeTime(false);
                ints.add(i);
            });
            return ints;
        }).thenAccept(list -> {
            takeTime(false);
            list.stream().forEach(System.out::println);
        });

        System.out.println("- - - 중간에 다른 코드들 진행 - - -");

        print5nums.get();
    }

    public static void thenApplyEx1() throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            takeTime(false);
            return new Random().nextInt(0, 6) + 1;

        }).thenApply(
                //  💡 thenApply : 얻어온 값을 Function에 넣어 다른 값 반환
                //  - 스트림의 map과 비슷
                i -> {
                    takeTime(false);
                    return "이번 숫자: " + i;
                }
        ).thenAccept(
                System.out::println
        ).get();
    }

    public static void thenApplyEx2() throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            takeTime(false);
            return new Random().nextBoolean();

            //  ⭐ Apply 연속 사용
        }).thenApply(b -> {
            takeTime(false);
            return new Swordman(b ? Side.RED : Side.BLUE);
        }).thenApply(s -> {
            takeTime(false);
            return s.toString();
        }).thenAccept(
                System.out::println
        ).get();
    }

    //  각각 false, true로 시험해 볼 것
    public static void exceptionallyEx(Boolean error) throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            takeTime(error);
            return "ㅇㅇ 안녕";

        }).exceptionally(e -> {
            //  💡 exceptionally : 오류 발생시 대체 값 반환
            e.printStackTrace();
            return "안녕 못해.";
        }).thenApply(s -> {
            takeTime(false);
            return "대답: " + s;
        }).thenAccept(
                System.out::println
        ).get();
    }

    public static CompletableFuture<Swordman> getChamp(Side side) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("- - - 🤺 %s 검사 훈련 시작 - - -%n", side.getName());
            takeTime(false);
            return new Swordman(side);
        }).thenApply(c -> {
            System.out.printf("- - - 💪 %s 검사 체력 훈련 - - -%n", side.getName());
            takeTime(false);
            c.hp += new Random().nextInt(0, 3);
            return c;
        });
    }

    public static void thenComposeEx() throws ExecutionException, InterruptedException {

        CompletableFuture<Swordman> getBlueChamp = getChamp(Side.BLUE);
        CompletableFuture<Swordman> getRedChamp = getChamp(Side.RED);

        System.out.println("\n===== 양 진영 검사 훈련중 =====\n");

        //  💡 thenCompose : 두 CompleteFuture의 결과를 조합
        //  -  ⭐️ 두 작업이 동시에 진행됨 주목
        getBlueChamp.thenCompose(
                        b -> getRedChamp.thenApply(
                                r -> {
                                    if (b.hp == r.hp) throw new RuntimeException();
                                    return b.hp >= r.hp ? b : r;
                                })
                )
                .thenApply(Swordman::toString)
                .thenApply(s -> "🏆 승자 : " + s)
                .exceptionally(e -> "⚔ 무승부") // ⭐️ 어느 위치에서든 처리 가능
                .thenAccept(System.out::println)
                .get();
    }

    public static void thenCombineEx() {
        CompletableFuture<Swordman> getBlueChamp = getChamp(Side.BLUE);
        CompletableFuture<Swordman> getRedChamp = getChamp(Side.RED);

        System.out.println("\n===== 양 진영 검사 훈련중 =====\n");

        try {
            //  💡 thenCombine : thenCompose와 문법만 다름
            getBlueChamp.thenCombine(
                            getRedChamp,
                            (b, r) -> {
                                if (b.hp == r.hp) throw new RuntimeException();
                                return b.hp >= r.hp ? b : r;
                            })
                    .thenApply(Swordman::toString)
                    .thenApply(s -> "🏆 승자 : " + s)
                    .exceptionally(e -> "⚔ 무승부") // ⭐️ 어느 위치에서든 처리 가능
                    .thenAccept(System.out::println)
                    .get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static CompletableFuture<Integer> rollDiceFuture() {
        return CompletableFuture.supplyAsync(() -> {
                    System.out.println("주사위 굴림");

                    takeTime(new Random().nextBoolean());
                    var result = new Random().nextInt(0, 6) + 1;
                    System.out.println("🎲 : " + result);
                    return result;
                }
        ).exceptionally(e -> -1); //  ⭐ 예외 대비
    }

    public static void allOfEx1() throws ExecutionException, InterruptedException {
        var roll1 = rollDiceFuture();
        var roll2 = rollDiceFuture();
        var roll3 = rollDiceFuture();
        var roll4 = rollDiceFuture();
        var roll5 = rollDiceFuture();

        //  💡 allOf : 여러 CompletableFuture 작업을 동시에 진행
        //  - thenRun 메소드에서 결과들을 동기적으로 종합
        CompletableFuture.allOf(
                roll1, roll2, roll3, roll4, roll5
        ).thenRun(() -> {
            //  💡 프린트 순서 확인
            System.out.println("✅ 결과 모두 나옴");

            //  ⭐ 각 Future로부터 결과 받아옴
            var int1 = roll1.join();
            var int2 = roll2.join();
            var int3 = roll3.join();
            var int4 = roll4.join();
            var int5 = roll5.join();

            String result = IntStream.of(int1, int2, int3, int4, int5)
                    .boxed()
                    .map(i -> i == -1 ? "(무효)" : String.valueOf(i))
                    .collect(Collectors.joining(", "));
            System.out.println("최종 결과 : " + result);
        }).get();
    }

    public static CompletableFuture<Swordman> trainSwordman() {
        return CompletableFuture.supplyAsync(() -> {
            takeTime(new Random().nextBoolean());
            return new Swordman(Side.BLUE);
        }).exceptionally(e -> {
            System.out.println("😭 탈락");
            return null;
        });
    }

    public static void allOfEx2() throws ExecutionException, InterruptedException {
        ArrayList<CompletableFuture<Swordman>> traings = new ArrayList<>();

        //ForkJoinPool forkJoinPool = new ForkJoinPool(3);

        for (var i = 0; i < 50; i++) {
            traings.add(trainSwordman()); // 아래 것으로 대체해 볼 것
            // traings.add(trainSwordmanWithFJP(forkJoinPool));
            //  ⭐️ 각 Future들이 이 풀을 공유하도록 해야 함 (각각 new로 생성해서 넣으면 안 됨)
        }

        //  ⭐️ CompletableFuture가 동시에 진행하는 쓰레드의 기본 수
        //  - 해당 기기의 가용한 프로세서 수와 같음
        //  - 위의 ForkJoinPool 관련 코드 두줄을 활성화하여 다시 실행해 볼 것

        System.out.println("🖥️ 쓰레드 수 기본: " + ForkJoinPool.getCommonPoolParallelism());

        CompletableFuture.allOf(traings.toArray(CompletableFuture[]::new))
                .thenRun(() -> {
                    var passeds = traings.stream()
                            .map(CompletableFuture::join)
                            .filter(Objects::nonNull)
                            .count();
                    System.out.printf("🎖️ 합격자 : %d명%n", passeds);
                }).get();
    }

    public static CompletableFuture<Swordman> trainSwordmanWithFJP(ForkJoinPool fjp) {
        return CompletableFuture.supplyAsync(() -> {
                    takeTime(new Random().nextBoolean());
                    return new Swordman(Side.BLUE);
                }, fjp //  ⭐️ supplyAsync의 두 번째 인자로 넣어줌
        ).exceptionally(e -> {
            System.out.println("😭 탈락");
            return null;
        });
    }

    public static CompletableFuture<String> raceRunner(String name, ForkJoinPool fjp) {
        return CompletableFuture.supplyAsync(() -> {
                    takeTime(new Random().nextBoolean());
                    System.out.printf("👟 %s 도착%n", name);
                    return name;
                }, fjp
        ).exceptionally(e -> null);
    }

    public static void anyOfEx() throws ExecutionException, InterruptedException {
        ArrayList<CompletableFuture<String>> runners = new ArrayList<>();

        String[] names =
                "철수,영희,돌준,병미,핫훈"
                        //"A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U"
                        .split(",");

        //  ⭐️ 경쟁할 쓰레드보다 풀 수가 적지 않도록
        //  - 3으로 줄여 볼 것 : 앞의 셋 중에서만 나옴
        ForkJoinPool forkJoinPool = new ForkJoinPool(names.length);

        Arrays.stream(names)
                .forEach(r -> runners.add(raceRunner(r, forkJoinPool)));

        //  💡 anyOf : 가장 먼저 완료된 결과물을 받아옴
        CompletableFuture.anyOf(
                        runners.stream()
                                .toArray(CompletableFuture[]::new)
                )
                .thenAccept(w -> {
                    System.out.println(
                            w != null
                                    ? ("🏆 1등: " + w)
                                    : "💣 지뢰 폭발"
                    );
                })
                .get();
    }
}
