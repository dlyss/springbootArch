
# ABOUT  
springboot 骨架工程搭建，逐步从创建、配置mybatis、logback、多环境、多数据源、redis等，满足基本企业级开发即开即用的目的，降低工程搭建成本，提高效率。

##注意事项  
####tomcat部署   
1、pom.xml  
      
      <packaging>war</packaging>   
      		<!--如果部署外部自己的Tomcat,这一项配置必不可少，否则去之-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency> 
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
    
    <filters>
			<filter>src/main/resources/application.yml</filter>
			<filter>src/main/resources/config/application-${pom.env}.yml</filter>
	</filters>
		<resources>
			<resource>
				<directory>src/main/resources</directory>
				<includes>
					<include>**/*</include>
				</includes>
				<filtering>true</filtering>
			</resource>
		</resources> 
	<profiles>
		<profile>
			<id>dev</id>
			<properties>
				<pom.env>dev</pom.env>
			</properties>
			<activation>
				<activeByDefault>true</activeByDefault>
				<property>
					<name>APP_ENV</name>
					<value>dev</value>
				</property>
			</activation>
		</profile>
		<profile>
			<id>idc_test</id>
			<properties>
				<pom.env>idc_test</pom.env>
			</properties>
			<activation>
				<property>
					<name>APP_ENV</name>
					<value>idc_test</value>
				</property>
			</activation>
		</profile>
	</profiles> 
基本概念说明（resources、filter和profile）： 
  想用哪个环境的时候只需要在主配置文件中将用的配置文件写上就行如下：      
  spring:  
    profiles:  
      active: prod   
  这行配置在application.yml 文件中，意思是当前起作用的配置文件是application_prod.yml     
1.profiles定义了各个环境的变量id   
2.filters中定义了变量配置文件的地址，其中地址中的环境变量就是上面profile中定义的值。maven filter可利用指定的xxx.properties中对应的key=value对资源文件中的${key}进行替换，最终把你的资源文件中的username=${key}替换成username=value。filter是在maven的compile阶段执行过虑替换的。    
3.resources中是定义哪些目录下的文件会被配置文件中定义的变量替换，一般我们会把项目的配置文件放在src/main/resources下，像db,bean等，里面用到的变量在打包时就会根据filter中的变量配置替换成固定值  
####druid数据源  
####redis相关   
####logback   
1、在resources目录下新建logback-spring.xml  
只要你的名字是logback-spring.xml的话SpringBoot会自动识别和读取它的，所以你就不需要在application.yml进行其他的配置了。  
 