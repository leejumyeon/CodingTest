package intern15;
// Runnable 인터페이스를 구현한 클래스의 인스턴스를 생성한 후 
// 이 인스턴스를 Thread 객체의 인스턴스 생성할 때 생성자의 매개변수로 넘겨준다.
// 이 때 생성된 Thread 객체의 인스턴스의 start()메서드를 호출한다.
public class MyThread2 implements Runnable {

    @Override
    public void run() {
        for(int i=1; i<=200; i++) {
            System.out.print("짝");
            try {
                Thread.sleep(100); //주어진 시간(ms)동안 작업을 잠시 멈춘다.
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
