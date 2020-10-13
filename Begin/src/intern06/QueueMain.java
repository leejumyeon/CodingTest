package intern06;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {

    public static void main(String[] args) {
        // 큐 = 자료구조 중 하나로 선입선출의 형태를 갖는다.
        Queue<String> queue = new LinkedList<String>(); //큐 선언
        
        // offer(item) = 큐 안에 item요소 추가하는 메소드
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        
        // peek() = (top = 가장 먼저 출력될 요소) data를 return => 큐에서는 가장 먼저 입력된 요소 / 스택에서는 가장 최근에 입력된 요소
        System.out.println(queue.peek());
        //결과값 : A
        
        // poll() = top(가장 먼서 출력될 요소)를 큐에서 꺼내어 반환한다. 꺼내진 값은 삭제된다.
        System.out.println(queue.poll());
        //결과값 : A ->출력 후 삭제
        

    }

}
