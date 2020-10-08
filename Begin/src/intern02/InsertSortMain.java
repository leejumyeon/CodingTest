package intern02;

public class InsertSortMain {

	public static void main(String[] args) {
		// 삽입정렬
		int[] data = {1,9,2,4,5,6,8,7,10,3};
		int j = 0;
		int temp = 0;
		for(int i=0; i<data.length-1; i++) {
			j = i;
			while(data[j] > data[j+1]) {
				temp = data[j+1];
				data[j+1] = data[j];
				data[j] = temp;
				j--;
			}
			
			System.out.print(i+1+"번째 루틴:");
			for(int k=0; k<data.length; k++) {
				System.out.print(data[k]+"\t");
			}
			System.out.println();
		}
		
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+"\t");
		}
	}

}
