package student;

public class Student {
    private String name;
    private short age;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, short age) {
        this(name);
        // this.name = name;
        this.age = age;
    }

    public void displayStudent () {
        System.out.println("Student Name: " + name + " Age: " + age);
    }
}
