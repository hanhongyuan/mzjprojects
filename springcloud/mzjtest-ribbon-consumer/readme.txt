http://localhost:9000/ribbon

SpringCLoud中的“Discovery Service”有多种实现，比如：eureka, consul, zookeeper。
1，@EnableDiscoveryClient注解是基于spring-cloud-commons依赖，并且在classpath中实现； 
2，@EnableEurekaClient注解是基于spring-cloud-netflix依赖，只能为eureka作用；