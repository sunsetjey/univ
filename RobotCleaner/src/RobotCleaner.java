import java.util.*;

public class RobotCleaner{
	static class ROBOT{
		int y, x, dir;
	}
	
	
	static int n, m;
	static int map[][] = new int[50][50];
	
	static ROBOT robot = new ROBOT();
	
	final static int dy[] = { -1, 0, +1, 0 };
	final static int dx[] = { 0, +1, 0, -1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		robot.x = sc.nextInt();
		robot.y = sc.nextInt();
		robot.dir = sc.nextInt();
		for(int y = 0; y < n; ++y) {
			for(int x = 0; x < m; ++x) {
				map[y][x] = sc.nextInt();
			}
		}
		
		Deque<ROBOT> q = new LinkedList<>();
		
		q.offer(robot);
		
		int ret = 0;
		while(!q.isEmpty()) {
			ROBOT cur = q.peek();
			q.poll();
			
			// 1. 현재 위치를 청소한다.
			if(map[cur.y][cur.x] == 0) {
				map[cur.y][cur.x] =2;
				++ret;
				System.out.printf("map[" + cur.x + "]" + "[" + cur.y + "]\n");
			}
			
			
			// 2. 왼쪽방향부터 차례대로 탐색을 진행한다.
			for(int dir = 0; dir < 4; ++dir) {
				ROBOT next = new ROBOT();
				next.dir = (cur.dir + 3) % 4;
				next.y = cur.y + dy[next.dir];
				next.x = cur.x + dx[next.dir];
				
				if (next.y < 0 || next.y >= n || next.x < 0 || next.x >= m
		                || map[next.y][next.x] != 0) {
					continue;
				}
				q.offer(next);
				break;
			}
			
			
			// 네 방향 모두 청소가 되어있거나 벽인 경우
			if(q.isEmpty()) {
				ROBOT next = new ROBOT();
				next.dir = (cur.dir + 2) % 4;
				next.y = cur.y + dy[(next.dir)];
				next.x = cur.x + dx[(next.dir)];

				if (next.y < 0 || next.y >= n || next.x < 0 || next.x >= m
		                || map[next.y][next.x] == 1) {
	                break;
				}
				q.offer(next);
			}
		}
		
		System.out.println(ret);
	}
}