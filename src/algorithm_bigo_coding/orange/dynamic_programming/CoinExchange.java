package algorithm_bigo_coding.orange.dynamic_programming;

import java.util.Scanner;

public class CoinExchange {
		
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(CoinExchange.class.getResourceAsStream("coin_exchange_input.txt"))){
			int n = scanner.nextInt();
			
			int coin[] = new int[n];
			for(int i=0; i<n; i++) {
				coin[i] = scanner.nextInt();
			}
			
			int total = scanner.nextInt();
			
			int dp[] = new int[total+1];
			dp[0] = 1;
			for(int i=0; i<n; i++) {
				for(int j=coin[i]; j <= total; j++) {
					dp[j] = dp[j] + dp[j -coin[i]];
				}
			}
			
			
			System.out.print(dp[total]);
		}
		
	}
	
}
