import java.util.Scanner;


public class LoveLetter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int numOfTests = sc.nextInt();   
	    for(int i = 0; i< numOfTests; i++){
	    	String str = sc.next();
	    	System.out.println(solve(str));
	    }
	    sc.close();
	}

	private static int solve(String str) {
		if(str.length() == 0 || str.length() == 1) return 0;
		
		char start = str.charAt(0);
		char end = str.charAt(str.length()-1);
		
		return Math.abs(start - end) + solve(str.substring(1, str.length()-1 ) );
	}
}
