package src.entities;

import java.io.Serializable;

public class Grade implements Serializable {
    private Integer gradeId;
    private Integer studentId;
    private Integer assignmentId;
    private Double grade;

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Double getGrade() {
        return grade;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + gradeId;
        result = prime * result + studentId;
        result = prime * result + assignmentId;
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
        Grade other = (Grade) obj;
        if (gradeId == null) {
            if (other.gradeId != null)
                return false;
        } else if (!gradeId.equals(other.gradeId))
            return false;
        if (studentId == null) {
            if (other.studentId != null)
                return false;
        } else if (!studentId.equals(other.studentId))
            return false;
        if(assignmentId == null) {
            if(other.assignmentId != null) {
                return false;
            }
        }else if(!assignmentId.equals(other.assignmentId)) {
            return false;
        }

        return true;
    }

}
