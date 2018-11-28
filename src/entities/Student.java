package src.entities;

public class Student {

    private Integer id;
    private String studentId;
    private String firstName;
    private String lastName;
    private String year;
    private String type;

    public Student(String stdid, String firstName, String lastName, String year, String type) {
        this.id = null;
        this.studentId =stdid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.type = type;
    }

    public Student(){
        this.id = null;
        this.studentId = null;
        this.firstName = null;
        this.lastName = null;
        this.year = null;
        this.type = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", year='" + year + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
