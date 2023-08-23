package java2.day24_제네릭.Ex2;

public class Ex2_제네릭 {
	public static void main(String[] args) {
	
		//1. product 객체를 만드는데 Tv 객체를 가지고 있는
		
			// product 객체 만들때, 필드에 사용할 타입 구체적으로 대임
		Product<Tv,String>  product1 = new Product<>();  
			//productrorcp[Tv kine [ null; String  model = null;] 필드의 초기값
		product1.setKind(new Tv());
		product1.setMedel("스마트TV");
			
			//product객체 [Tv kind = new Tv(); String  model= "스마트폰";]
		Tv tv = product1.getKind();
		String tvModel = product1.getMedel();
		

		
		
		/* 다른 제네릭 타입의 객체를 생성하고 싶을 때는 새로운 객체를 생성해야함
		 * 몽말이냐면..
		 * TV로 product객체를 만드었는ㄷ.  car를 넣고ㅓ 싶으면 그대로 ㅆ쓸순 없고 다시 만들어야
		 * */
		//2. product 객체를 만드는데 Car 객체를 가지고 있는
		
		Product<Car, String> product2 = new Product<>();
		
		product2.setKind(new  Car());
		product2.setMedel("SUV");
		Car car = product2.getKind();
		String carModel = product2.getMedel();
		
	}
}
