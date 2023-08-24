package java2.day25_제네릭2.Ex2;

public class Ex2_와일드카드제네릭타입 {
	public static void main(String[] args) {
		//1. 모든 사람이 신청 가능
			// 1.사람 객체
		Person person = new Person();
		Worker worker = new Worker();
		Student student = new Student();
		HighStudent highStudent = new HighStudent();
		MiddleStudent middleStudent = new MiddleStudent();
			//person
		Applicant<Person> aPerson = new Applicant<Person>(person);
		Applicant<Worker> aWorker = new Applicant<Worker>(worker);
		Applicant<Student> aStudent = new Applicant<Student>(student);
		Applicant<HighStudent> aHighStudent =new Applicant<HighStudent>(highStudent);
		Applicant<MiddleStudent> aMiddleStudent = new Applicant<MiddleStudent>(middleStudent);
		
		//한번에 입력하기
		/**
		 * Course.registerCourse1(new Applicant<Person>(new Person()))
		 */
		Course.registerCourse1(aPerson);
		Course.registerCourse1(aWorker);
		Course.registerCourse1(aStudent);
		Course.registerCourse1(aHighStudent);
		Course.registerCourse1(aMiddleStudent);
		
		//학생만 신청가능
		/*  ERR : The method registerCourse2(Applicant<? extends Student>) in the type Course is not applicable for the arguments 
		(Applicant<Person>)*/
		//Course.registerCourse2(aPerson); //ERROR
		//Course.registerCourse2(aWorker); //ERROR
		Course.registerCourse2(aStudent);
		Course.registerCourse2(aHighStudent);
		Course.registerCourse2(aMiddleStudent);
		
		//학생만 신청가능
		Course.registerCourse3(aPerson);
		Course.registerCourse3(aWorker);
		//Course.registerCourse3(aStudent); //ERROR
		//Course.registerCourse3(aHighStudent); //ERROR
		//Course.registerCourse3(aMiddleStudent); //ERROR
		
	}
}
