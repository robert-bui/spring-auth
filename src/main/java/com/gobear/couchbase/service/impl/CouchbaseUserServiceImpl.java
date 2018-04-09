package com.gobear.couchbase.service.impl;

import com.gobear.couchbase.repo.CouchbaseUserRepository;
import com.gobear.couchbase.service.CouchbaseUserService;
import com.gobear.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;


@Service
public class CouchbaseUserServiceImpl implements CouchbaseUserService {

    @Autowired
    private CouchbaseUserRepository userRepository;

    @Cacheable("userGetCache")
    @Override
    public UserInfo findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @CacheEvict(value = "userSaveCache", allEntries = true) // always lets the method execute
    @Override
    public void save(UserInfo user) {
        userRepository.save(user);
    }
}
