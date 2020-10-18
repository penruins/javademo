public class ShiftTest {
    public static void main(String[] args) {
        int number = 10;
        printInfo(number);
        number <<= 1;
        printInfo(number);
        number >>= 1;
        printInfo(number);

    }
    private static void printInfo(int num) {
        System.out.println(Integer.toBinaryString(num));
    }
}
