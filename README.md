
# ABOUT  
springboot 骨架工程搭建，逐步从创建、配置mybatis、logback、多环境、多数据源、redis等，满足基本企业级开发即开即用的目的，降低工程搭建成本，提高效率。

##注意事项  
####tomcat部署   
1、pom.xml  
      
      <packaging>war</packaging>    
2、启动类继承SpringBootServletInitializer并重写configure方法  
    
    @SpringBootApplication
public class Application extends SpringBootServletInitializer {
 
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }}  
    
####多环境部署  
####多数据源  
####redis相关   
####logback   
 