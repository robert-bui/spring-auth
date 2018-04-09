package com.gobear.couchbase.service;


import com.gobear.model.UserInfo;

public interface CouchbaseUserService {


    UserInfo findByUsername(String username);

    void save(UserInfo user);
}
