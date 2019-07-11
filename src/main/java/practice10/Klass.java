package practice10;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

public class Klass {
    private int number;
    private Person leader;
    private Map<Integer, Student> members;

    public Klass(int number) {
        this.number = number;
        this.members = new HashMap<>();
    }

    public String getDisplayName() {
        return String.format("Class %d", number);
    }

    public void appendMember(Student student) {
        if (nonNull(student)) {
            members.put(student.getId(), student);
        }
    }

    public void assignLeader(Student leader) {
        if (nonNull(members.get(leader.getId()))) {
            this.leader = leader;
        } else {
            System.out.print("It is not one of us.\n");
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
}
