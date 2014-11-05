import java.util.Arrays;
import java.util.Scanner;




public class CuttingBoard {
	private static final int[] NO_CUTS_AVAILABLE = {};
	
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfTests = sc.nextInt();   
        int[] costM;
        int[] costN;
        for(int i = 0; i< numOfTests; i++){
        	int m = sc.nextInt();
        	int n = sc.nextInt();
        	costM = new int[m-1];
        	costN = new int[n-1];
        	for(int j = 0; j< m-1; j++) costM[j] = sc.nextInt();
        	for(int j = 0; j< n-1; j++)	costN[j] = sc.nextInt();
    	
        	System.out.println(solve(n, m , costM, costN));
        }
        
        
        sc.close();
    }

	private static int solve(int n , int m,int[] costM, int[] costN) {
		if(n == 1 && m == 1 ) return 0;
		
		int[] copyOfN = Arrays.copyOf(costN, n-1);
		int[] copyOfM = Arrays.copyOf(costM, m-1);
		Arrays.sort(copyOfN);
		Arrays.sort(copyOfM);
		
		if(costM.length == 0){
			if(copyOfN.length == 1){
				return copyOfN[0] + solve(1, m , costM , NO_CUTS_AVAILABLE) + 
						solve(1, m , costM ,NO_CUTS_AVAILABLE);
			}
			int divideIndex = find(costN,copyOfN[copyOfN.length-1]);
			return copyOfN[copyOfN.length-1] + solve(divideIndex, 1 , costM , Arrays.copyOfRange(costN, 0, divideIndex)) + 
					solve(costN.length - divideIndex, 1 , costM , Arrays.copyOfRange(costN, divideIndex+1, costN.length));
		}
		
		if(costN.length == 0){
			if(copyOfM.length == 1){
				return copyOfM[0] + solve(n, 1 , NO_CUTS_AVAILABLE ,costN ) + 
						solve(n ,1 , NO_CUTS_AVAILABLE , costN );
			}
			int divideIndex = find(costM,copyOfM[copyOfM.length-1]);
			return copyOfN[0] + solve(1, divideIndex , Arrays.copyOfRange(costM, 0, divideIndex), costM) + 
					solve(1 ,costM.length - divideIndex, Arrays.copyOfRange(costM, divideIndex+1, costM.length), costN);
		}
			

		
		if(copyOfN[0]/m > copyOfM[0]/n){
			if(copyOfN.length == 1){
				return copyOfN[0] + solve(1, m , costM , NO_CUTS_AVAILABLE) + 
						solve(1, m , costM ,NO_CUTS_AVAILABLE);
			}
			int divideIndex = find(costN,copyOfN[0]);
			return copyOfN[0] + solve(divideIndex, m , costM , Arrays.copyOfRange(costN, 0, divideIndex)) + 
					solve(costN.length - divideIndex, m , costM , Arrays.copyOfRange(costN, divideIndex+1, costN.length));
		}else{
			if(copyOfM.length == 1){
				return copyOfM[0] + solve(n, 1 , NO_CUTS_AVAILABLE ,costN ) + 
						solve(n ,1 , NO_CUTS_AVAILABLE , costN );
			}		
			int divideIndex = find(costM,copyOfM[0]);
			return copyOfN[0] + solve(n, divideIndex , Arrays.copyOfRange(costM, 0, divideIndex), costM) + 
					solve(n ,costM.length - divideIndex, Arrays.copyOfRange(costM, divideIndex+1, costM.length), costN);
		}
	}
	
	
	public static int find(int[] array, int value) {
	    for(int i=0; i<array.length; i++) 
	         if(array[i] == value)
	             return i;
		return -1;
	}

}
