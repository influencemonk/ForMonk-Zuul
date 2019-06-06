package ForMonk.Zuul;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import ForMonk.Zuul.Filters.ErrorFilter;
import ForMonk.Zuul.Filters.PostFilter;
import ForMonk.Zuul.Filters.PreFilter;
import ForMonk.Zuul.Filters.RouteFilter;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ForMonkZuulApplication implements SwaggerResourcesProvider {

	public static void main(String[] args) {
		SpringApplication.run(ForMonkZuulApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
	    return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
	    return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
	    return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
	    return new RouteFilter();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SwaggerResource> get() {
		// TODO Auto-generated method stub
		 	List resources = new ArrayList<>();
	        resources.add(swaggerResource("post-scheduler", "/docApi/v2/api-docs", "2.0"));
	        return resources;
	}
	
	private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
	
}
	