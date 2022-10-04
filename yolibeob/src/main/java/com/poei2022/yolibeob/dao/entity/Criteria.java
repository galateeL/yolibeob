package com.poei2022.yolibeob.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="criteria")
public class Criteria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    public Criteria() {
    }

    public Criteria(String title) {
        this.title = title;
    }

    public Criteria(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
