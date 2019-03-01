package com.yy.base.WebBaseBoot;

import com.yy.base.config.mybatis.DruidConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

@Import(DruidConfig.class)
public class WebBaseBootApplicationTests {


	@Autowired
	private DruidConfig config;

	@Test
	public void contextLoads() {

		//System.out.println(config.driverClassName);

		//System.out.println(config.username);


	}

}
