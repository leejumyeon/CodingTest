package intern04;

public class Programmers05 {

    public static void main(String[] args) {
        // 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과다.
        // 2개의 행렬 arr1과 arr2를 입력받아 행렬 덧셈의 결과를 반환해라
        // 조건1. 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않는다.
        
        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = {{3,4},{5,6}};
        
        int[][] answer = new int[arr1.length][arr1[0].length];
        for(int i=0; i<answer.length; i++) {
            for(int j=0; j<answer[i].length; j++) {
                answer[i][j] = arr1[i][j]+arr2[i][j];
            }
        }
        
        for(int i=0; i<answer.length; i++) {
            for(int j=0; j<answer[i].length; j++) {
                System.out.print(answer[i][j]+"\t");
            }
            System.out.println();
        }

    }

}
