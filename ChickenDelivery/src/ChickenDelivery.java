import java.util.*;

class POSI {
	public int y;
	public int x;
}

public class ChickenDelivery {
	public static int n;
	public static int m;
	public static int type;
	public static int ret;
	public static ArrayList<POSI> house = new ArrayList<POSI>();
	public static ArrayList<POSI> shop = new ArrayList<POSI>();
	public static ArrayList<POSI> pick = new ArrayList<POSI>();

	public static void dfs(int pos) {
		if (pick.size() == m) {
			int candi = 0;
			
			for (int i = 0; i < house.size(); i++) {
				int min_dist = 1000000;
				for (int j = 0; j < pick.size(); j++) {
					min_dist = Math.min(min_dist,
							Math.abs(house.get(i).y - pick.get(j).y) + 
							Math.abs(house.get(i).x - pick.get(j).x));
				}
				candi += min_dist;
			}
			
			if (ret > candi) {
				   ret = candi;
			}
		}

		for (int i = pos; i < shop.size(); ++i)	{
			pick.add(shop.get(i));
			dfs(i + 1);
			pick.remove(pick.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int y = 0; y < n; ++y) {
			for( int x = 0; x < n; ++ x) {
				POSI target = new POSI();
				type = sc.nextInt();
				if (type == 1) {
					target.y = y;
					target.x = x;
					house.add(target);
				}
				if (type == 2) {
					target.y = y;
					target.x = x;
					shop.add(target);
				}
			}
		}
		ret = 0x7fffffff;
	    dfs(0);
		System.out.printf("%d\n", ret);
	}
}
