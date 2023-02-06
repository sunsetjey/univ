import java.util.*;
public class OperatorInsert {
	
	static int n;
	static int[] number = new int[11];
	static int[] op = new int[4]; // 연산자
	static int ret_min = 0x7fffffff;
	static int ret_max = 0x7fffffff * -1;
	
	static void dfs(int res, int count) {
		if (count == n - 1) {
	        if (ret_min > res) {
	            ret_min = res;
	        }
	        if (ret_max < res) {
	            ret_max = res;
	        }
	        return;
	    }
		
		for (int i = 0; i < 4; ++i) {
	        if (op[i] != 0) {
	            --op[i];
	            if (i == 0) {
	                dfs(res + number[count + 1], count + 1);
	            }
	            else if (i == 1) {
	                dfs(res - number[count + 1], count + 1);
	            }
	            else if (i == 2) {
	                dfs(res * number[count + 1], count + 1);
	            }
	            else if (i == 3) {
	                dfs(res / number[count + 1], count + 1);
	            }
	            ++op[i];
	        }
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for( int i = 0; i < n; ++i) {
			number[i] = sc.nextInt(); // 피연산자 입력
		}
		for (int i = 0; i < 4; ++i) {
			op[i] = sc.nextInt(); // 연산자
		}
		dfs(number[0], 0);
		
		System.out.printf("%d\n%d", ret_max, ret_min);
	}
}
