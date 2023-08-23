package java2.day24_제네릭.Ex3;

public class HomeAgency implements Rentable<Home>{
	@Override
	public Home rent() {
		// TODO Auto-generated method stub
		return new Home();
	}

}
