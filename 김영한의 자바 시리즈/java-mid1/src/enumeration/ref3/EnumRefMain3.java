package enumeration.ref3;

public class EnumRefMain3 {

    public static void main(String[] args) {
        int price = 10000;

        Grade[] grades = Grade.values();
        for (Grade grade : grades) {
            grade.printDiscount(price);
        }
    }
}
