package com.yy.base.config.mybatis;

import com.github.pagehelper.PageInterceptor;
import com.yy.base.config.base.ObtainAppliationPropertis;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * Mybatis插件的相关的配置
 */
public class MybatisConfig extends ObtainAppliationPropertis {



    @Bean
    public DataSource dataSource() {

            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setJdbcUrl(getRequiredString(MybatisPropertisKeyConstant.KEY_MYBATIS_JDBC_URL));
            dataSource.setUsername(getRequiredString(MybatisPropertisKeyConstant.KEY_MYBATIS_JDBC_USERNAME));
            dataSource.setPassword(getRequiredString(MybatisPropertisKeyConstant.KEY_MYBATIS_JDBC_PASSWORD));
            dataSource.setMaximumPoolSize(getIntOrDefault(MybatisPropertisKeyConstant.KEY_MYBATIS_JDBC_MAX_POOL_SIZE, 10));

            return dataSource;

    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);


        //获取配置文件当中的设置
        /**
         * 默认是放到类路径下的mapper路径下
         */
        String mapperLocations=getStringOrDefault(MybatisPropertisKeyConstant.KEY_MYBATIS_MAPPERLOCATIONS,"classpath:mapper/*.xml");


        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));

        /**
         * 获取Mybatis的配置文件的路径
         */
        String mapperConfigLocation=getStringOrDefault(MybatisPropertisKeyConstant.KEY_MYBATIS_MAPPER_CONFIGLOCATION,"classpath:mybatis-config.xml");

        //设置Mybatis的相关的配置
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(mapperConfigLocation));



        //获取配置是否启动分页功能
        boolean isPage=getBooleanOrDefault(MybatisPropertisKeyConstant.KEY_MYBATIS_IS_PAGE,false);

        if(isPage){
            // 设置MyBatis分页插件
            bean.setPlugins(new Interceptor[]{getPageInterceptor()});

        }

        return bean;
    }


    /**
     * 接口Mapper的相关的配置,也就是告诉系统这个接口文件的位置在哪里
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mScannerConfigurer = new MapperScannerConfigurer();
        mScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");


        //进行获取接口文件的位置
        /**
         * 默认是放到类路径下的mapper路径下
         */
        String mapperBasePackage=getStringOrDefault(MybatisPropertisKeyConstant.KEY_MYBATIS_MAPPER_BASEPACKAGE,"com.hailong.mapper");

        mScannerConfigurer.setBasePackage(mapperBasePackage);
        return mScannerConfigurer;
    }



    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate SqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }




    /**
     * Mybatis分页拦截器
     * @return
     */
    public PageInterceptor getPageInterceptor() {

        //获取数据的方言
        String dialect=getStringOrDefault(MybatisPropertisKeyConstant.KEY_MYBATIS_PAGEHELPER_DIALECT,"mysql");

        //获取方法参数支持
        boolean isSupport=getBooleanOrDefault(MybatisPropertisKeyConstant.KEY_MYBATIS_PAGEHELPER_SUPPORT_METHODS_ARGUMENTS,true);

        //获取offset
        String offsetPageNum=getStringOrDefault(MybatisPropertisKeyConstant.KEY_MYBATIS_PAGEHELPER_OFFSET_PAGE_NUM,"true");

        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", dialect);
        properties.setProperty("offsetAsPageNum", offsetPageNum);
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("supportMethodsArguments",""+isSupport);
        pageInterceptor.setProperties(properties);


        return pageInterceptor;
    }

}
