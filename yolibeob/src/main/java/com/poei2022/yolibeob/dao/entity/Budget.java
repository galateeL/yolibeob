package com.poei2022.yolibeob.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="budget")
public class Budget implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    public Budget() {
    }

    public Budget(String title) {
        this.title = title;
    }

    public Budget(long id, String title) {
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
