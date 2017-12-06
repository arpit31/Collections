package com.apple;
import java.util.*;

class Person{
	int age;
	String name;
	
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString() {
		
		return "name "+this.name +" age "+this.age;
	}
	
	public boolean equals(Object obj) {
		return this.age==((Person)obj).age;
	}
	public int hashCode(){
		return this.age;
	}
	
}
public class SetExample {
public static void main(String[] args) {
	Set<Person> set=new HashSet<Person>();
	set.add(new Person("P",20));
	set.add(new Person("H",20));
	set.add(new Person("P",20));
	set.add(new Person("P",20));
	for(Person p:set) {
		System.out.println(p.toString());
	}
	
}
}
/*Op if equals(Object obj) and hashCode() not implemented
name P age 20
name P age 20
name P age 20
name H age 20
*/

/*Op
name P age 20
*/