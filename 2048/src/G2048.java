import java.util.*;

public class G2048{
	static int n;
	static int ret;
	static class BOARD{
		int[][] map = new int[20][20];

		public final void rotate()
		{
			int[][] temp = new int[20][20];

			for (int y = 0; y < n; ++y){
				for (int x = 0; x < n; ++x)	{
					temp[y][x] = map[n - x - 1][y];
				}
			}

			for (int y = 0; y < n; ++y){
				for (int x = 0; x < n; ++x)	{
					map[y][x] = temp[y][x];
				}
			}
		}

		public int get_max()
		{
			ret = 0;
			for (int y = 0; y < n; ++y)	{
				for (int x = 0; x < n; ++x)	{
					if (ret < map[y][x])
					{
						ret = map[y][x];
					}
				}
			}
			return ret;
		}

		public final void up(){
			int[][] temp = new int[20][20];

			for (int x = 0; x < n; ++x)
			{
				int flag = 0;
				int target = -1;
				for (int y = 0; y < n; ++y)
				{
					if (map[y][x] == 0)
					{
						continue;
					}
					if (flag == 1 && map[y][x] == temp[target][x])
					{
						temp[target][x] *= 2;
						flag = 0;
					}
					else
					{
						temp[++target][x] = map[y][x];
						flag = 1;
					}
				}
				for (++target; target < n; ++target)
				{
					temp[target][x] = 0;
				}
			}
			for (int y = 0; y < n; ++y)
			{
				for (int x = 0; x < n; ++x)
				{
					map[y][x] = temp[y][x];
				}
			}
		}
	}

	static void dfs(BOARD cur, int count)
	{
		if (count == 5){
			int candi = cur.get_max();
			
			if (ret < candi) {
				ret = candi;
			}
			return;
		}

		BOARD next = new BOARD();
		for (int dir = 0; dir < 4; ++dir)
		{
			next = cur;
			next.up();
			
			dfs(next, count + 1);
			cur.rotate();
		}
	} 

	
	public static void main(String[] args){
			BOARD board = new BOARD();
			Scanner scan = new Scanner(System.in);
			n = scan.nextInt();
			for (int y = 0; y < n; ++y)
			{
				for (int x = 0; x < n; ++x)
				{
					board.map[y][x] = scan.nextInt();
				}
			}

			ret = 0;
			dfs(board, 0);
			System.out.printf("%d\n", ret);			
			
	}
}