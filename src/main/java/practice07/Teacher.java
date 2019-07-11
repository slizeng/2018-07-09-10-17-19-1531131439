package practice07;

import static java.lang.String.format;
import static java.util.Objects.nonNull;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
        this.klass = null;
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    @Override
    public String introduce() {
        String superIntroduceResult = super.introduce();

        return nonNull(klass)
                ? format("%s I am a Teacher. I teach %s.", superIntroduceResult, klass.getDisplayName())
                : superIntroduceResult + " I am a Teacher. I teach No Class.";
    }

    public String introduceWith(Student student) {
        String superIntroduceResult = super.introduce();

        if (nonNull(klass) && nonNull(student) && nonNull(student.getKlass()) && klass.equals(student.getKlass())) {
            return format("%s I am a Teacher. I teach %s.", superIntroduceResult, student.getName());
        }

        return format("%s I am a Teacher. I don't teach %s.", superIntroduceResult, student.getName());
    }

    public Klass getKlass() {
        return klass;
    }
}
