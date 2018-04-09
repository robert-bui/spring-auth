package com.gobear.ignite;


import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.spring.SpringCacheManager;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.configuration.NearCacheConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Configuration
@Service
@EnableCaching
public class IgniteConfig {

    /* Inject the ignite config into the SpringCacheManager, then the ignite instance will be auto started */
    @Bean("cacheManager")
    public SpringCacheManager getSpringCacheManager() {

        SpringCacheManager springCacheManager = new SpringCacheManager();

        IgniteConfiguration configuration = new IgniteConfiguration();

        configuration.setClientMode(true);

        TcpDiscoverySpi discoverySpi = new TcpDiscoverySpi();
        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
        ipFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47509"));
        discoverySpi.setIpFinder(ipFinder);
        configuration.setDiscoverySpi(discoverySpi);

        //discoverySpi.setForceServerMode(true);

        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName("TestUserCache");
        cacheConfiguration.setCacheMode(CacheMode.REPLICATED);
        configuration.setCacheConfiguration(cacheConfiguration);


        NearCacheConfiguration nearCacheConfiguration = new NearCacheConfiguration();
        nearCacheConfiguration.setNearStartSize(1000);


        springCacheManager.setDynamicNearCacheConfiguration(nearCacheConfiguration);

        springCacheManager.setConfiguration(configuration);


        return springCacheManager;
    }


}
