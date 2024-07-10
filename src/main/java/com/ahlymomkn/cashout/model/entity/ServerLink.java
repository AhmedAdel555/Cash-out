package com.ahlymomkn.cashout.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "ServerLink")
public class ServerLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String link;

    public ServerLink(String id, String link) {
        this.id = id;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
