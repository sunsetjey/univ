import java.util.Scanner;

public class Clean {
	static class ROBOT{
		int y, x, dir;
	}
	
	static int n, m;
    public static int[][] map;
    public static int ret = 0;
    public static int[] dx = {-1, 0, 1, 0}; // 0�� 1�� 2�� 3�� , �Է°��� + 3���� ��Ʈ ����
    public static int[] dy = {0, 1, 0, -1}; 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // �Է� y ������
		m = sc.nextInt(); // �Է� x ������
        map = new int[n][m]; // ���� ũ�� ����
        
    	ROBOT robot = new ROBOT(); // �κ� �ν��Ͻ�

        robot.x = sc.nextInt(); // �κ��� x ��ġ ����
        robot.y = sc.nextInt(); // �κ��� y ��ġ ����
        robot.dir = sc.nextInt(); // �κ��� ���� ����

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        clean(robot.x, robot.y, robot.dir); //û�� ��� ����
        
        System.out.println(ret);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//            	System.out.print(map[i][j] + "   ");
//            }
//            System.out.println();
//        }
    }

    public static void clean(int rx, int cy, int d) {
        // 1. ���� ��ġ�� û���Ѵ�.
        if (map[rx][cy] == 0) { // ������ġ�� 0�̶��
            map[rx][cy] = 2; // û���Ѵ�
//            System.out.println("map[" + rx + "][" + cy + "] " + ret);
            ret++;
        }
        
//        if(ret % 10 == 0) {
//        	for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                	System.out.print(map[i][j] + "   ");
//                }
//                System.out.println();
//            }
//        }

        // 2. ���ʹ������ ���ʴ�� Ž���� �����Ѵ�.
        boolean flag = false; // �÷��׸� false��
        int origin = d; // ���� ������ ����
        for (int i = 0; i < 4; i++) { // 4���� Ž��
        	ROBOT next = new ROBOT();
            next.dir = (d + 3 - i) % 4; // ��ȸ��, �ִ� 4ȸ ����
            next.x = rx + dx[next.dir]; // ȸ�� �� ��ǥ�� ����
            next.y = cy + dy[next.dir];

            if (next.x > 0 && next.y > 0 && next.x < n && next.y < m) { // ���� ���� ��ǥ�� ���� ����� �ʰ�
                if (map[next.x][next.y] == 0) {   // ���� û������ ���� �����̶��
                	clean(next.x, next.y, next.dir); // ����ؼ� û��
                    flag = true; // û�ҿ� ���������Ƿ� true
                    break; // 0�� ã�������� 4���� Ž�� �ߴ�
                }
            }
        }

        // �� ���� ��� û�Ұ� �Ǿ��ְų� ���� ���
        if (!flag) { // ������ǥ�� ���ư��� ���������� flag�� false
        	ROBOT next = new ROBOT();
            next.dir = (origin + 2) % 4; // ���� �Ϸ��� ���⿡�� ������
            next.x = rx + dx[next.dir]; // ����
            next.y = cy + dy[next.dir]; // ����

            if (next.x > 0 && next.y > 0 && next.x < n && next.y < m) {
                if (map[next.x][next.y] != 1) {
                    clean(next.x, next.y, origin); // ������ ��ġ�� ���� �ƴ϶�� �ٽ� 4���� Ž���� ���� ���
                }
            }
        }
    }
}