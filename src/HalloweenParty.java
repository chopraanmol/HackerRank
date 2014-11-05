import java.util.Scanner;


public class HalloweenParty {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int numOfTests = sc.nextInt();   
	    for(int i = 0; i< numOfTests; i++){
	    	int str = sc.nextInt();
	    	System.out.println(solve(str));
	    }
	    sc.close();
	}

	private static int solve(int N) {
		if(N%2==0)
        {
                return(N/2)*(N/2);
        }
        else
        {
        	return(N/2)*(N/2 + 1);
        }
	}
}
