package practice10;

import static java.lang.String.format;
import static java.util.Objects.nonNull;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(name, id, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        String basicIntroduce = format("%s I am a Student.", super.introduce());
        String roleIntroduce = format(
                nonNull(klass) && klass.getLeader() == this ?
                        " I am Leader of %s."
                        : " I am at %s.",
                klass.getDisplayName()
        );

        return basicIntroduce.concat(roleIntroduce);
    }
}
