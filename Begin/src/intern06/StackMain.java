package intern06;

import java.util.Stack;

public class StackMain {

    public static void main(String[] args) {
        // 스택 = 자료구조 중 하나로 선입후출의 형태를 갖는다.
        Stack<String> stack = new Stack<String>();
        
        // push(item) = stack에 item을 추가하는 메소드 가장 처음 추가된 것이 가장 늦게 출력된다.
        stack.push("A");
        stack.push("B");
        stack.push("C");
        
        // peek() = 최근에 추가된 데이터(Top) 조회
        System.out.println(stack.peek());
        //결과값 : C
        
        // pop() = 최근에 추가된 데이터(Top) 삭제
        stack.pop();
        System.out.println(stack.peek());
        //결과값 : B
        
        // search(item) = 해당 item이 위치하는 순번을 출력
        System.out.println(stack.search("B"));
        //결과값 : 1
        
        // empty = 스택이 비어있는지 boolean값으로 반환
        System.out.println(stack.empty());
        //결과값 : false

    }

}
