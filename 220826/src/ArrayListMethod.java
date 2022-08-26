import java.util.ArrayList;

public class ArrayListMethod {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		
//		add(value): ArrayList의 맨 뒤에 value를 추가
		list.add("홍길동");
		System.out.println(list);
//		size(): ArrayList에 저장된 데이터의 개수를 얻어온다.	
		System.out.println(list.size() + ": " + list);
		list.add("임꺽정");
		System.out.println(list.size() + ": " + list);
		list.add("장길산");
		System.out.println(list.size() + ": " + list);
		list.add("일지매");
		System.out.println(list.size() + ": " + list);
		list.add("홍길동");
		System.out.println(list.size() + ": " + list);
		
		
//		add(index, value): ArrayList의 index 번째 위치에 value를 삽입한다.
		list.add(1, "손오공");
		System.out.println(list.size() + ": " + list);
		
		
//		set(index, value): ArrayList의 index 번째 위치의 데이터를 value로 수정한다.
		list.set(1, "저팔계");
		System.out.println(list.size() + ": " + list);
		
		
//		get(index): ArrayList의 index번째 위치의 데이터를 얻어온다.
		System.out.println(list.get(1));
		
		
		// 일반 for
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 향상된 for
		for (String str : list) {
			System.out.println(str);
		}
		
		
//		remove(index): ArrayList의 index번째 위치의 데이터를 제거
		list.remove(1);
		System.out.println(list.size() + ": " + list);
		
//		remove(object): ArrayList의 인수로 지정된 데이터를 제거
		list.remove("장길산");
		System.out.println(list.size() + ": " + list);
		list.remove("홍길동");
		System.out.println(list.size() + ": " + list);
		
		
//		clear(): ArrayList에 저장된 모든 데이터를 삭제
		list.clear();
		System.out.println(list.size() + ": " + list);
		
	}

}
