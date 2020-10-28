package work;

import java.util.Arrays;
import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		// 문자열을 뒤집어 출력하는 revers()를 구현해라
		Exam5 test = new Exam5();
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요:");
		String str = sc.nextLine();
		String result1 = test.reverse(str);
		String result2 = test.reverse2(str);
		String result3 = test.reverse3(str);
		
		System.out.println("result1:"+result1);
		System.out.println("result2:"+result2);
		System.out.println("result3:"+result3);
		
	}
	
	// 새로운 문자열을 만들어 기존 문자열의 뒷자리 부터 작성하는 방법
	public String reverse(String s) {
		int len = s.length();
		String result = "";
		for(int i=len-1; i>=0; i--) {
			result += s.charAt(i);
		}
		return result;
	}
	
	// 문자열에서 앞뒤로 문자를 교체하는 방법
	public String reverse2(String s) {
		int len = s.length();
		char[] tempArr = s.toCharArray();
		char temp = ' ';
		for(int i=0; i<len/2; i++) {
			temp = tempArr[i];
			tempArr[i] = tempArr[len-(1+i)];
			tempArr[len-(1+i)] = temp;
		}
		String result = String.valueOf(tempArr);
		return result;
	}
	
	// Stringbuffer를 사용한 방법
	public String reverse3(String s) {
		StringBuffer strbuffer = new StringBuffer();
		strbuffer.append(s);
		return strbuffer.reverse().toString();
	}

}
