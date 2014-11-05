import java.util.Scanner;


public class maxXOR {

	
    static int maxXor(int l, int r) {
    	String lowStr = Integer.toBinaryString(l);
    	String highStr = Integer.toBinaryString(r);
    	if(lowStr.length() < highStr.length()) {
    		int length = lowStr.length();
    		for(int i = 0; i< highStr.length() -length; i++){
    			lowStr  = "0" + lowStr;
    		}
    	}
    	int i = 0;
    	for(; i < lowStr.length(); i++){
    		if(lowStr.charAt(i) != highStr.charAt(i)) break;
    		
    	}
    	if(i == lowStr.length() - 1 ) return 0;
    	
    	String binaryStr = "";
      	for(; i < lowStr.length(); i++){
      			binaryStr += "1";
    		
    	}  	
    	
    	return Integer.parseInt(binaryStr,2);
    	
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        in.close();
    }
    
}

