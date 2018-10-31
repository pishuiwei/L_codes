package generic;

import base.P;

public class GenericDemo<E> {
	
	private E value;
	
	public GenericDemo(E value){
		this.value = value;
	}
	
	public void say(){
		P.println(this.value);
	}
	
	public E tell(E e){
		return e;
	}
	
	public <T> T a(T t){
		return t;
	}
	
	public <T> T[] f(T[] t){
		return t; 
	}
	
	public static void main(String[] args) {
		/**
		 * 通配符 ?
		 */
		GenericDemo<String> genericTest = new GenericDemo<String>("pp");
		genericTest.say();
		genericTest.tell("哈哈");
		
	}
}

//泛型接口
interface demo<E>{
	
}