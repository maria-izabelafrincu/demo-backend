package net.metrosystems.data.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @JsonProperty("created_on")
    Date createdOn;

    @Column(name = "updated_on")
    @JsonFormat(pattern="yyyy-MM-dd  hh:mm:ss")
    @JsonProperty("updated_on")
    Date updatedOn;

    @Column(name = "is_done")
    @JsonProperty("is_done")
    boolean isDone;

    @JsonProperty("created_on")
    public Date getCreatedOn() {
    return createdOn;
    }

    @JsonProperty("created_on")
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("updated_on")
    public Date getUpdatedOn() {
        return updatedOn;
    }

    @JsonProperty("updated_on")
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

    @JsonProperty("is_done")
    public boolean getIsDone() {
        return isDone;
    }

    @JsonProperty("is_done")
    public void setIsDone(boolean isDone) {
    this.isDone = isDone;
}
}
