/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dei.vlab.communication.model;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 *
 * @author server
 */
@Entity
@Table(name="calendar")
public class Calendarr extends BaseObject{

    private Long id;
    private String name;
    private String description;
    private Timestamp start;
    private Timestamp end;

    public Calendarr() {
    }
    
    
    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="endTime")
    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="startTime")
    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.name)
                .append(this.description)
                .append(this.start)
                .append(this.end)
                .append(this.id).toString();
    }

    @Override
    public boolean equals(Object o) {
          if (this == o) {
            return true;
        }
        if (!(o instanceof Calendarr)) {
            return false;
        }

        final Calendarr calendar = (Calendarr) o;

        return !(name != null ? !name.equals(calendar.name) : calendar.name != null);

    }

    @Override
    public int hashCode() {
       return (name != null ? name.hashCode() : 0);
    }
    
}
