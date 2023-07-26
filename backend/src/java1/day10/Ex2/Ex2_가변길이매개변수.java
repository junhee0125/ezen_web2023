package java1.day10.Ex2;

public class Ex2_가변길이매개변수 {
	
	public static void main(String[] args) {
		Computer mycom = new Computer();
		
		
		
		int result = mycom.sum("유재석",1,2,3);
		
		System.out.println("result  :  "+result);
		
		int result1 = mycom.sum("유재석", 1,2,3,4);
		
		System.out.println("result1  :  "+result1);
		
		
		int[] values = {1,2,3,4,5,6,7,8,9}; 
		int result2 = mycom.sum("유재석", values);
		
		System.out.println("result2  :  "+result2);
		
		
		System.out.println("result3  :  "+mycom.sum("유재석", new int[] {1,2,3,4,5,6,7,8,9,10}));
		System.out.println("result3  :  "+mycom.sum("유재석",new int[] {1,2,3,4,5,6,7,8,9,10}));
	}
	

}//class e
