package practice02;

public class Student extends Person{
    private Integer klass;

    public Student(String name, int age, Integer klass) {
        super(name, age);
        this.klass = klass;
    }

    public int getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        return String.format("I am a Student. I am at Class %d.", klass);
    }
}
