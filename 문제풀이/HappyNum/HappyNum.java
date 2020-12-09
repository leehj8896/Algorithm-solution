import java.util.Vector;
import java.util.Scanner;

public class HappyNum {
	
	//각 자리수의 제곱 합을 구하는 함수
	public static int get(int n) {		
		
		int sum = 0;
		
		while(n != 0) {
			sum += (n % 10) * (n % 10);
			n = n / 10;			
		}
		
		return sum;
	}	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스
		int t = sc.nextInt();		
		
		
		for(int i = 0; i < t; i++) {
			
			//숫자 입력
		    int n = sc.nextInt();
		
		    int temp = n;
		    Vector<Integer> v = new Vector<Integer>();

		    while(true){
	    		
		    	//벡터에 추가
		    	v.addElement(temp);
		    	
		    	temp = get(temp);
						
		    	if(temp == 1) {
		    		System.out.println("HAPPY");
		    		break;
	    		}				
			
		    	//벡터에 이미 존재
	    		if(v.contains(temp)) {
	    			System.out.println("UNHAPPY");
	    			break;
	    		}				
    		}	
		}
	}
}
