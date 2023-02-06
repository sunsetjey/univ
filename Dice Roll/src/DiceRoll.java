import java.util.*;

public class DiceRoll {
	static int n; // 지도의 세로크기
	static int m; // 지도의 가로크기
	static int sy; // 시작 좌표 y
	static int sx; // 시작 좌표 x
	static int k; // 명령의 개수
	static int[][] map = new int[20][20]; // 맵크기는 고정

	final static int[] dy = {0, 0, -1, +1};
	final static int[] dx = {+1, -1, 0, 0};
	
	static int[] dice = new int[6]; //주사위 생성
	
	static void move_dice(int dir) {
		int[] ndice = new int[6];
		switch(dir) {
		case 0:
			ndice[0] = dice[0];
			ndice[5] = dice[1];
			ndice[2] = dice[2];
			ndice[4] = dice[3];
			ndice[1] = dice[4];
			ndice[3] = dice[5];
			break;
		case 1:
			ndice[0] = dice[0];
			ndice[4] = dice[1];
			ndice[2] = dice[2];
			ndice[5] = dice[3];
			ndice[3] = dice[4];
			ndice[1] = dice[5];
			break;
		case 2:
			ndice[3] = dice[0];
			ndice[0] = dice[1];
			ndice[1] = dice[2];
			ndice[2] = dice[3];
			ndice[4] = dice[4];
			ndice[5] = dice[5];
			break;
		case 3:
			ndice[1] = dice[0];
			ndice[2] = dice[1];
			ndice[3] = dice[2];
			ndice[0] = dice[3];
			ndice[4] = dice[4];
			ndice[5] = dice[5];
			break;
		default:
			break;
			
		}
		
		for(int i = 0; i < 6; ++i) {
			dice[i] = ndice[i];
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		sy = scan.nextInt();
		sx = scan.nextInt();
		k = scan.nextInt();
		
		for (int y = 0; y < n; ++y) {
			for(int x = 0; x < m; ++x) {
				map[y][x] = scan.nextInt();// 지도상에 값을 채움
			}
		}
		
		int dir;
		for (int i = 0; i < k; ++i) {
			dir = scan.nextInt();
			--dir;
			int ny = sy + dy[dir];
			int nx = sx + dx[dir];
			
			if(ny < 0 || ny >= n || nx < 0 || nx >= m) {
				continue;
			}
			
			move_dice(dir);
			
			if(map[ny][nx] == 0) {
				map[ny][nx] = dice[3];
			}
			else {
				dice[3] = map[ny][nx];
				map[ny][nx] = 0;
			}
			
			sy = ny;
			sx = nx;
			
			System.out.printf("%d \n", dice[1]);
		}
	}
}
