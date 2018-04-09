package com.gobear.couchbase.repo;

import com.gobear.model.UserInfo;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "user", viewName = "all")
public interface CouchbaseUserRepository extends CouchbasePagingAndSortingRepository<UserInfo, String> {

    UserInfo findByUsername(String name);

}
