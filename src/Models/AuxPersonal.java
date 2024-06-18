package Models;

public class AuxPersonal extends Employee {
    private String job;
    private int increases;

    public AuxPersonal(String name, int salary, String ssn, String job, int increases) {
        super(name, salary, ssn);
        this.job = job;
        this.increases = increases;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getIncreases() {
        return increases;
    }

    public void setIncreases(int increases) {
        this.increases = increases;
    }

    @Override
    public String toString() {
        return super.toString() + ", Job: " + getJob() + ", Increases: " + getIncreases();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (!(obj instanceof AuxPersonal)) return false;
        AuxPersonal other = (AuxPersonal) obj;
        return this.job.equals(other.job) && this.increases == other.increases;
    }
}
