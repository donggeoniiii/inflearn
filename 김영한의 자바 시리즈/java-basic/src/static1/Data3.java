package static1;

public class Data3 {
    public String name;
    public static int count; // static 변수로 선언

    public Data3(String name) {
        this.name = name;
        Data3.count++; // 앞에 클래스명 생략 가능(자기 멤버 변수니까)
    }
}
