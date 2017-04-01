package com.licenta.freetime.data.domain;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.List;
import java.util.Date;

/**
 * Created by izabe on 4/1/2017.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favorite_movies")
@Builder
public class FavoriteMovie {

    @Column(name = "email")
    @PartitionKey
    String email;

    @Column(name = "genres")
    List<String> genres;

    @Column(name = "overview")
    String overview;

    @Column(name = "movie_title")
    @JsonProperty("title")
    String title;

    @Column(name = "created_on")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @JsonProperty("created_on")
    Date createdOn;

    @Column(name = "updated_on")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @JsonProperty("updated_on")
    Date updatedOn;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
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
}
