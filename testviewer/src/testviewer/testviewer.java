package testviewer;

import java.util.Scanner;

public class testviewer {
	public static int n; // ������ ��
	public static int b; // �������� �����ɷ�
	public static int c; // �ΰ����� �����ɷ�
	public static int[] p = new int[1000000]; // ������ ���� �������� �� �� ���� �迭

	public static void main(String[] args){
		Scanner Scan = new Scanner(System.in);
		n = Scan.nextInt(); // ������ �� �Է�
		
		for (int i = 0; i < n; ++i)	{
			p[i] = Scan.nextInt(); // ���û� �� �Է�
		}
		
		b = Scan.nextInt(); // �������� �� �� �ִ� �л� ��
		c = Scan.nextInt(); // �ΰ����� �� �� �ִ� �л� ��

		long ret = 0; // ��� ��
		for (int i = 0; i < n; ++i)	{
			p[i] -= b; // �������� �� �� �ִ� �л� ���� ���� ����
			++ret; // ������ ī��Ʈ
			if (p[i] > 0){ //���� �л��� �ִٸ�
				int candi = p[i] / c;
				if (p[i] % c != 0){ // �ΰ����� �����ɷ��� �������� mod����
					++candi;
				}
				ret += candi; // �ΰ��� �� ī��Ʈ
			}
		}
		System.out.printf("%d\n", ret);
	}

}
