package ua.nure;

public class ExampleObjectOverride {
    private int id;

    public ExampleObjectOverride(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Перевизначення методу toString()
    @Override
    public String toString() {
        return "ExampleObjectOverride [id=" + id + "]";
    }

    // Перевизначення методу equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExampleObjectOverride myClass = (ExampleObjectOverride) obj;
        return id == myClass.id;
    }

    // Перевизначення методу hashCode()
//    @Override
//    public int hashCode() {
//        return Integer.hashCode(id);
//    }
}
