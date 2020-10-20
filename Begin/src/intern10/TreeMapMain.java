package intern10;

import java.util.HashMap;
import java.util.TreeMap;

public class TreeMapMain {

    public static void main(String[] args) {
        // Tree Map method 내용 //
        TreeMap<Integer, String> tMap = new TreeMap<Integer, String>();
        HashMap<Integer, String> hMap = new HashMap<>();
        
        // put(key, value) : TreeMap에 객체를 담는 메소드
        tMap.put(1, "A");
        tMap.put(2, "B");
        tMap.put(3, "C");
        tMap.put(4, "D");
        tMap.put(5, "E");
        tMap.put(6, "F");
        tMap.put(8, null);
        
        hMap.put(35, "a");
        hMap.put(12, "b");
        hMap.put(13, "c");
        hMap.put(14, "d");
        hMap.put(15, "e");
        hMap.put(16, "f");
        hMap.put(17, "g");
        hMap.put(18, "h");
        hMap.put(19, "i");
        
        
        // ceilingEntry(key) : 해당 맵에서 전달된 키와 같거나, 전달된 키보다 큰 키보다 큰 키 중에서 가장 작은 키를 갖는 entry를 반환
                             //만약 해당하는 키가 없으면 null을 반환
        System.out.println(tMap.ceilingEntry(5)); // 8=H
        
        // containsKey(key) : 해당 맵이 전달된 키를 포함하고 있는지를 확인하는 메소드
        System.out.println(tMap.containsKey(6)); //true
        
        System.out.println(tMap.containsValue("A"));
        
        System.out.println(tMap.get(3));
        
        
        
        tMap.putAll(hMap);
        System.out.println(tMap.values());
        
        
        System.out.println(tMap.size());
        tMap.remove(13);
        System.out.println(tMap.values());
        
        // clear() : treemap 초기화
        tMap.clear();
        
       
        

    }

}
