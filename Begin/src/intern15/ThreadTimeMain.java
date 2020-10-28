package intern15;

public class ThreadTimeMain {

    public static void main(String[] args) {
        // thread 수행시간 체크 //
        Thread th = new Thread(new myRunner());
        long startTime = System.currentTimeMillis();
        th.start();
        
        try {
            th.join();//현재 실행중인 thread에서 작업중인 thread(th)가 종료될 때까지 기다린다는 method
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("경과시간:"+(endTime - startTime)+"ms");
        System.out.println("메인 끝");
        

    }

}
