package com.ahlymomkn.cashout.model.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "server_link")
public class ServerLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String link;

    public ServerLink(Integer id, String link) {
        this.id = id;
        this.link = link;
    }

    public ServerLink() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
