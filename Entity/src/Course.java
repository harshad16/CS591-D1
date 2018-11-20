import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Course implements Serializable {
    private Integer courseId;
    private String courseName;
    private String description;
    private Date startTime;
    private String days;
    private List<Assignment> assignmentList;
    private List<Student> studentList;

    public Date getStartTime() {
        return startTime;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDays() {
        return days;
    }

    public String getDescription() {
        return description;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
        result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
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
        Course other = (Course) obj;
        if (courseId == null) {
            if (other.courseId != null)
                return false;
        } else if (!courseId.equals(other.courseId))
            return false;
        if (courseName == null) {
            if (other.courseName != null)
                return false;
        } else if (!courseName.equals(other.courseName))
            return false;
        if(description == null) {
            if(other.description != null) {
                return false;
            }
        }else if(!description.equals(other.description)) {
            return false;
        }
        if(startTime == null) {
            if(other.startTime != null) {
                return false;
            }
        }else if(!startTime.equals(other.startTime)) {
            return false;
        }

        if(days == null) {
            if(other.days != null) {
                return false;
            }
        }else if(!days.equals(other.days)) {
            return false;
        }
        return true;
    }


}
