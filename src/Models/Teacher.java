package Models;

public class Teacher extends Employee {
    private String speciality;

    public Teacher(String name, int salary, String ssn, String speciality) {
        super(name, salary, ssn);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return super.toString() + ", Speciality: " + getSpeciality();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Teacher)) return false;
        Teacher other = (Teacher) obj;
        return this.speciality.equals(other.speciality);
    }
}
