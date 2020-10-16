package intern07;

import java.util.HashMap;
import java.util.Set;

public class HashMapMain {

    public static void main(String[] args) {
        // HashMap 메소드 기능
        HashMap<String, Integer> hMap = new HashMap<String, Integer>();
        HashMap<String, Integer> hMap2 = new HashMap<String, Integer>();
        
        // put(key, value) = 각 Key,Value에 대한 타입에 맞게 선언하여 map객체에 data를 저장하는 메소드
        hMap.put("신논현", 1);
        hMap.put("강남", 2);
        hMap.put("혜화", 3);
        hMap.put("안양", 4);
        hMap.put("수원", 5);
        
        hMap2.put("천안", 6);
        hMap2.put("양평", 7);
        hMap2.put("장성", 8);
        hMap2.put("부산", 9);
        hMap2.put("파주", 10);
        
        // putAll(Map m) : Map에 또다른 Map을 추가하는 메소드
        hMap.putAll(hMap2); //hMap에 hMap2의 데이터가 추가된다.
        
        // size : HashMap에 저장된 요소의 개수를 return하는 메소드
        System.out.println(hMap.size()); //결과값 : 10
        
        // remove(Object key) : 하나의 key를 입력하여 데이터를 삭제하는 메소드
        hMap.remove("천안"); // hMap에서 "천안"이라는 String타입의 key를 갖고있는 data가 삭제된다.
        
        // values() : HashMap에 저장된 요소들을 전부 컬렉션 형태로 출력하는 메소드
        System.out.println(hMap.values());
        // 결과값 : [5, 7, 4, 3, 8, 2, 9, 1, 10] = 요소들이 저장된 장소는 HashMap에서 임의로 만들어진(hashMethod를 사용) index(hashCode)를 사용한 것이다.

        // get(Object key) : HashMap에서 key값에 대한 요소를 갖고오는 메소드
        System.out.println(hMap.get("강남")); //결과값 : 2
        // HashMap에 없는 key값을 입력하면 null이 반환된다.
        
        // clear() : HashMap에 있는 요소들을 비워내는 메소드
        hMap2.clear();
        
        // clone() : 해당 HashMap의 요소들을 복제하는 메소드
        hMap2 = (HashMap<String, Integer>) hMap.clone();
        // clone()의 return값은 Object이므로 다른 컬랙션에 대입하기 위해서는 casting이 필요하다.
        
        // isEmpty() : 컬렉션에서 요소의 유무를 체크하여 boolean값을 return 하는 메소드
        System.out.println("isEmpty():"+hMap.isEmpty());
        // 요소를 갖고있지 않으면 true, 요소를 갖고 있다면 false값이 출력
        
        // containsKey(Object key) : HashMap에서 key를 포함하는 요소가 있는지 여부를 boolean값으로 return하는 메소드
        System.out.println("containsKey(\"부산\"):"+hMap.containsKey("부산")); //결과값 : true
        
        // containsValue(Object value) : HashMap에서 value를 포함하는 요소가 있는지 여부를 boolean값으로 return하는 메소드
        System.out.println("containsValue(6):"+hMap.containsValue(6)); //결과값 : false
        
        // entrySet() : HashMap에 저장된 key, value값을 엔트리(key와 value를 결합)의 형태로 Set에 저장하여 return하는 메소드
        Set set = hMap.entrySet();
        System.out.println(set); // [수원=5, 양평=7, 안양=4, 혜화=3, 장성=8, 강남=2, 부산=9, 신논현=1, 파주=10]
        
        // keySet() : HashMap에 저장된 key값을 모두 return하는 메소드
        System.out.println(hMap.keySet()); // [수원, 양평, 안양, 혜화, 장성, 강남, 부산, 신논현, 파주]
    }

}
