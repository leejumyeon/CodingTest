package intern03;

import java.util.Scanner;

public class SortExam03 {

	public static void main(String[] args) {
        // 입력한 단어를 길이가 짧은 순으로 출력
	    // 단어의 길이가 같을 경우에는 사전순서로 배치
        // 단, 같은 단어가 여러번 입력된 경우에는 한번식만 출력한다.
        String[] wordArr = new String[20001];
        Scanner sc = new Scanner(System.in);
        int wordCnt = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < wordCnt; i++) {
            wordArr[i] = sc.nextLine();
        }
        
        sc.close();

        wordArr = quickSort(wordArr, 0, wordCnt - 1); // 글자수 정렬
        
        for (int i = 0; i < wordCnt - 1; i++) {// 0부터 마지막의 바로 앞까지 반복
            String temp="";
            for (int j = i + 1; j < wordCnt; j++) {// 위의 시작지점 다음부터 끝까지의 반복
                if (wordArr[i].length() == wordArr[j].length()) { //글자수가 같다면
                	if(wordArr[i].equals(wordArr[j])) { //완전히 동일한 단어일 경우 
                		System.arraycopy(wordArr, j+1, wordArr, j, wordCnt-j); //1개는 삭제 시킨다.
                		j--;
                		wordCnt--;
                		continue;
                	}
                	int k=0;
                	boolean actFlag = false; //위치변환 과정이 끝났는지 확인하는 용도의 변수
                    do {
                    	if (wordArr[i].charAt(k) > wordArr[j].charAt(k)) {//i위치의 k번째 단어값이 j위치의 k번째 단어값보다 크면 i와 j의 위치 이동
                            temp = wordArr[j];
                            wordArr[j] = wordArr[i];
                            wordArr[i] = temp;
                            actFlag = true;
                        }
                    	else if(wordArr[i].charAt(k) < wordArr[j].charAt(k)) {//위치변환이 필요없으니 actFlag를 true로 하여 확인검사 종료시키기
                    	    actFlag = true;
                    	}
                    	k++;
                    }while(!(actFlag || k>=wordArr[i].length()));
					
                }
            }
        }
        
        System.out.println("최종결과값-----------------");
        for (int t = 0; t < wordCnt; t++) {
            System.out.print(wordArr[t]+"\t");
        }
        System.out.println();
        
        
        

    }

	private static String[] quickSort(String[] array, int start, int end) {
		if (start >= end) { // 재귀 종료 시점
			return array;
		}

		int key = start; // 피벗값
		int i = start + 1; // 왼쪽에서 오른쪽으로 검사하는 시작지점
		int j = end; // 오른쪽에서 왼쪽으로 검사하는 시작지점
		String temp;

		while (i <= j) { // 왼쪽검사와 오른쪽검사가 엇갈릴 때까지 반복
			while (i <= end && array[i].length() <= array[key].length()) { // 배열의 범위에서 벗어나기 전까지 + key값보다 큰 수를 발견할 때까지
				i++; // 다음 칸으로 이동(좌->우)

			}

			while (j > start && array[j].length() >= array[key].length()) { // 오른쪽에서 왼쪽으로 검사하는 과정이 기준을 넘지 않을때까지 + key값보다
																			// 작은 수를 발견할 때까지
				j--;// 이전 칸으로 이동(우->좌)
			}

			if (i > j) { // 현재 엇갈린 상태면 키값과 교체
				temp = array[j];
				array[j] = array[key];
				array[key] = temp;
			} else {
				temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}

		array = quickSort(array, start, j - 1); // 피벗값 이동 후 앞부분 집합(피벗보다 작은 값)
		array = quickSort(array, j + 1, end); // 피벗값 이동 후 뒷부분 집합(피벗보다 큰 값)

		return array;
	}

}
