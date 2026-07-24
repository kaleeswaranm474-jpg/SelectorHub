package DailyTask;
import java.util.Scanner;

public class MatrixAdditionSubtraction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] matrix1 = new int[2][2];
        int[][] matrix2 = new int[2][2];
        int[][] sum = new int[2][2];
        int[][] difference = new int[2][2];

        
        System.out.println("Enter First Matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        
        System.out.println("Enter Second Matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

      
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
                difference[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        
        System.out.println("\nMatrix Addition:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }

       
        System.out.println("\nMatrix Subtraction:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(difference[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}