package com.library.xiaolong.domian;

import java.io.Serializable;

public class ReaderCard implements Serializable {

    private Long reader_id;
    private String username;
    private String password;

    public Long getReaderId() {
        return reader_id;
    }

    public void setReaderId(long reader_id) {
        this.reader_id = reader_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ReaderCard{" +
                "reader_id=" + reader_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
