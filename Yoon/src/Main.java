import java.util.*;

public class Main {
	public static void main (String[] args) {
		Set<String> set = new HashSet<>();
		set.add("Toy");
		set.add("Box");
		set.add("Robot");
		set.add("Box");
		
		System.out.println(set.size());
		
		for (String s : set) {
			System.out.print(s + "\t");
		}
	}
}

// ArrayList ��������� �ø��� �������� �ð��� ���� �ҿ�ȴ�.
// �ν��Ͻ� ���� �������� ���� ������ �ʿ��� �� �ִ�.
// ����� �ν��Ͻ��� ������ ������.

// ����� �ν��Ͻ��� ���� ������ �迭�� ���� �����ϴ�.
// ��������� �ø��� ������ �����ϴ�.
// ����� �ν��Ͻ��� ���� ������ �ܼ��ϴ�.
	
	
//	List<String>list = new LinkedList<>();
////ArrayList�� List �������� ���ڴ�, �ַ� List�������̽��� ������ �ִ� ��ɵ鸸�� Ȱ���ϰڴ�.
//		Iterator<String> itr = list.iterator();		
//		
//		list.add("Toy");
//		list.add("Box");
//		list.add("Robot");
//		list.add("Box");
//		
//		itr = list.iterator();
//		while(itr.hasNext()) {
//			System.out.print(itr.next() + '\t');
//		}
//		
//		
//		Iterator<String> itr1 = list.iterator();		
//		
//		List<String> list1 = Arrays.asList("Toy", "Box", "Robot", "Box");
//		list1 = new ArrayList<>(list1);
//		list1 = new LinkedList<>(list1);
//		
//		itr1 = list1.iterator();
//		while(itr1.hasNext()) {
//			System.out.print(itr1.next() + '\t');
//		}
//		
//		
//		
//		String str;
//		while(itr.hasNext()) {
//			str = itr.next();
//			if(str.equals("Box"));{
//				itr.remove();
//			}
//		}
		

//		
//		for(String s : list) {
//			System.out.print(s + 't');
//		}
//	}


