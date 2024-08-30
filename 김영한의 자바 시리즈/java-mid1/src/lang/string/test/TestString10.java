package lang.string.test;

public class TestString10 {

    public static void main(String[] args) {
        String fruits = "apple,banana,mango";

        String[] fruitArr = fruits.split(",");
        for (String fruit : fruitArr) {
            System.out.println(fruit);
        }
        String fruitJoin = String.join("->", fruitArr);
        System.out.println(fruitJoin);
    }
}
