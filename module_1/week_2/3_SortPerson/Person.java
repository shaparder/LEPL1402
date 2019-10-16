import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Person {

	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name + " " + age;
	}

	public static void sortPerson(ArrayList<Person> persons){
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				int r;
				if (p1.name.equals(p2.name)) {
					r = ((p1.age > p2.age) ? 1 : -1);
				} else {
					r = p1.name.compareTo(p2.name);
				}
				return r;
			}
		});
	}

	public static void main(String[] args) {
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person("Guillaume",20));
		persons.add(new Person("John",50));
		persons.add(new Person("Guillaume",10));
		persons.add(new Person("John",10));
		persons.add(new Person("Luc",5));

		sortPerson(persons);
		System.out.println(persons);
	}
}
