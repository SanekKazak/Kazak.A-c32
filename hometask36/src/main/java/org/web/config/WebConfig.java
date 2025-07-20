package org.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        var viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("org/rides/web/view");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
        WebMvcConfigurer.super.configureViewResolvers(registry);
    }
}
