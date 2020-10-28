package intern15;

// Thread클래스를 상속한 class의 인스턴스를 생성한 후, 
// 이 인스턴스의 start()메소드를 호출하는 것으로 Thread를 사용할 수 있다.
public class MyThread1 extends Thread{
    
    @Override
    public void run() { // Thread클래스의 main 역할을 하는 run() 메소드
        for(int i=1; i<=200; i++) {
            System.out.print("쿵");
            try {
                Thread.sleep(100);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
