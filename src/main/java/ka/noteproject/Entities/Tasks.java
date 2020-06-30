package ka.noteproject.Entities;

import javax.persistence.*;

@Entity
public class Tasks {
    @Id
    @GeneratedValue
    private Long uid;
    private String description;
    private Boolean done;

    public Tasks() { }

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "list_id", nullable = false)
    private TaskList list;

    public TaskList getTaskList() {
        return list;
    }

    public void setTaskList(TaskList list) {
        this.list = list;
    }

    public Boolean getDone() { return done; }

    public void setDone(Boolean done) { this.done = done; }
}
