package algorithm_bigo_coding.input_output;

import java.util.Scanner;

public class InputOutputString {
	public static void main(String[] args) {
		String filePath = "input_string_multiple_line.txt";
		Scanner scanner;

		try {
			scanner = new Scanner(InputOutputString.class.getResourceAsStream(filePath));
			String s0;
			while (scanner.hasNextLine()) {
				s0 = scanner.nextLine();
				System.out.println(s0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
