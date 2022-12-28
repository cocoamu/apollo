package com.example.demoapollo.refresh;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@Slf4j
public class DataBaseRefresh {

    @Autowired
    private ApplicationContext cxt;

    @ApolloConfigChangeListener("mytest")
    public void onChange(ConfigChangeEvent event) {
       Set<String> set =  event.changedKeys();
       set.forEach(s -> {
           System.out.println(s);
       });
    }
}
