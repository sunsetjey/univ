import java.util.Scanner;

public class ReSign {
	static int n;
	static int T[] = new int[15];
	static int P[] = new int[15];
	static int cache[] = new int[15];
	
	static int solve(int day) {
		if (day > n)
			return -987654321;
		if (day == n)
			return 0;
		
	    if (cache[day] != -1)
	    	return cache[day];
	    
	    int ret = Math.max(solve(day + 1), solve(day + T[day]) + P[day]);
		return ret; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
			cache[i] = -1;
		}
		
		int ret = solve(0);
		System.out.printf("%d \n", ret);
	}
}
