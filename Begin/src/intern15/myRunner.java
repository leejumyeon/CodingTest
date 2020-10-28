package intern15;

public class myRunner implements Runnable {

    @Override
    public void run() {
        long sum = 0;
        for(long i = 1L; i<=1000000000; i++) {
            sum+=i;
        }
        System.out.println("합계: "+sum);
    }
}
