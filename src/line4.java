import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class line4 {

	/**
	 * Time complexity:
	 * Space complexity:
	 */
	static long combination[][];
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			final int T = Integer.parseInt(br.readLine().trim());

			for (int t = 0; t < T; t ++) {
				final StringTokenizer tokenizer = new StringTokenizer(br.readLine().trim());
				int N = Integer.parseInt(tokenizer.nextToken()); // 스티커와 테마 
				int K = Integer.parseInt(tokenizer.nextToken()); // K개 가능 
				int M = Integer.parseInt(tokenizer.nextToken()); // M개만 구매하고 나머지는 포인
				combination = new long[N+2][K+2];

				calCombination(N,K);
				long res = combination[N+1][M+1] * combination[N+1][K-M+1];
				System.out.println(res);
			}
		}
	}

	public static void calCombination(int N,int K){
		combination[1][1] = 1;
		for (int i = 2; i <= N+1; i++){
			for (int j = 1; j <= K+1; j++){
				combination[i][j] = combination[i - 1][j - 1] + combination[i - 1][j];
			}
		}
	}
}


