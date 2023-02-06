import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
	static int tc;
	static int m;
	static int n;
	static int x;
	static int y;
	
	static int max_res;
	
	
	static int[] res;
	
	public static void main(String args[]) throws Exception {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		tc = Integer.parseInt(st.nextToken());;
		res = new int[tc];
		for(int i = 0; i < tc; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			max_res = 0;
			for (int j = 0; j < n; j++) {
				s = br.readLine();
				st = new StringTokenizer(s);
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				if((m / 2) > x) {
					if(((y - 1) + (x - 1)) > max_res) {
						max_res = (y - 1) + (x - 1);
					}
				}else {
					if(((y - 1) + (m - x)) > max_res) {
						max_res = (y - 1) + (m - x);
					}
				}
			}
			res[i] = max_res;
		}
		
		for(int i = 0; i < tc; i++) {
			System.out.printf("#%d %d\n", i + 1, res[i]);
		}
	}
}