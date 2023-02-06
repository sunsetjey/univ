package testviewer;

import java.util.Scanner;

public class testviewer {
	public static int n; // 시험장 수
	public static int b; // 정감독의 업무능력
	public static int c; // 부감독의 업무능력
	public static int[] p = new int[1000000]; // 강의장 마다 응시자의 수 를 받을 배열

	public static void main(String[] args){
		Scanner Scan = new Scanner(System.in);
		n = Scan.nextInt(); // 시험장 수 입력
		
		for (int i = 0; i < n; ++i)	{
			p[i] = Scan.nextInt(); // 응시생 수 입력
		}
		
		b = Scan.nextInt(); // 정감독이 볼 수 있는 학생 수
		c = Scan.nextInt(); // 부감독이 볼 수 있는 학생 수

		long ret = 0; // 결과 값
		for (int i = 0; i < n; ++i)	{
			p[i] -= b; // 정감독이 볼 수 있는 학생 수를 먼저 제외
			++ret; // 정감독 카운트
			if (p[i] > 0){ //남은 학생이 있다면
				int candi = p[i] / c;
				if (p[i] % c != 0){ // 부감독의 업무능력을 기준으로 mod연산
					++candi;
				}
				ret += candi; // 부감독 수 카운트
			}
		}
		System.out.printf("%d\n", ret);
	}

}
