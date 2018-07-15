/**
 * 
 */
package com.lesson;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lesson.BookShopApplication;

/**
 * @author zhailiang
 *
 * 被所有测试类继承的公共测试类，其中配置了一些公共的配置
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookShopApplication.class) //spring boot的执行入口类
@Transactional  //所有数据库操作 在测试用例执行之后会回滚  也就是测试不会影响到数据库的数据
public class BaseTest {
	
}
