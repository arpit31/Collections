
package com.apple;
import java.util.*;
class Fruit implements Comparable<Fruit>{
	String name;
	int quantity;
	int price;
	
	Fruit(String name,int quantity, int price){
		this.name=name;
		this.quantity=quantity;
		this.price=price;
	}
	
	public String toString() {
		return "name: "+this.name+" quantity: "+this.quantity+" price: "+this.price;
	}

	@Override
	public int compareTo(Fruit o) {
		
		return this.price-o.price;
	}
	
	public static Comparator<Fruit> FruitNameComparator
    = new Comparator<Fruit>() {

public int compare(Fruit fruit1, Fruit fruit2) {

return fruit1.name.compareTo(fruit2.name);

}

};
}
public class ComparableAndComparator {
public static void main(String[] args) {
	
	List <Fruit> list=new ArrayList<Fruit>();
	list.add(new Fruit("Oragne",2,100));
	list.add(new Fruit("Apple",3,150));
	list.add(new Fruit("Banana",4,10));
	list.add(new Fruit("Pineapple",1,70));
	System.out.println(list.toString());
	Collections.sort(list);
	System.out.println(list.toString());
	
	Collections.sort(list, Fruit.FruitNameComparator);
}
}
//name: Banana quantity: 4 price: 10, name: Pineapple quantity: 1 price: 70, name: Oragne quantity: 2 price: 100, name: Apple quantity: 3 price: 150]
