package com.example.SecurityDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author yangkun
 * @createTime 2020年06月11日 13:56:00
 */
@EnableResourceServer
@Configuration
public class ResourceServerConfiguration extends
    ResourceServerConfigurerAdapter {
  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    resources.resourceId("resource");
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().anyRequest().authenticated();
  }
}
