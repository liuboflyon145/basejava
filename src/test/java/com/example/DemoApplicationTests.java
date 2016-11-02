package com.example;

import com.aop.CheckUser;
import com.aop.impl.IUserImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	CheckUser checkUser;
	@Test
	public void contextLoads() {
	}


	@Test
	public void findAllTest(){
		IUserImpl iui = new IUserImpl();
		iui.addUser("wang hua");
	}
}
