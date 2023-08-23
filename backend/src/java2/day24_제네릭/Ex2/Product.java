package java2.day24_제네릭.Ex2;

public class Product<K,M> {
	// 제품[Product] 클래스 안에 자동차 [Car]객체도 넣고 싶고, 
	// 전자제품[TV]도 넣고 싶을때

	/*
	 	제네릭은 클래스 안으로 들어오는 파라미터(뱐수=정해져있지않은 타입)[ 매개타입]
	 	제네릭 매개타입 이름 : A~Z 대문자 알파벳 권장
	 	제네릭 타입이 여러개이면 <A, B, c>
	 	장점 : 클래스 설계시 필드에 다양한 타입으로 선언.
	 * */
	private K kind;
	private M medel;
	
	
	
	// 메소드
	public K getKind() {
		return kind;
	}
	public void setKind(K kind) {
		this.kind = kind;
	}
	public M getMedel() {
		return medel;
	}
	public void setMedel(M medel) {
		this.medel = medel;
	}
	
	
	
}
