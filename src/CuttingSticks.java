import java.util.*;


public class CuttingSticks {

	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int numOfTests = sc.nextInt();
		int[] arr = new int[numOfTests];
		
		for(int i = 0; i < numOfTests; i++){
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		solve(arr, 0);		
		sc.close();
	}

	private static void solve(int[] arr, int index) {
		int removed = arr[index];
		int size = arr.length;
		int count = 0;
		int becomeZero =index;
		for(int i = index; i < size; i++){
			if(arr[i] != 0){
				arr[i] -= removed; 
				count++;
				if(arr[i] == 0) becomeZero++;
			}		
		}
		
		System.out.println(count);
		if(becomeZero == size) return;
		solve(arr, becomeZero);
	}
}
