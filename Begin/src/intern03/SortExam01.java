package intern03;

import java.util.Scanner;

public class SortExam01 {

	public static void main(String[] args) {
		// N개의 수가 주어졌을 때 이를 오름차순으로 정렬
		// 조건
		// 1.N의 범위는 1부터 1000까지이다.
		// 2.입력하는 수는 절댓값이 1000보다 작거나 같은 정수이다.
		// 3.입력하는 수는 중복되지 않는다.
		int[] array = new int[1001];
		int index = 0;
		int temp = 0;
		int min;

		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 수의 개수를 정하세요:");
		int number = Integer.parseInt(sc.nextLine());

		System.out.println("---정렬할 수를 입력하세요---");
		for (int i = 0; i < number; i++) {
			array[i] = Integer.parseInt(sc.nextLine());
		}

		// --- 순차정렬 --- //
	/*	
		for (int i = 0; i < number; i++) { // 배열 1차 반복
			min = 1001; // 최소값 가져오기 실행하기 전에 매번 리셋 필요
			for (int j = i; j < number; j++) { // 비교 반복(최소값 가져오기)
				if (min > array[j]) {
					index = j;
					min = array[j];
				}
			}

			temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
    */
		// --- 버블정렬 --- //
	/*
		for (int i = 0; i < number - 1; i++) {
			for (int j = i + 1; j < number; j++) {
				if (array[i] > array[j]) {
				    temp = array[j];
				    array[j] = array[i];
				    array[i] = temp;
				}
			}
		}
	*/	
		// --- 삽입정렬 --- //
	/*
		for(int i=0; i<number-1; i++) { //시작하는 수가 정렬되어 있어야 함
		    int j=i;
		    while(array[j] > array[j+1]) {
		        temp = array[j+1];
		        array[j+1] = array[j];
		        array[j] = temp;
		        j--;
		    }
		}
	*/	
		for (int i = 0; i < number; i++) {
			System.out.print(array[i] + "\t");
		}

	}

}
