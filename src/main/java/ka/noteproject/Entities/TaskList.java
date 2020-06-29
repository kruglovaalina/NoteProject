package ka.noteproject.Entities;

import javax.persistence.*;
import java.util.Set;


@Entity
public class TaskList {

    @Id
    @GeneratedValue
    private Long uid;
    private String name;

    public TaskList() {

    }

    public TaskList(String name) {
        this(null, name);
    }

    public TaskList(Long uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "list")
    private Set<Tasks> tasks;

    public Set<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Tasks> tasks) {
        this.tasks = tasks;
    }
}
