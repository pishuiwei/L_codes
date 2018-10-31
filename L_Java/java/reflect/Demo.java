package reflect;

public class Demo{
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class<?> class1 = Class.forName("com.pp.learn.reflect.Person");
		Person persson = (Person)class1.newInstance();
		System.out.println(persson.name);
		Class<?> class2 = int.class;
		System.out.println(class2.getSimpleName());
	}
}

/**内部类*/ 
class Person extends Demo{	
	public String name = "pp";
	
	public Person() {
		System.out.println(name);
	}

}
