package com.map;

public class Queue<T>  {
T[] array;
T peek;
int size;

void initiate(int capacity) {
	array=(T[])new Object[capacity];
	
}
void put(T value) {
	if(value !=null) {
		array[size]=value;
		size++;
		
	}
}
void reShifting() {
	int i=0;
	while(i<size) {
		array[i]=array[i+1];
		i++;
	}
}
void remove() {
	if(size>=1) {
		size--;
		reShifting();	
	}
}
T getTop() {
	return array[0];
}
public static void main(String[] args) {
	Queue<Integer> que=new Queue<Integer>();
	que.initiate(10);
	que.put(10);
	que.put(20);
	que.remove();
	System.out.println(que.getTop());
}
}
