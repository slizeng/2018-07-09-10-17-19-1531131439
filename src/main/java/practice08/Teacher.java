package practice08;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(int id, String name, int age) {
        super(name, id, age);
        this.klass = null;
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(name, id, age);
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
