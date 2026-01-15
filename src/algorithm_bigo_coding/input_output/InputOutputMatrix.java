package algorithm_bigo_coding.input_output;

import java.util.Scanner;

public class InputOutputMatrix {
    public static void main(String[] args) {
        String inputFileName = "input_numberic_matrix.txt";

        try (Scanner scanner = new Scanner(
                InputOutputMatrix.class.getResourceAsStream(inputFileName))) {

            if (scanner == null) {
                System.err.println("Không tìm thấy file: " + inputFileName);
                System.err.println("File cần nằm cùng thư mục với file .java này");
                return;
            }

            // Đọc kích thước ma trận
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            // Khởi tạo ma trận
            int[][] matrix = new int[n][m];

            // In kích thước để kiểm tra
            System.out.printf("%d %d%n", n, m);

            // Đọc dữ liệu ma trận
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {     // ← sửa: j < m (không phải j <= m)
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // In ma trận ra màn hình
            System.out.println("Ma trận vừa đọc:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix[i][j] + " ");   // ← in với khoảng cách
                }
                System.out.println();  // xuống dòng sau mỗi hàng
            }

        } catch (Exception e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}