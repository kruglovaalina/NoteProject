package ka.noteproject.Entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
public class Tasks {
    @Id
    @GeneratedValue
    private Long uid;
    private Long parent_uid;
    private String tittle;
    private String description;
    private Boolean done;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne()
    @JoinColumn(name = "ID_F", nullable = false)
    private TaskList taskList;

    public Tasks() { }

    public Tasks(Long parent_uid, String tittle){
        this(null, parent_uid, tittle, "", false, null, null, null);

        LocalDateTime currentDataTime = LocalDateTime.now();
        this.createDate = Date.from(currentDataTime.atZone(ZoneId.systemDefault()).toInstant());
        this.updateDate = createDate;
    }

    public Tasks(Long uid, long parent_uid, String tittle, String description, Boolean done,
                      Date createDate, Date updateDate, Date date){
        this.uid = uid;
        this.parent_uid = parent_uid;
        this.tittle = tittle;
        this.description = description;
        this.done = done;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.date = date;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getParent_uid() {
        return parent_uid;
    }

    public void setParent_uid(Long parent_uid) {
        this.parent_uid = parent_uid;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
