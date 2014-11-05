import java.util.Scanner;


public class ChocolateFeast {

	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    for(int i = 0; i < t; i++){
	        System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
	    }
	    in.close();
	}
	
	private static long Solve(int N, int C, int M){
		// N is the money
		// C is the price of a chocolate
		// M is the wrappers needed for one extra
		int total = 0;
		int chocolates = N/C;
		total += chocolates;
		int extra_chocs = chocolates/M;
		total += extra_chocs;
		int rem_wrappers = chocolates%M;
		
		while((extra_chocs+rem_wrappers) >= M){
			extra_chocs = (extra_chocs+rem_wrappers)/M;
			rem_wrappers = (extra_chocs+rem_wrappers)%M;
			total += extra_chocs;
		}
		
		return total ;
	    
	     //Write code to solve each of the test over here
	}
}
