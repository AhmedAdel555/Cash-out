package com.ahlymomkn.cashout.payload;

import com.ahlymomkn.cashout.model.entity.User;

public class NotificationResposeDTO {
    private Integer id;

    private String title;

    private String body;


    public NotificationResposeDTO() {
    }

    public NotificationResposeDTO(Integer id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
