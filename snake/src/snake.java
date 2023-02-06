import java.util.*;

public class snake {
	static int n; //맵의 크기
	static int k; //사과의 개수
	static int m; //명령의 갯수
	static int[][] map = new int[101][101]; // 맵을 표현

	static int head_y; // 뱀의 머리 위치 값 y
	static int head_x; // 뱀의 머리 위치 값 x
	static int tail_index; // 뱀의 꼬리
	static int[] snake_y = new int[10101]; // 뱀의 초기준 위치값 y
	static int[] snake_x = new int[10101]; // 뱀의 초기준 위치값 x
	static char[] cmd = new char[10001]; // 커멘드를 입력받을 배열
	
	final static int[] dy = {0, +1, 0, -1};
	final static int[] dx = {+1, 0, -1, 0}; // 커멘드값에 의해 이동하게될 방향
	
	public static void main(String[] args) {
		Scanner Scan = new Scanner(System.in);
		n = Scan.nextInt(); // 맵의 크기 입력
		k = Scan.nextInt(); // 조건(사과의 갯수 입력)

		
		for(int i = 0; i < k; ++i) { // 사과의 위치 입력
			int y = Scan.nextInt();
			int x = Scan.nextInt();
			map[y][x] = 1; // 사과의 위치 값은 1로 증가
		}
		
		int time;
		char c;
		m = Scan.nextInt(); // 커멘드(명력)의 갯수 입력
		
		for(int i = 0; i < m; ++i) {
			time = Scan.nextInt(); // 시간 입력
			c = Scan.next().charAt(0); // 커멘드 입력
			
			// 시간당 커멘드 지정, 전역변수 임으로 값이 지정안된 위치는 NULL값 저장
			cmd[time] = c; 
			}
		
		int dir = 0; // 최초 오른쪽 방향
		time = 0;
		
		head_y = 1;		head_x = 1; // 뱀의 머리값 초기화
		tail_index = time; // 시작시 꼬리는 뱀의 머리와 같은 곳에 위치
		
		// 0초일때 머리위치 값 저장
		snake_y[time] = head_y;		snake_x[time] = head_x; 
		
		map[head_y][head_x] = -1; // 머리의 위치는 -1로 정의
		
		// 여기서 모든 정의 완료/ 0은 빈공간, 1은 사과가 있는 공간, -1은 뱀이 위치한 공간
		
		while(true) { // 시뮬레이션
			++time; // 시간 증가
			
			head_y += dy[dir]; // 뱀의 머리 이동
			head_x += dx[dir]; // 뱀의 머리 이동
			
			// 뱀의 머리위치가 유요한 범위인지 확인
			if(head_y < 1 || head_y > n || // 맵에서 탈출하는 가 확인
			   head_x < 1 || head_x > n || 
			   map[head_y][head_x] == -1) { // 자신의 몸과 부딪히는가 확인
				break;
			}
			
			snake_y[time] = head_y;
			snake_x[time] = head_x;
			
			if(map[head_y][head_x] == 0) { // 지금 가려는 공간에 사과가 있는가 확인
				int tail_y = snake_y[tail_index]; //사과가 없을 경우 꼬리의 위치를 탐색
				int tail_x = snake_x[tail_index];
				map[tail_y][tail_x]=0; // 꼬리의 위치를 0으로 변경
				++tail_index; // 꼬리의 값을 증가시켜, 뱀의 길이를 줄임
			}
			
			map[head_y][head_x] = -1; // 머리의 위치를 옮김
			
			if (cmd[time] == 'D') { // D = 오른쪽으로 90도
				dir = (dir + 1) % 4; // dy를 오른쪽 방향으로 구현하였으므로 + 1
			}
			if (cmd[time] == 'L') { // L = 왼쪽으로 90도
				dir = (dir + 3) % 4; // -1을 해도 되지만 +3도 가능하다!
			}
		}
		System.out.printf("%d\n", time);
	}
}
