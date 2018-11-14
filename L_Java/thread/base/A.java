package base;

public class A {
    private String sex;

    private String name;

    private int age;

    public A() {

    }
    public A(String sex) {
        this.sex = sex;
    }
    public A(String sex, String name) {
        this.sex = sex;
        this.name= name;
    }

    public A(String sex, String name, int age) {
        this.sex = sex;
        this.name= name;
        this.age = age;
    }

    public void eat() {
        System.out.println(name + "在吃饭");
    }

    public void whatSex() {
        System.out.println(name + "的性别是" + sex );
    }

    public static void main(String[] args) {
        A a = new A("man", "Java");
        a.eat();
        a.whatSex();
    }

}
