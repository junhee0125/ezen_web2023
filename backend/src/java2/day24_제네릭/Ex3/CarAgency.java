package java2.day24_제네릭.Ex3;

public class CarAgency  implements Rentable<Car>{
	@Override
	public Car rent() {
		// TODO Auto-generated method stub
		return new Car();
	}
}
