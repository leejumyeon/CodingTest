package work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Exam2 {
	public static void main(String[] args) {
		// 1000이하의 수에서 3의 배수 또는 5의 배수들의 합을 구하라
		int sum = 0;
		for(int i=1; i<=1000; i++) {
			if(i%3==0 || i%5==0) {
				sum+=i;
			}
		}
		
		System.out.println(sum);
	}
}
