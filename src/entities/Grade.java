package src.entities;


public class Grade {

    private Integer id;
    private Integer assignmentId;
    private Integer studentId;
    private String note;
    private Double grade;

    private Student student;
    private Assignment assignment;

    public Grade() {
        this.id = null;
        this.assignmentId = null;
        this.studentId = null;
        this.note = null;
        this.grade = null;
        this.student = null;
        this.assignment = null;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Grade(Integer assignmentId, Integer studentId, String note, Double grade) {
        this();
        this.assignmentId =assignmentId;
        this.studentId = studentId;
        this.note = note;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", assignmentId=" + assignmentId +
                ", studentId=" + studentId +
                ", note='" + note + '\'' +
                ", grade=" + grade +
                ", student=" + student +
                ", assignment=" + assignment +
                '}';
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getNote() {
        return note;
    }



    public void setNote(String note) {
        this.note = note;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }



}
