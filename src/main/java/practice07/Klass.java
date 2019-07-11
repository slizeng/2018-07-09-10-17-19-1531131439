package practice07;

public class Klass {
    private int number;

    public Klass(int number) {
        this.number = number;
    }

    public String getDisplayName() {
        return String.format("Class %d", number);
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
}
