package sec07.chap01.ex03;

public class Click {
    int x;
    int y;
    int timestamp;

    public Click(int x, int y, int timestamp) {
        this.x = x;
        this.y = y;
        this.timestamp = timestamp;
    }

    //  ⭐️ 아래를 주석해제하고 다시 실행해 볼 것
      @Override
      public int hashCode() {
          return x * 100000 + y;
      }
}
