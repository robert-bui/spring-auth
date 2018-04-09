package com.gobear.couchbase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCouchbaseRepositories
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {


    @Value("${spring.couchbase.bucket.name}")
    private String bucketName;

    @Value("${spring.couchbase.bucket.password}")
    private String password;

    @Value("${spring.couchbase.bootstrap-hosts}")
    private String host;

    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList(host);
    }

    @Override
    protected String getBucketName() {
        return bucketName;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected String getBucketPassword() {
        return password;
    }

    public String getConfigInfo() {
        return "CouchbaseConfiguration{" +
                "bucketName='" + bucketName + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                '}';
    }

    public String getEnv() {
        return getEnvironment().toString();
    }
}
