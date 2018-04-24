import java.util.DoubleSummaryStatistics;

public class Student {
    //Student temp;
    private String std_id;
    private String first_name;
    private String last_name;
    private String [] courses;
    private int [] credits;
    private String [] grades;
    private int total_credits;
    private double current_gpa;
    private double end;

    public String getStd_id() {
        return std_id;
    }

    public void setStd_id(String std_id) {
        this.std_id = std_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public int[] getCredits() {
        return credits;
    }

    public void setCredits(int[] credits) {
        this.credits = credits;
    }

    public String[] getGrades() {
        return grades;
    }

    public void setGrades(String[] grades) {
        this.grades = grades;
    }

    public int getTotal_credits() {
        return total_credits;
    }

    public void setTotal_credits(int total_credits) {
        this.total_credits = total_credits;
    }

    public double getCurrent_gpa() {
        return current_gpa;
    }

    public void setCurrent_gpa(double current_gpa) {
        this.current_gpa = current_gpa;
    }

    public void end(double end){
        this.end=end;
    }
    public Double getend(){
        return end;
    }
}
