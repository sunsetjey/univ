import java.util.Scanner;

public class Clean {
	static class ROBOT{
		int y, x, dir;
	}
	
	static int n, m;
    public static int[][] map;
    public static int ret = 0;
    public static int[] dx = {-1, 0, 1, 0}; // 0서 1남 2동 3북 , 입력값의 + 3부터 루트 시작
    public static int[] dy = {0, 1, 0, -1}; 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 입력 y 사이즈
		m = sc.nextInt(); // 입력 x 사이즈
        map = new int[n][m]; // 맵의 크기 정의
        
    	ROBOT robot = new ROBOT(); // 로봇 인스턴스

        robot.x = sc.nextInt(); // 로봇의 x 위치 정의
        robot.y = sc.nextInt(); // 로봇의 y 위치 정의
        robot.dir = sc.nextInt(); // 로봇의 방향 정의

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        clean(robot.x, robot.y, robot.dir); //청소 재귀 돌림
        
        System.out.println(ret);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//            	System.out.print(map[i][j] + "   ");
//            }
//            System.out.println();
//        }
    }

    public static void clean(int rx, int cy, int d) {
        // 1. 현재 위치를 청소한다.
        if (map[rx][cy] == 0) { // 현재위치가 0이라면
            map[rx][cy] = 2; // 청소한다
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

        // 2. 왼쪽방향부터 차례대로 탐색을 진행한다.
        boolean flag = false; // 플래그를 false로
        int origin = d; // 최초 방향을 저장
        for (int i = 0; i < 4; i++) { // 4방향 탐색
        	ROBOT next = new ROBOT();
            next.dir = (d + 3 - i) % 4; // 좌회전, 최대 4회 진행
            next.x = rx + dx[next.dir]; // 회전 후 좌표값 저장
            next.y = cy + dy[next.dir];

            if (next.x > 0 && next.y > 0 && next.x < n && next.y < m) { // 진행 예정 좌표가 맵을 벗어나지 않고
                if (map[next.x][next.y] == 0) {   // 아직 청소하지 않은 공간이라면
                	clean(next.x, next.y, next.dir); // 재귀해서 청소
                    flag = true; // 청소에 성공했으므로 true
                    break; // 0을 찾았음으로 4방향 탐색 중단
                }
            }
        }

        // 네 방향 모두 청소가 되어있거나 벽인 경우
        if (!flag) { // 다음좌표로 나아가지 못했음으로 flag는 false
        	ROBOT next = new ROBOT();
            next.dir = (origin + 2) % 4; // 진행 하려던 방향에서 역방향
            next.x = rx + dx[next.dir]; // 후진
            next.y = cy + dy[next.dir]; // 후진

            if (next.x > 0 && next.y > 0 && next.x < n && next.y < m) {
                if (map[next.x][next.y] != 1) {
                    clean(next.x, next.y, origin); // 후진한 위치가 벽이 아니라면 다시 4방향 탐색을 위해 재귀
                }
            }
        }
    }
}