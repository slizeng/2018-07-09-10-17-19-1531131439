package practice08;

public class Klass {
    private int number;
    private Person leader;

    public Klass(int number) {
        this.number = number;
    }

    public String getDisplayName() {
        return String.format("Class %d", number);
    }

    public void assignLeader(Person leader) {
        this.leader = leader;
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
