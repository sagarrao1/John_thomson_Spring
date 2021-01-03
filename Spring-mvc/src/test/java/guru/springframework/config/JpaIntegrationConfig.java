package guru.springframework.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*This id for Integration test case to test Jpa without running tomcat embeded server
It will be used to config spring context , h2 db, jpa, hibernate and run your test case
by setting specified active profile
*/

@Configuration
@EnableAutoConfiguration
@ComponentScan("guru.springframework")
public class JpaIntegrationConfig {

}
