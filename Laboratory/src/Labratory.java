import java.util.*;
//https://na982.tistory.com/?page=40
public class Labratory {
	static int n;
	static int m;
	static int ret;
	
	static int[][] map = new int[8][8];

	final static int[] dy = { -1, +1, 0, 0 }; // 상 하 좌 우
	final static int[] dx = { 0, 0, -1, +1 };
	
	static void bfs() {
		LinkedList<Integer> q = new LinkedList<Integer>();
		int[][] backup = new int[8][8];
		int[][] visited = new int[8][8];
		
		for(int y = 0; y < n; ++y) {
			for(int x = 0; x < m; ++x) {
				backup[y][x] = map[y][x]; // map을 복사
				if (backup[y][x] == 2) {
					q.offer(y * 10 + x); // 바이러스의 좌표 값을 저장
					visited[y][x] = 1; // 방문기록을 남김
				}
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.peek(); // 좌표값 불러오기
			q.poll();
	
			int cy = cur / 10; // 좌표값 해독
			int cx = cur % 10;
			
			backup[cy][cx] = 2; // 해당 좌표에 바이러스 저장
			
			for(int dir = 0; dir < 4; ++dir) {
				int ny = cy + dy[dir];
				int nx = cx + dx[dir];
				
				if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
					continue; // 범위가 맵의 크기를 벗어나는 경우, 밑은 실행하지 않음
				}
				
				if( visited[ny][nx] == 0 && backup[ny][nx] == 0) {
					visited[ny][nx] = 1;
					q.push(ny * 10 + nx); // 바이러스가 확살될 좌표 저장
				}
			}
		}
		int candi = 0;
		for(int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (backup[y][x] == 0) {
					++candi;
				}
			}
		}
		
		if (ret < candi) {
			ret = candi;
		}
	}
	
	static void pick_dfs(int count, int sy, int sx) {
		if (count == 3) {
			bfs();
			return;
		}
		
		for (int y = sy; y < n; ++y) {
			for ( int x = sx; x < m; ++x) {
				if (map[y][x] == 0){
					map[y][x] = 1;
					pick_dfs(count + 1, y, x);
					map[y][x] = 0;
				}
			}
			sx = 0;
		}	 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int y = 0; y < n; ++y) {
			for (int x = 0; x < m; ++x) {
				map[y][x] = sc.nextInt();
			}
		}


		pick_dfs(0, 0, 0);

		
		System.out.printf("%d\n", ret);
	}
}
