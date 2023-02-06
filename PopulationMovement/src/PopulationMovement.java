import java.io.IOException;
import java.util.*;

class PopulationMovement {

    static int N;
    static int L;
    static int R;
    static int[][] map;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        // input
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        StringTokenizer st = new StringTokenizer(s, " ");
    	Scanner sc = new Scanner(System.in);
    	String s = new String();
        N = Integer.parseInt(sc.next());
        L = Integer.parseInt(sc.next());
        R = Integer.parseInt(sc.next());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            s = sc.next();
            st = new StringTokenizer(s, " ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // input end

        int result = 0; // �α� �̵� Ƚ��
        boolean flag = true; // �ݺ��� Ż�� flag

        while (flag) {
            if (movePeople() == 0) // �� �̻� �α� �̵��� �� ���� ������ �ݺ��� Ż��
                flag = false;
            else
                result++;
        }

        System.out.println(result);
    }

    // BFS�� ���� �׷��� �����Ѵ�.
    // ������ �����Ǿ����� �α��� �����ϰ� �й��Ѵ�.
    static int movePeople() {
        int unionCount = 0; // ������ ������ �� ������ ������ 0 �̻��� ���� ����

        // (0,0) ~ (N-1,N-1)���� BFS ����
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!visited[x][y]) {
                    Queue<Location> queue = new LinkedList<>();
                    Location location = new Location(x, y);
                    queue.add(location);

                    List<Location> list = new ArrayList<>();
                    list.add(location);

                    visited[location.x][location.y] = true;

                    int unionSum = map[location.x][location.y]; // �α��� �հ�

                    while (!queue.isEmpty()) {
                        Location current = queue.poll();

                        for (int i = 0; i < 4; i++) {
                            int nx = current.x + dx[i];
                            int ny = current.y + dy[i];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (!visited[nx][ny] && checkBoundary(current.x, current.y, nx, ny)) {
                                    queue.add(new Location(nx, ny));
                                    list.add(new Location(nx, ny));
                                    visited[nx][ny] = true;
                                    unionCount++;
                                    unionSum += map[nx][ny];
                                }
                            }
                        }
                    }

                    // ������ �����Ǿ��ٸ� unionCount�� ������ 0�̻�
                    // ���տ� �α��� �Ȱ��� �й��Ѵ�.
                    if (unionCount > 0) {
                        int aver = unionSum / list.size();

                        for (int i = 0; i < list.size(); i++) {
                            Location current = list.get(i);
                            map[current.x][current.y] = aver;
                        }
                    }
                }
            }
        }

        // ���� �α� �̵��� ���� visited �迭�� ��� false ������ ��
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        return unionCount;
    }

    // ������ ���� �α��� ��
    // L �̻� R ���ϸ� �� ��ȯ
    static boolean checkBoundary(int cx, int cy, int nx, int ny) {
        int sub = Math.abs(map[cx][cy] - map[nx][ny]);

        if (sub >= L && sub <= R)
            return true;

        return false;
    }

    // ��ǥ
    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

//public class PopulationMovement {
//	static int[][] map = new int[50][50];
//	static int n, l, r;
//	
//	public static class POSI{
//		int x, y;
//	}
//	
//	static void create_area(int sy, int sx, int[][] status, int index, int count, int sum) {
//		int[][] visited = new int[50][50];
//
//		final int[] dy = { 0, 0, -1, +1};
//		final int[] dx = {-1, +1, 0, 0 };
//		
//		LinkedList<POSI> q = new LinkedList<POSI>();
//		POSI head = new POSI();
//		head.y = sy;
//		head.x = sx;
//		visited[sy][sx] = 1;
//		q.add(head);
//		
//		while(!q.isEmpty()) {
//			POSI cur = q.get(0);
//			q.remove();
//			
//			status[cur.y][cur.x] = index;
//			++count;
//			sum += map[cur.y][cur.x];
//			
//			for (int dir = 0; dir < 4; ++dir) {
//				POSI next = new POSI();
//				next.y = cur.y + dy[dir];
//				next.x = cur.x + dx[dir];
//				
//				if( next.y < 0 || next.x < 0 || next.y >= n || next.x >= n) {
//					continue;
//				}
//				
//				int delta = Math.abs(map[cur.y][cur.x]) - map[next.y][next.x];
//				if(visited[next.y][next.x]== 0 && l <= delta && delta <= r) {
//					visited[next.y][next.x] = 1;
//					q.add(next);
//				}
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		l = sc.nextInt();
//		r = sc.nextInt();
//		for(int y = 0; y < n; ++y) {
//			for(int x = 0; x < n; ++x) {
//				map[y][x] = sc.nextInt();
//			}
//		}
//		int ret = 0;
//		boolean is_update = true;
//		while(is_update) {
//			is_update = false;
//			
//			int[][] status = new int[50][50];
//			int area_index = 0;
//			int[] count = new int[25001];
//			int[] sum = new int[25001];
//			for (int y = 0; y < n; ++y) {
//				for (int x = 0; x < n; ++x) {
//					if (status[y][x] == 0) {
//						create_area(y, x, status, area_index, count[area_index], sum[area_index]);
//					}
//				}
//			}
//			
//			for (int y = 0; y < n; ++y) {
//				for (int x = 0; x < n; ++x) {
//					int index = status[y][x];
//					int avg = sum[index] / count[index];
//					if (map[y][x] != avg) {
//						map[y][x] = avg;
//						is_update = true;
//					}
//				}
//			}
//			if (is_update) {
//				++ret;
//			}
//			System.out.print(ret);
//		}
//	}
//}
