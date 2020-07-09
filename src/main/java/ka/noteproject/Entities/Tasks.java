package ka.noteproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TASKS")
public class Tasks {
    @Id
    @Column(name = "UID", nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;

    //private Long parent_uid;
    @Column(name = "TITTLE", nullable = false)
    private String tittle;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DONE")
    private Boolean done;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taskListUid", nullable = false)
    private TaskList taskList;


    public Tasks() {}

    public Tasks(Long parent_uid, String tittle){
        this(null, tittle, "", false, null, null, null);
        /*
        LocalDateTime currentDataTime = LocalDateTime.now();
        this.createDate = Date.from(currentDataTime.atZone(ZoneId.systemDefault()).toInstant());
        this.updateDate = createDate;
        */
    }




    public Tasks(Long uid, String tittle, String description, Boolean done,
                      Date createDate, Date updateDate, Date dueDate){
        this.uid = uid;
        this.tittle = tittle;
        this.description = description;
        this.done = done;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.dueDate = dueDate;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date date) {
        this.dueDate = date;
    }

    @JsonIgnore
    public TaskList getTaskList() {
        return taskList;
    }

    @JsonIgnore
    public void setTaskList(TaskList newTaskList) {
        this.taskList = taskList;
    }

    public Long getTaskListUid() {
        return taskList.getUid();
    }
    
    public String getTaskListName() {
        return taskList.getName();
    }
}
