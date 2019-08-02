package io.khasang.gahelp.entity;

import javax.persistence.*;

@Entity
@Table()
public class Bird {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private boolean isCurban;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCurban() {
        return isCurban;
    }

    public void setIsCurban(boolean isCurban) {
        this.isCurban = isCurban;
    }
}
