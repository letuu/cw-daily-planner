package pro.sky.java.ds_3_0.task1;

public class Main1 {
    public static void main(String[] args) {

        // 1 Написать программу на Java для вычисления серии чисел Фибоначчи
        int n = 20;
        int[] fibNumbers = new int[n];
        fibNumbers[0] = 0;
        fibNumbers[1] = 1;

        for (int i = 2; i < fibNumbers.length; i++) {
            fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
        }
        for (int fibNumber : fibNumbers) {
            System.out.println(fibNumber);
        }
    }
}
