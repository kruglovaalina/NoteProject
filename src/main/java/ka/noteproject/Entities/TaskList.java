package ka.noteproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tasks> tasks;

    public TaskList() {}

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

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }
}