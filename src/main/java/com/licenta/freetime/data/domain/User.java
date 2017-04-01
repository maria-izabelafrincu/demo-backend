package com.licenta.freetime.data.domain;

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
@Table(name = "users")
@Builder
public class User {

    @Column(name = "email")
    @PartitionKey
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "created_on")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @JsonProperty("created_on")
    Date createdOn;

    @Column(name = "updated_on")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @JsonProperty("updated_on")
    Date updatedOn;

    @Column(name = "first_name")
    @JsonProperty("first_name")
    String firstName;

    @Column(name = "last_name")
    @JsonProperty("last_name")
    String lastName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @JsonProperty("created_on")
    public Date getCreatedOn() {
        return createdOn;
    }

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @JsonProperty("created_on")
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @JsonProperty("updated_on")
    public Date getUpdatedOn() {
        return updatedOn;
    }

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @JsonProperty("updated_on")
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
