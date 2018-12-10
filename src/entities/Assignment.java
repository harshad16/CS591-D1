package src.entities;

public class Assignment {
    //its primary key
    private Integer assignmentId;
    private Integer courseId;
    private String name;
    private Integer weight;
    private String description;

    public Assignment(){
        this.assignmentId = null;
        this.courseId = null;
        this.name = null;
        this.weight = null;
        this.description = null;
    }

    public Assignment(Integer courseId, String name, Integer weight, String descrption){
        this.assignmentId = null;
        this.courseId = courseId;
        this.name = name;
        this.weight = weight;
        this.description = descrption;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }
    

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId=" + assignmentId +
                ", courseId=" + courseId +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                '}';
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
