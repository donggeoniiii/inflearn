package collection.set;

public class StringHashMain {

    static final int CAPACITY = 10;

    public static void main(String[] args) {
        // 아스키코드를 이용해 알파벳을 숫자로 표시 가능
        char charA = 'A';
        char charB = 'B';
        System.out.println(charA + " = " + (int)charA); // 65
        System.out.println(charB + " = " + (int)charB); // 66

        // hashCode
        System.out.println(hashCode("A")); // 65
        System.out.println(hashCode("B")); // 66
        System.out.println(hashCode("AB")); // 65 + 66 = 131

        // hashIndex
        System.out.println(hashIndex(hashCode("A"))); // 65 % 10 = 5
        System.out.println(hashIndex(hashCode("B"))); // 66 % 10 = 6
        System.out.println(hashIndex(hashCode("AB"))); // 131 % 10 = 1
    }

    static int hashCode(String str) {
        char[] charArray = str.toCharArray();
        int sum = 0;
        for (char c : charArray) {
            sum += c;
        }
        return sum;
    }

    static int hashIndex(int value) {
        return value % CAPACITY;
    }
}