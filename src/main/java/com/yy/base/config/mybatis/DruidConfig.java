//package com.yy.base.config.mybatis;
//
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import javax.sql.DataSource;
//
//
///**
// * druid的相关配置如下
// */
//public class DruidConfig {
//
//
//	/**
//	 * 数据源类型
//	 */
//	@Value("${spring.datasource.type:com.alibaba.druid.pool.DruidDataSource}")
//	private String type;
//
//	/**
//	 * Driver驱动类
//	 */
//	@Value("${spring.datasource.driver-class-name:com.mysql.jdbc.Driver}")
//	private String deriverClassName;
//
//
//
//
//	@Value("${spring.datasource.url:jdbc:mysql://localhost:3306/TEST?useSSL=false&characterEncoding=utf8}")
//	private String url;
//
//
//	@Value("${spring.datasource.username:root}")
//	private String username;
//	@Value("${spring.datasource.password:123456}")
//	private String password;
//	@Value("${spring.datasource.druid.initial-size:5}")
//	private Integer initialSize;
//	@Value("${spring.datasource.druid.min-idle:5}")
//	private Integer minIdle;
//	@Value("${spring.datasource.druid.maxActive:20}")
//	private Integer maxActive;
//	@Value("${spring.datasource.druid.maxWait:60000}")
//	private Integer maxWait;
//	@Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis:60000}")
//	private Long timeBetweenEvictionRunsMillis;
//	@Value("${spring.datasource.druid.minEvictableIdleTimeMillis:300000}")
//	private Long minEvictableIdleTimeMillis;
//
//
//	@Value("${spring.datasource.druid.validationQuery:SELECT 1 FROM DUAL}")
//	private String validationQuery;
//	@Value("${spring.datasource.druid.testWhileIdle:true}")
//	private Boolean testWhileIdle;
//
//	@Value("${spring.datasource.druid.testOnBorrow:false}")
//	private Boolean testOnBorrow;
//	@Value("${spring.datasource.druid.testOnReturn:false}")
//	private Boolean testOnReturn;
//	@Value("${spring.datasource.druid.poolPreparedStatements:true}")
//	private Boolean poolPreparedStatements;
//	@Value("${spring.datasource.druid.maxPoolPreparedStatementPerConnectionSize:20}")
//	private Integer maxPoolPreparedStatementPerConnectionSize;
////
////	@Value("${spring.datasource.druid.filters:stat,wall,log4j}")
////
////	spring.datasource.druid.filters=stat,wall,log4j
////	@Value("${spring.datasource.url:jdbc:mysql://localhost:3306/TEST?useSSL=false&characterEncoding=utf8}")
////	spring.datasource.druid.connectionProperties=druid.stat.mergeSql\=true;druid.stat.slowSqlMillis\=5000
////	@Value("${spring.datasource.url:jdbc:mysql://localhost:3306/TEST?useSSL=false&characterEncoding=utf8}")
////	spring.datasource.druid.web-stat-filter.enabled=true
//	@Value("${spring.datasource.druid.web-stat-filter.url-pattern=/*}")
//	private String filterUrl;
//	@Value("${spring.datasource.druid.web-stat-filter.exclusions:*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*}")
//	private String exclusionWebStatFilters;
//	@Value("${spring.datasource.druid.stat-view-servlet.url-pattern:/druid/*}")
//	private String statViewServletUrlPattern;
//	@Value("${spring.datasource.druid.stat-view-servlet.allow:127.0.0.1,192.168.163.1}")
//	private String allow;
//	@Value("${spring.datasource.druid.stat-view-servlet.deny:127.0.0.1}")
//	private String deny;
//	@Value("${spring.datasource.druid.stat-view-servlet.reset-enable:false}")
//	private String resetEnable;
//	@Value("${spring.datasource.druid.stat-view-servlet.login-username:admin}")
//	private String loginName;
//	@Value("${spring.datasource.druid.stat-view-servlet.login-password:123456}")
//	private String loginPassword;
//
//
//	@Bean
//	public DataSource druidDataSource() {
//		DruidDataSource druidDataSource=new DruidDataSource();
//		druidDataSource.setUsername(username);
//		druidDataSource.setPassword(password);
//		druidDataSource.setDriverClassName(deriverClassName);
//		druidDataSource.setMinIdle(minIdle);
//		druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//		druidDataSource.setUrl(url);
//		druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
//		druidDataSource.setTestOnBorrow(testOnBorrow);
//		druidDataSource.setTestOnReturn(testOnReturn);
//		druidDataSource.setTestWhileIdle(testWhileIdle);
//		druidDataSource.setMaxActive(maxActive);
//		druidDataSource.setMaxWait(maxWait);
//		druidDataSource.setInitialSize(initialSize);
//		return new DruidDataSource();
//	}
//
//
//	@Bean
//	public ServletRegistrationBean druidServlet() { // 主要实现WEB监控的配置处理
//		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
//				"/druid/*"); // 进行druid监控的配置处理操作
//		servletRegistrationBean.addInitParameter("allow", allow); // 白名单
//		servletRegistrationBean.addInitParameter("deny", deny); // 黑名单
//		servletRegistrationBean.addInitParameter("loginUsername", loginName); // 用户名
//		servletRegistrationBean.addInitParameter("loginPassword", loginPassword); // 密码
//		servletRegistrationBean.addInitParameter("resetEnable", resetEnable); // 是否可以重置数据源
//		return servletRegistrationBean;
//	}
//
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean() {
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//		filterRegistrationBean.setFilter(new WebStatFilter());
//
//		filterRegistrationBean.addUrlPatterns(filterUrl); // 所有请求进行监控处理
//		filterRegistrationBean.addInitParameter("exclusions", exclusionWebStatFilters);
//		return filterRegistrationBean;
//	}
//
//}