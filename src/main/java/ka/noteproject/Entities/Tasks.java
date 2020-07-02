package ka.noteproject.Entities;

import javax.persistence.*;

@Entity
public class Tasks {
    @Id
    @GeneratedValue
    private Long uid;
    private Long parent_uid;
    private String description;
    private Boolean done;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "taskList_uid", nullable = false)
    private TaskList taskList;

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public Tasks() { }

    public Tasks(Long uid, Long parent_uid, String description, Boolean done){
        this.uid = uid;
        this.parent_uid = parent_uid;
        this.description = description;
        this.done = done;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() { return done; }

    public void setDone(Boolean done) { this.done = done; }

    public Long getParent_uid() {
        return parent_uid;
    }

    public void setParent_uid(Long parent_uid) {
        this.parent_uid = parent_uid;
    }
}
