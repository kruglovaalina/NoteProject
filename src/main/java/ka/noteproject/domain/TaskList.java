package ka.noteproject.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class TaskList {

    @Id
    @Column(name = "UID", nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;
    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Tasks> tasks = new HashSet<>();

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
}