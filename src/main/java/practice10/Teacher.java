package practice10;

import java.util.LinkedList;

import static com.google.common.collect.Iterables.isEmpty;
import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.joining;

public class Teacher extends Person {
    private LinkedList<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(name, id, age);
        this.classes = new LinkedList<>();
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> klassLinkedList) {
        super(name, id, age);
        this.classes = klassLinkedList;
    }

    @Override
    public String introduce() {
        String superIntroduceResult = super.introduce();

        return isEmpty(classes)
                ? superIntroduceResult.concat(" I am a Teacher. I teach No Class.")
                : superIntroduceResult.concat(format(" I am a Teacher. I teach %s.",
                getClassesDisplayName()));
    }

    public String introduceWith(Student student) {
        String superIntroduceResult = super.introduce();

        return !isEmpty(classes)
                && nonNull(student)
                && nonNull(student.getKlass())
                && isClassContained(student.getKlass(), classes)
                ? format("%s I am a Teacher. I teach %s.", superIntroduceResult,
                student.getName())
                : format("%s I am a Teacher. I don't teach %s.", superIntroduceResult,
                student.getName());
    }

    public LinkedList<Klass> getClasses() {
        return classes;
    }

    private boolean isClassContained(Klass klass, LinkedList<Klass> classes) {
        return classes.stream().anyMatch(oneClass -> oneClass.equals(klass));
    }

    private String getClassesDisplayName() {
        String classesNumbers = classes.stream()
                .map(klass -> String.valueOf(klass.getNumber()))
                .collect(joining(", "));
        return "Class " + classesNumbers;
    }
}
