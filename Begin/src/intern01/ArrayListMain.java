package intern01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListMain {

	public static void main(String[] args) {
		System.out.println("ArrayList메소드");
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// 요소추가
		list.add(10);
		list.add(15);
		list.add(20);
		list.add(30);
		
		/*
		 * list[10, 15, 20, 30] 순차적으로 요소 추가
		 */
		
		list.add(3,25); // index = 3인 장소에 25요소 삽입
		/*
		 * list[10, 15, 20, 25, 30]
		 */
		
		
		// list 통합
		ArrayList<Integer> newList = new ArrayList<Integer>();
		newList.add(40);
		newList.add(50);
		newList.add(60);
		
		list.addAll(newList); // list에 newList요소들 전부 추가하는 메소드
		/*
		 * list[10, 15, 20, 25, 30, 40, 50, 60]
		 */
		
		
		list.clear(); //
		/*
		 * list[]
		 */
		
		// 요소 복제
		list = (ArrayList<Integer>) newList.clone(); //
		
		/*
		 * list[40, 50, 60]
		 */
		
		// 
		if(list.contains(50)) { //contains(Object) : ArrayList에서 특정 요소가 있는지 판단하는 메소드
			System.out.println("list안에 50 요소가 있습니다.");
		}else {
			System.out.println("list안에 50 요소가 없습니다.");
		}
		/*
		 * [list안에 50 요소가 있습니다.] 출력
		 */
		
		
		// 요소탐색
		list.add(70);
		list.add(80);
		list.add(90);
		list.add(4,75);
		System.out.println(list.indexOf(80)); // 80이란 요소를 좌->우로 검색하여 제일 처음 나온 요소의 index 출력
		System.out.println(list.lastIndexOf(80)); // 80이란 요소를 우->좌로 검색하여 제일 처음 나온 요소의 index 출력
		
		
		// 요소출력
		for(int i=0; i<list.size(); i++) {
			System.out.println(i+"번째 요소:"+list.get(i));
			//
		}
		
		//
		System.out.println(list.isEmpty()); 
		// false : 
		// true : 
		
		//ArrayList 
		Iterator<Integer> iterator = list.iterator(); // 
		while(iterator.hasNext()) {
			int next =iterator.next(); //
			if(list.contains(50)) {
				iterator.remove(); //
				
			}
		}
		System.out.println("-------------------------------");
		iterator = list.iterator();
		while (iterator.hasNext()) {
	        Integer next = iterator.next();
	        System.out.println(next);
	    }
		
		System.out.println("-------------------------------");
		
		
		ListIterator<Integer> listInterator = list.listIterator();
		while(listInterator.hasNext()) { 
			System.out.println(listInterator.next());
		}
		
		
		System.out.println("#############################");
		while(listInterator.hasPrevious()) { 
			System.out.println(listInterator.previous());
		}
		
		
		
		list.add(0,40);
		list.add(3,50); 
		list.add(110);
		list.removeAll(newList); 
		System.out.println(list);
		/*
		 * list[70, 75, 80, 90, 110]
		 */
		
		if(list.removeIf(n -> n%11 == 0)) {
			System.out.println(list);
		}
		/*
		 * list[70, 75, 80, 90]
		 */
		
		// 
		list.add(0,60);
		list.retainAll(newList); 
		System.out.println(list);
		/*
		 * list[60]
		 */
		
		//
		list.set(0, 10); 
		list.add(20);
		list.add(30);
		list.add(40);
		System.out.println(list);
		/*
		 * list[10, 20, 30, 40]
		 */
		
		
		// 
		Collections.reverse(list);
		System.out.println(list);
		/*
		 * list[40, 30, 20, 10]
		 */
		Collections.sort(list); 
		System.out.println(list);
		/*
		 * list[10, 20, 30, 40]
		 */
		
		// 
		List<Integer> subList =  list.subList(1, 3); // 
		System.out.println(subList);
		/*
		 * subList[20, 30]
		 */
		
		//
		//1. 
		Integer[]listArr = list.toArray(new Integer[list.size()]);
		//2. �迭 -> ArrayList   Arrays.asList(�迭) return�� : ArrayList<�迭�� Ÿ��>
		list = new ArrayList<Integer>(Arrays.asList(listArr));
		
		ArrayList<String>test = new ArrayList<String>();
		test.add(null);
		System.out.println(test.isEmpty());
	}

}
