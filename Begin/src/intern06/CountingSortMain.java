package intern06;

public class CountingSortMain {

    public static void main(String[] args) {
        // 계수정렬 - 정렬하고자 하는 내용이 특정범위인 경우에 다른 정렬방법보다 빠르게 정렬을 할 수 있다.
        int[] array = {1,3,2,4,3,2,5,3,1,2,3,4,4,3,5,1,2,3,5,2,3,1,4,3,2,5,1,1,1,1};
        int[] count = new int[5]; //특정범위의 값들의 갯수를 담을 배열 각각의 방[0]~[4]는 1~5에 해당한다.
        
        //갯수를 담는 방의 초기화
        for(int i=0; i<count.length; i++) {
            count[i] = 0;
        }
        
        //카운팅
        for(int i=0; i<array.length; i++) {
            count[array[i]-1]++; //array[i]에 해당하는 값은 count[]에서 그 값에서 -1한 index에 카운트 된다.
        }
        
        //카운팅한 수 만큼 정렬(출력)
        for(int i=0; i<count.length; i++) {
            for(int j=0; j<count[i]; j++) {
                System.out.print(i+1+"\t");
            }
        }

    }

}
