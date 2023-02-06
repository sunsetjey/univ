
public class Pointc implements Cloneable{
	private int xPos;
	private int yPos;
	
	public Pointc(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public void showPosition() {
		System.out.printf("[%d, %d]", xPos, yPos);
		System.out.println();
	}
	
	static class InstanceCloning{
		public static void main(String[] args) {
			Pointc org = new Pointc(3, 5);
			Pointc cpy;
			
			try {
				cpy = org.clone();
				org.showPosition();
				cpy.showPosition();
			}
			catch(CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Pointc clone() throws CloneNotSupportedException{
		return (Pointc) super.clone();
	}
}
