package src.entities;

import java.util.Date;

public class Assignment {
    //its primary key
    private Integer assignmentId;
    private Integer courseId;
    private String name;
    private Integer weight;
    private String description;
    private Date createdAt;
    private String type;
    private Integer total;
    private Boolean isOptional;

    public Assignment(){
        this.assignmentId = null;
        this.courseId = null;
        this.name = null;
        this.weight = null;
        this.description = null;
        this.createdAt = null;
        this.type = null;
        this.total = null;
        this.isOptional = null;
    }

    public Assignment(Integer courseId, String name, Integer weight, String descrption, String type, Integer total, Boolean isOptional){
        this.assignmentId = null;
        this.courseId = courseId;
        this.name = name;
        this.weight = weight;
        this.description = descrption;
        this.createdAt = null;
        this.type = type;
        this.total = total;
        this.isOptional = isOptional;
        
    }
    
    public boolean getIsOptional() {
    	return this.isOptional;
    }
    
    public void setIsOptional(Boolean isOptional) {
    	this.isOptional = isOptional;
    }
    
    public String getType() {
    	return this.type;
    }
    
    public void setType(String type) {
    	this.type = type;
    }
    
    public Integer getTotal() {
    	return this.total;
    }
    
    public void setTotal(Integer total) {
    	this.total = total;
    }
    public Date getCreatedAt() {
    	return this.createdAt;
    }
    
    public void setCreatedAt(Date date) {
    	this.createdAt = date; 
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
                ", type=" + type +
                ", total=" + total +
                ", isOptional=" + isOptional +
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
