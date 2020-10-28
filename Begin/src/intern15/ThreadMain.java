package intern15;

public class ThreadMain {

    public static void main(String[] args) {
        // 멀티Thread 생성
        // 방법1 : Thread클래스를 상속한 class의 인스턴스를 생성 후,
        //        이 인스턴스의 start()메소드를 호출한다.
        MyThread1 th1 = new MyThread1();
        th1.start(); //run()으로 실행하면 single thread 방식으로 진행된다.
        
        // 방법2 : Runnable인터페이스를 구현한 클래스의 인스턴스를 생성 후,
        //        이 인스턴스를 Thread 객체의 인스턴스를 생성할 때 생성자의 매개변수로 넘겨준다.
        //        이 때 생성된 Thread 객체의 인스턴스의 start()메소드를 호출한다.
        MyThread2 r1 = new MyThread2(); //Runnable용
        Thread th2 = new Thread(r1);
        th2.start();
        
        // 방법3 : 익명클래스를 이용하는 방법
        //        Runnable인터페이스를 구현한 익명클래스를 Thread 인스턴스를 생성할 때 매개변수로 넘겨준다.
        Thread th3 = new Thread(new Runnable() { 
            @Override
            public void run() {
               for(int i=1; i<=200; i++) {
                   System.out.print("쿠");
                   try {
                           Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
               }
            }
        });
        th3.start();
        System.out.println("main 메소드 퇴근!!!");
    }

}
