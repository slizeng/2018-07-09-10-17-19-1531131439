package practice11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.Objects.nonNull;

public class Klass {
    private int number;
    private Person leader;
    private Map<Integer, Student> members;
    private List<Teacher> teacherList;

    public Klass(int number) {
        this.number = number;
        this.members = new HashMap<>();
        this.teacherList = new ArrayList<>();
    }

    public String getDisplayName() {
        return String.format("Class %d", number);
    }

    public void appendMember(Student student) {
        if (nonNull(student)) {
            members.put(student.getId(), student);
            Consumer<Teacher> event = teacher -> teacher.awareNewStudentJoinsClass(student, this);
            notifyTeachersWithEvent(event);
        }
    }

    public void assignLeader(Student leader) {
        if (nonNull(members.get(leader.getId()))) {
            this.leader = leader;
            Consumer<Teacher> event = teacher -> teacher.awareStudentBecomesLeader(leader, this);
            notifyTeachersWithEvent(event);
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    void registerTeacher(Teacher teacher) {
        if (teacherList.stream().noneMatch(registeredTeacher -> registeredTeacher.equals(teacher))) {
            teacherList.add(teacher);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == Klass.class && number == ((Klass) obj).getNumber();
    }

    public int getNumber() {
        return number;
    }

    public Person getLeader() {
        return leader;
    }

    private void notifyTeachersWithEvent(Consumer<Teacher> event) {
        teacherList.forEach(event);
    }
}
