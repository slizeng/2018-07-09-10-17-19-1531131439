package practice10;

import java.util.LinkedList;

import static com.google.common.collect.Iterables.isEmpty;
import static com.google.common.collect.Iterables.retainAll;
import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

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
                classes.get(0).getDisplayName()));
    }

    public String introduceWith(Student student) {
        String superIntroduceResult = super.introduce();

        return isEmpty(classes)
                && nonNull(student)
                && nonNull(student.getKlass())
                && classes.get(0).equals(student.getKlass())
                ? format("%s I am a Teacher. I don't teach %s.", superIntroduceResult, student.getName())
                : format("%s I am a Teacher. I teach %s.", superIntroduceResult, student.getName());
    }

    public LinkedList<Klass> getClasses() {
        return classes;
    }

    private String getClassesDisplayName() {
        return ;
    }
}
