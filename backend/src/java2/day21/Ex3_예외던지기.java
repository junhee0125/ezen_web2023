package java2.day21;

public class Ex3_예외던지기 {
	public static void main(String[] args) {
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Unhandled exception type ClassNotFoundException
	}
	
	
	public static void findClass() throws ClassNotFoundException {
		Class.forName("java.lang.String2"); //Unhandled exception type ClassNotFoundException
		
	}
}
