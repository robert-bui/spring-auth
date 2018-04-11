/*
package com.gobear.ignite;

import com.gobear.model.UserInfo;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Configuration
@EnableIgniteRepositories
public class IgniteSpringDataConfig {

    @Autowired
    private Environment env;

    @Bean
    public Ignite igniteInstance() {

        IgniteConfiguration configuration = new IgniteConfiguration();

        configuration.setIgniteInstanceName("springDataAuthNode");
        configuration.setPeerClassLoadingEnabled(true);

        CacheConfiguration cacheConfiguration = new CacheConfiguration("UserInfoCache");
        cacheConfiguration.setIndexedTypes(String.class, UserInfo.class);
        cacheConfiguration.setCacheMode(CacheMode.REPLICATED);
        configuration.setCacheConfiguration(cacheConfiguration);

        TcpDiscoverySpi discoverySpi = new TcpDiscoverySpi();
        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
        ipFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47509"));
        discoverySpi.setIpFinder(ipFinder);
        configuration.setDiscoverySpi(discoverySpi);

        if (isServerMode()) {
            System.out.println("&&&&&&&&&&&&&&& Server mode");
            discoverySpi.setForceServerMode(true);
            configuration.setClientMode(false);
        } else {
            System.out.println("&&&&&&&&&&&&&&& Client mode");
            discoverySpi.setForceServerMode(false);
            configuration.setClientMode(true);
        }


        return Ignition.start(configuration);
    }

    private boolean isServerMode() {
        System.out.println("Environment: " + env.toString());
        System.out.println("Is Server Mode Property: " + env.getProperty("server.mode"));
        return Boolean.valueOf(env.getProperty("server.mode", "false"));
    }
}
*/
