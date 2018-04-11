package com.gobear.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.io.Serializable;

@Document
public class UserInfo implements Serializable {
    @Id
//    @QuerySqlField(index = true)
    private String id;

    @Field
//    @QuerySqlField(index = true)
    private String username;

    @Field
//    @QuerySqlField(index = true)
    private String password;

    @Field
//    @QuerySqlField(index = true)
    private String role;

    @Field
//    @QuerySqlField(index = true)
    private String ssid;

    public UserInfo(String id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.ssid = "Not yet";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", ssid='" + ssid + '\'' +
                '}';
    }
}
