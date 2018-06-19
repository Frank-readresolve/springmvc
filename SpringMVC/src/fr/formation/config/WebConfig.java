package fr.formation.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.*;

@Configuration
@Import(AppConfig.class)
@EnableWebMvc
@ComponentScan("fr.formation.controllers")
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/static/**")
		.addResourceLocations("/static/");
    }

    @Bean
    public ViewResolver viewResolver() {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	viewResolver.setViewClass(JstlView.class);
	viewResolver.setPrefix("/WEB-INF/jspf/");
	viewResolver.setSuffix(".jsp");
	return viewResolver;
    }
}