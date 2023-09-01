package java2.day28_컬렉션프레임워크3.Ex4_사용자정의정렬;

import java.util.TreeSet;

public class Ex4_예제 {

	public static void main(String[] args) {

		//1. Fruit 정렬 구현객체생성
		FruitComparator fruitComparator =  new  FruitComparator();

		//2. TreeSet객체 생성
		TreeSet<Fruit>  treeSet = new TreeSet<>(fruitComparator);

		//3. 무작위 Friut 객체 대입
		treeSet.add( new Fruit("포도" ,3000));
		treeSet.add(new Fruit("바나나" , 5000));
		treeSet.add(new Fruit("딱딱이복숭아",  4900));
		treeSet.add(new Fruit("참외수박",9000));

		System.out.println("이진트리상태 : " + treeSet);
		// 이진트리상태 : [Fruit [name=포도, price=3000], Fruit [name=딱딱이복숭아, price=4900], Fruit [name=바나나, price=5000], Fruit [name=참외수박, price=9000]]

	}
}
