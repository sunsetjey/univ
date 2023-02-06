import java.util.*;

public class BeadsEscape2 {
	static class INFO {
		int ry;
		int rx; 
		int by; 
		int bx;
		int count;
	}
	
	static INFO start = new INFO();
	static char[][] map = new char[10][11];
	
	static int bfs() {
		final int[] dy = {-1, 1, 0, 0};
		final int[] dx = {0, 0, -1, 1};
		
		int[][][][] visited = new int [10][10][10][10];
		LinkedList<INFO> q = new LinkedList<INFO>();
		q.offer(start);
		visited[start.ry][start.rx][start.by][start.bx] = 1;

		int ret = -1;
		while (!q.isEmpty()){
			INFO cur = q.peek();
			q.poll();
			if (cur.count > 10){
				break;
			}
			if (map[cur.ry][cur.rx] == 'O' && map[cur.by][cur.bx] != 'O'){
				ret = cur.count;
				break;
			}

			for (int dir = 0; dir < 4; ++dir){
				int next_ry = cur.ry;
				int next_rx = cur.rx;
				int next_by = cur.by;
				int next_bx = cur.bx;

				while (true){
					if (map[next_ry][next_rx] != '#' && 
							map[next_ry][next_rx] != 'O'){
						next_ry += dy[dir];
						next_rx += dx[dir];
					}
					else{
						if (map[next_ry][next_rx] == '#') {
							next_ry -= dy[dir];
							next_rx -= dx[dir];
						}
						break;
					}
				}

				while (true) {
					if (map[next_by][next_bx] != '#' && 
							map[next_by][next_bx] != 'O'){
						next_by += dy[dir];
						next_bx += dx[dir];
					}
					else {
						if (map[next_by][next_bx] == '#') {
							next_by -= dy[dir];
							next_bx -= dx[dir];
						}
						break;
					}
				}

				if (next_ry == next_by && next_rx == next_bx) {
					if (map[next_ry][next_rx] != 'O') {
						int red_dist = 
								Math.abs(next_ry - cur.ry) + 
								Math.abs(next_rx - cur.rx);
						int blue_dist = 
								Math.abs(next_by - cur.by) + 
								Math.abs(next_bx - cur.bx);
						if (red_dist > blue_dist) {
							next_ry -= dy[dir];
							next_rx -= dx[dir];
						}
						else {
							next_by -= dy[dir];
							next_bx -= dx[dir];
						}
					}
				}

				if (visited[next_ry][next_rx][next_by][next_bx] == 0) {
					visited[next_ry][next_rx][next_by][next_bx] = 1;
					
					INFO next = new INFO();
					next.ry = next_ry;
					next.rx = next_rx;
					next.by = next_by;
					next.bx = next_bx;
					next.count = cur.count + 1;
					q.offer(next);
				}
			}
		}
		return ret;
	}

	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		for (int i = 0; i < n; ++i) {
			 map[i] = scan.next().toCharArray();
		}

		for (int y = 0; y < n; ++y) {
			for (int x = 0; x < m; ++x)	{
				if (map[y][x] == 'R') {
					start.ry = y;
					start.rx = x;
				}
				if (map[y][x] == 'B') {
					start.by = y;
					start.bx = x;
				}
			}
		}
		start.count = 0;

		int ret = bfs();
		
		System.out.printf("%d\n", ret);

	}
}
