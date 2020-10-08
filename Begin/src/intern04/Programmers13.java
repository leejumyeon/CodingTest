package intern04;

public class Programmers13 {

    public static void main(String[] args) {
        // 크레인 인형뽑기 게임 //
        // 게임 화면 N x N 격자안에 1 x 1크기의 인형이 격자 가장 아래 칸부터 쌓여있다.
        // 크레인을 이용해 인형을 바구니로 이동시키는 게임
        // 인형은 동일한 인형끼리 있을 경우 터진다.
        // 게임 화면 N x N의 크기인 2차원 배열 board와 크레인을 작동시킨 위치가 담긴 배열 moves가 주어질때
        // 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구해라
        
        int[][] board = {{5,10,101,5,8},
                         {1,0,0,0,3},
                         {0,2,5,0,1},
                         {4,2,4,4,2},
                         {3,1,2,1,3}
                        };
        int[] moves = {1,5,3,5,1,2,1,4};
        int[] basket = new int[board.length*board[0].length];
        int answer = 0;
        boolean continueFlag = false;
        //board검사 = 이미 움직이기 전에 터트릴 번호가 있는지 확인
        for(int i=0; i<board.length; i++) {
            int temp = 0;
            for(int j=board[i].length-1; j>0; j--) {
                if(board[i][j]==0 && board[i][j-1]!=0) {
                    temp = board[i][j];
                    board[i][j] = board[i][j-1];
                    board[i][j-1] = temp;
                    if(j<3)j+=2;
                    else j+=1;
                    continueFlag = true;
                }
                
                else if(board[i][j]!=0 && board[i][j] == board[i][j-1]) {
                    answer++;
                    board[i][j]=0;
                    board[i][j-1]=0;
                    continueFlag = true;
                }
                
                if(continueFlag) {
                    i--;
                    continueFlag = false;
                    break;
                }
            }
        }
        
        
        int cnt = 0;
        for(int i=0; i<moves.length; i++) {
            int idx = board[moves[i]-1].length-1;
            while(idx>=0 && board[moves[i]-1][idx]==0  ) {
                idx--;
            }
            if(idx>=0) {
                basket[cnt] = board[moves[i]-1][idx];
                board[moves[i]-1][idx] = 0;
                
                if(cnt>0) {
                    for(int j=cnt; j>0; j--) {
                        int temp = 0;
                        if(basket[j]!=0 && basket[j] == basket[j-1]) {
                            answer++;
                            basket[j] = 0;
                            basket[j-1] = 0;
                        }
                        
                        else if(basket[j]==0 && basket[j-1]!=0) {
                            temp = basket[j];
                            basket[j] = basket[j-1];
                            basket[j-1] = temp;
                        }  
                    }
                }
                cnt++;
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
        
        System.out.println("basket내용");
        for(int i=0; i<cnt; i++) {
            System.out.print(basket[i]+"\t");
        }
        System.out.println();
        System.out.println("결과값:"+answer);
        
    }

}
