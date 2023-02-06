import java.util.*;

public class snake {
	static int n; //���� ũ��
	static int k; //����� ����
	static int m; //����� ����
	static int[][] map = new int[101][101]; // ���� ǥ��

	static int head_y; // ���� �Ӹ� ��ġ �� y
	static int head_x; // ���� �Ӹ� ��ġ �� x
	static int tail_index; // ���� ����
	static int[] snake_y = new int[10101]; // ���� �ʱ��� ��ġ�� y
	static int[] snake_x = new int[10101]; // ���� �ʱ��� ��ġ�� x
	static char[] cmd = new char[10001]; // Ŀ��带 �Է¹��� �迭
	
	final static int[] dy = {0, +1, 0, -1};
	final static int[] dx = {+1, 0, -1, 0}; // Ŀ��尪�� ���� �̵��ϰԵ� ����
	
	public static void main(String[] args) {
		Scanner Scan = new Scanner(System.in);
		n = Scan.nextInt(); // ���� ũ�� �Է�
		k = Scan.nextInt(); // ����(����� ���� �Է�)

		
		for(int i = 0; i < k; ++i) { // ����� ��ġ �Է�
			int y = Scan.nextInt();
			int x = Scan.nextInt();
			map[y][x] = 1; // ����� ��ġ ���� 1�� ����
		}
		
		int time;
		char c;
		m = Scan.nextInt(); // Ŀ���(���)�� ���� �Է�
		
		for(int i = 0; i < m; ++i) {
			time = Scan.nextInt(); // �ð� �Է�
			c = Scan.next().charAt(0); // Ŀ��� �Է�
			
			// �ð��� Ŀ��� ����, �������� ������ ���� �����ȵ� ��ġ�� NULL�� ����
			cmd[time] = c; 
			}
		
		int dir = 0; // ���� ������ ����
		time = 0;
		
		head_y = 1;		head_x = 1; // ���� �Ӹ��� �ʱ�ȭ
		tail_index = time; // ���۽� ������ ���� �Ӹ��� ���� ���� ��ġ
		
		// 0���϶� �Ӹ���ġ �� ����
		snake_y[time] = head_y;		snake_x[time] = head_x; 
		
		map[head_y][head_x] = -1; // �Ӹ��� ��ġ�� -1�� ����
		
		// ���⼭ ��� ���� �Ϸ�/ 0�� �����, 1�� ����� �ִ� ����, -1�� ���� ��ġ�� ����
		
		while(true) { // �ùķ��̼�
			++time; // �ð� ����
			
			head_y += dy[dir]; // ���� �Ӹ� �̵�
			head_x += dx[dir]; // ���� �Ӹ� �̵�
			
			// ���� �Ӹ���ġ�� ������ �������� Ȯ��
			if(head_y < 1 || head_y > n || // �ʿ��� Ż���ϴ� �� Ȯ��
			   head_x < 1 || head_x > n || 
			   map[head_y][head_x] == -1) { // �ڽ��� ���� �ε����°� Ȯ��
				break;
			}
			
			snake_y[time] = head_y;
			snake_x[time] = head_x;
			
			if(map[head_y][head_x] == 0) { // ���� ������ ������ ����� �ִ°� Ȯ��
				int tail_y = snake_y[tail_index]; //����� ���� ��� ������ ��ġ�� Ž��
				int tail_x = snake_x[tail_index];
				map[tail_y][tail_x]=0; // ������ ��ġ�� 0���� ����
				++tail_index; // ������ ���� ��������, ���� ���̸� ����
			}
			
			map[head_y][head_x] = -1; // �Ӹ��� ��ġ�� �ű�
			
			if (cmd[time] == 'D') { // D = ���������� 90��
				dir = (dir + 1) % 4; // dy�� ������ �������� �����Ͽ����Ƿ� + 1
			}
			if (cmd[time] == 'L') { // L = �������� 90��
				dir = (dir + 3) % 4; // -1�� �ص� ������ +3�� �����ϴ�!
			}
		}
		System.out.printf("%d\n", time);
	}
}
