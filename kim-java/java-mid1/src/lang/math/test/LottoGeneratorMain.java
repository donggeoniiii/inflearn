package lang.math.test;

public class LottoGeneratorMain {
    public static void main(String[] args) {
        int[] lottoNumbers = LottoGenerator.generate();

        System.out.print("로또 번호: ");
        for (int lottoNumber : lottoNumbers) {
            System.out.print(lottoNumber + " ");
        }
    }
}
