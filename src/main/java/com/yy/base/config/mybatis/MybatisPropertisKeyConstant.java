package com.yy.base.config.mybatis;

/**
 * Mbyatis配置相关的常量Key操作
 */
public class MybatisPropertisKeyConstant {



    //*******************************数据源相关的配置****************************************
    public static final String KEY_MYBATIS_JDBC_URL="baseboot.mybatis.url";
    public static final String KEY_MYBATIS_JDBC_USERNAME="baseboot.mybatis.username";

    public static final String KEY_MYBATIS_JDBC_PASSWORD="baseboot.mybatis.password";

    public static final String KEY_MYBATIS_JDBC_MAX_POOL_SIZE="baseboot.mybatis.max_pool_size";





    //*********************************Mybatis相关的配置************************************

    /**
     * 设置MapperLoctions的属性
     */
    public static final String KEY_MYBATIS_MAPPERLOCATIONS="baseboot.mybatis.mapperlocations";


//    /**
//     * 设置MapperLoctions的属性
//     */
//    public static final String KEY_MYBATIS_MAPPERLOCATIONS="baseboot.mybatis.mapperlocations";


    /**
     * 设置Mapper接口的BasePackage的属性
     */
    public static final String KEY_MYBATIS_MAPPER_BASEPACKAGE="baseboot.mybatis.mapperbasepackage";


    /**
     * 设置Mapperconfig的属性
     */
    public static final String KEY_MYBATIS_MAPPER_CONFIGLOCATION="baseboot.mybatis.mapperconfiglocation";


    /**
     * 配置是否启动分页插件功能
     */
    public static final String KEY_MYBATIS_IS_PAGE="baseboot.mybatis.ispage";












    //*********************************分页插件相关的配置************************************


    /**
     * 设置Mybatis的数据库的分言
     */
    public static final String KEY_MYBATIS_PAGEHELPER_DIALECT="baseboot.pagehelper.dialect";



    /**
     * 增加方法参数支持
     */
    public static final String KEY_MYBATIS_PAGEHELPER_SUPPORT_METHODS_ARGUMENTS="baseboot.pagehelper.supportMethodsArguments";


    /**
     * 设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用
     */
    public static final String KEY_MYBATIS_PAGEHELPER_OFFSET_PAGE_NUM ="baseboot.pagehelper.offsetAsPageNum";









}
