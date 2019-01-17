package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"spittr"}, excludeFilters = {@ComponentScan.Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class RootConfig {
}
