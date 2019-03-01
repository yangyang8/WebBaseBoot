package com.yy.base.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于Mybatis的工具生成代码
 */
public class GeneratorCode {


	/**
	 * 使用案例如下：
	 * ./src/main/resources/generatorConfig.xml这个文件在我们这个基础框架当中也有，可以参照这个文件来改就可以了
	 */
//	public static void main(String[] args) throws Exception {
//		   generator("./src/main/resources/generatorConfig.xml");
//	}





 
	public static void generator(String fileName) throws Exception {
		   List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;
		   File configFile = new File(fileName);
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   myBatisGenerator.generate(null);
		   
		   System.out.println("代码生成完毕>>>>>>>>>>>>");
	}
 
}