
public class Person {
	String name;
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	protected void finalize() throws Throwable{
		super.finalize();
		System.out.println("destroyed: " + name);
	}
	public static void main(String[] args) {
		Person p1 = new Person("Yoon");
		Person p2 = new Person("Park");
		p1 = null;
		p2 = null;
		// System.gc();				// 체크요청
		// System.runFinalization();	// 삭제요청
		
		System.out.println("end of program");
	}
}
