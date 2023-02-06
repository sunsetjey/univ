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

// ArrayList 저장공간을 늘리는 과정에서 시간이 많이 소요된다.
// 인스턴스 삭제 과정에서 많은 연산이 필요할 수 있다.
// 저장된 인스턴스의 참조가 빠르다.

// 저장된 인스턴스의 참조 과정이 배열에 비해 복잡하다.
// 저장공간을 늘리는 과정이 간단하다.
// 저장된 인스턴스의 삭제 과정이 단순하다.
	
	
//	List<String>list = new LinkedList<>();
////ArrayList를 List 관점에서 보겠다, 주로 List인터페이스가 가지고 있는 기능들만을 활용하겠다.
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


