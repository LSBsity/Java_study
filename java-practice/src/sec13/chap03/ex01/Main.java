package sec13.chap03.ex01;

import java.util.*;

public class Main {
    // 💡  괄호 안에 {필드명} = {값}
    @Count(value = 3)
    private int apples;

    //  💡 default가 있을 시 생략 가능
    @Count
    private int bananas;

    //  💡 필드가 하나고 필드명이 value일 시
    //  - 값만 넣을 수 있음
    @Count(5)
    private int cacaos;

    //  💡 값이 여럿일 시. 순서 무관
    @PersonName(last = "홍", first = "길동")
    private Object seller;

    //  💡 어노테이션의 값으로 어노테이션 사용
    @PersonInfo(
            personName = @PersonName(last = "전", first = "우치"),
            age = 30,
            married = true
    )
    private Object sellerInfo;

    //  💡 배열 타입의 필드일 시
    @LocsAvail(
            quick = {"서울", "대전", "강원"}, // {} 안에 작성
            visit = "판교", // 하나만 있을 시 {} 생략 가능
            delivery = {} // 요소가 없을 시 {} 필요
    )
    private Object store;

    public static void main(String[] args) {
        List<Object> annotVals = new ArrayList<>();

        for (var f : Main.class.getDeclaredFields()) {
            for (var a : f.getAnnotations()) {
                if (a instanceof Count) {
                    annotVals.add(((Count) a).value());
                }
                if (a instanceof PersonName) {
                    annotVals.add(((PersonName) a).first());
                    annotVals.add(((PersonName) a).last());
                }
                if (a instanceof PersonInfo) {
                    annotVals.add(((PersonInfo) a).personName().first());
                    annotVals.add(((PersonInfo) a).personName().last());
                    annotVals.add(((PersonInfo) a).age());
                    annotVals.add(((PersonInfo) a).married());
                }
                if (a instanceof LocsAvail) {
                    annotVals.add(((LocsAvail) a).visit());
                    annotVals.add(((LocsAvail) a).delivery());
                    annotVals.add(((LocsAvail) a).quick());
                }
            }
        }
    }
}
