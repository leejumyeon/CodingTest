package intern02;

public class QuickSortMain {

	static int[] data = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };

	public static void main(String[] args) {
		// 퀵정렬
		quickSort(data, 0, data.length - 1);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\t");
		}

	}

	public static void quickSort(int[] data, int start, int end) {
		if (start >= end) { // 집합의 시작index가 끝index보다 크거나 같다는 의미 = 원소가 1개
			return;
		}

		int key = start; // 피벗값
		int i = start + 1; // 왼쪽에서 오른쪽으로 검사하는 시작지점
		int j = end; // 오른쪽에서 왼쪽으로 검사하는 시작지점
		int temp;
		System.out.println("key값index:" + key);
		System.out.println("좌에서 우로 검사 시작index:" + i);
		System.out.println("우에서 좌로 검사 시작index:" + j);
		while (i <= j) { // 왼쪽검사와 오른쪽검사가 엇갈릴 때까지 반복
			while (i <= end && data[i] <= data[key]) { // 배열의 범위에서 벗어나기 전까지 + key값보다 큰 수를 발견할 때까지
				i++; // 다음 칸으로 이동(좌->우)

			}

			while (j > start && data[j] >= data[key]) { // 오른쪽에서 왼쪽으로 검사하는 과정이 기준을 넘지 않을때까지 + key값보다 작은 수를 발견할 때까지
				j--;// 이전 칸으로 이동(우->좌)
			}

			if (i > j) { // 현재 엇갈린 상태면 키값과 교체
				temp = data[j];
				data[j] = data[key];
				data[key] = temp;
			} else {
				temp = data[j];
				data[j] = data[i];
				data[i] = temp;
			}
		}

		quickSort(data, start, j - 1);
		quickSort(data, j + 1, end);
	}

}
