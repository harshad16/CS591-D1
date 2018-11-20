import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Student implements Serializable {
    private Integer studentId;
    private String buId;
    private boolean graduateStudent;
    private Integer year;
    private String lastName;
    private String firstname;
    private List<Course> courseList;
    private Map<Assignment, Grade> gradeMap;

    public boolean isGraduateStudent() {
        return graduateStudent;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Integer getYear() {
        return year;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public Map<Assignment, Grade> getGradeMap() {
        return gradeMap;
    }

    public String getBuId() {
        return buId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBuId(String buId) {
        this.buId = buId;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setGradeMap(Map<Assignment, Grade> gradeMap) {
        this.gradeMap = gradeMap;
    }

    public void setGraduateStudent(boolean graduateStudent) {
        this.graduateStudent = graduateStudent;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
        result = prime * result + ((buId == null) ? 0 : buId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (studentId == null) {
            if (other.studentId != null)
                return false;
        } else if (!studentId.equals(other.studentId))
            return false;
        if (buId == null) {
            if (other.buId!= null)
                return false;
        } else if (!buId.equals(other.buId))
            return false;

        return true;
    }


}
