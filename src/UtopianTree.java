import java.util.Scanner;


public class UtopianTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int numOfTests = sc.nextInt();   
	    for(int i = 0; i< numOfTests; i++){
	    	int str = sc.nextInt();
	    	System.out.println(solve(str));
	    }
	    sc.close();
	}

	private static int solve(int str) {
		int height = 1;
		for(int i = 0; i < str; i++){
			if( (i % 2) == 0 ) height *= 2;
			else	height += 1;
			
		}
		return height;
	}
}
