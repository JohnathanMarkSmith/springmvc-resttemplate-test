package com.johnathanmsmith.client;

import com.johnathanmsmith.mvc.web.model.RESTServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Date:   5/24/13 / 8:05 AM
 * Author: Johnathan Mark Smith
 * Email:  john@johnathanmarksmith.com
 * <p/>
 * Comments:
 * <p/>
 * This is a example on how to setup a database with Spring's Java Configuration (JavaConfig) style.
 * <p/>
 * As you can see from the code below this is easy and a lot better then using the old style of XML files.
 * <p/>
 * This is used to read in a properties file and setup access to the RESTServer bean/
 */

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = {Main.class})
@PropertySource("classpath:application.properties")
public class RESTConfiguration
{

    @Bean
    public RESTServer restServer(Environment env)
    {
        return new RESTServer(env.getProperty("rest.user"),
                env.getProperty("rest.password"),
                env.getProperty("rest.host"));
    }
}
