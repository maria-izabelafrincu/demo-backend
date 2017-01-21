package net.metrosystems.data.domain;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import java.util.Date;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "to_do")
@Builder
public class ToDo {

  @Column(name = "title")
  @PartitionKey // echivaleaza aproximativ cu primary key din sql
  String title;

  @Column(name = "description")
  String description;

  @Column(name = "created_on")
  Date createdOn;

  @Column(name = "updated_on")
  Date updatedOn;

  @Column(name = "is_done")
  Boolean isDone;

public Date getCreatedOn() {
    return createdOn;
}

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        isDone = isDone;
    }
}
