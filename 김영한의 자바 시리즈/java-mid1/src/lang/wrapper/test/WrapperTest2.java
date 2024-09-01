package lang.wrapper.test;

public class WrapperTest2 {

    public static void main(String[] args) {
        String[] array = {"1.5", "2.5", "3.0"};

        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += Double.parseDouble(array[i]);
        }
        System.out.println("sum = " + sum);
    }
}
