package practice06;

import static java.util.Objects.nonNull;

public class Teacher extends Person {
    private Integer klass;

    public Teacher(String name, int age) {
        super(name, age);
        this.klass = null;
    }

    public Teacher(String name, int age, Integer klass) {
        super(name, age);
        this.klass = klass;
    }

    @Override
    public String introduce() {
        String superIntroduceResult = super.introduce();

        return nonNull(klass)
                ? String.format("%s I am a Teacher. I teach Class %s.", superIntroduceResult, klass)
                : superIntroduceResult + " I am a Teacher. I teach No Class.";
    }

    public int getKlass() {
        return klass;
    }
}
