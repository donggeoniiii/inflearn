package collection.compare;

// Comparable: 다른 인스턴스와 비교 가능한 기준이 있는 객체
public class MyUser implements Comparable<MyUser> {

    private String id;
    private int age;

    public MyUser(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    // Comparable.compareTo(): 자기 자신과 인수로 들어온 인스턴스를 비교
    // 해당 정렬 기준이 이 객체의 natural order
    @Override
    public int compareTo(MyUser o) {
        return this.age < o.age ? -1 : (this.age == o.age ? 0 : 1);
    }

    @Override
    public String toString() {
        return id;
    }
}