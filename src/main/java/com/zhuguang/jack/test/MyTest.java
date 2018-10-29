package com.zhuguang.jack.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.zhuguang.jack.service.UserService;
import com.zhuguang.jack.vo.UserVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:context/test-beans.xml")
public class MyTest {
    
    @Autowired
    UserService userService;
    /**
     * 这个项目主要是实现分布式事务管理
     * 主要采用atomikos实现。
     * 主要采用XA：分布式事务协议：事务管理器（管理各个资源的事务的提交和回滚） 和 本地资源管理器（商业数据库：Oracle、MySQL、DB2）
     * 这里使用2个数据库进行测试。
     */
    @Test
    public void test1() {
    	
        UserVO uservo = new UserVO();
        uservo.setPassword("123");
        uservo.setSex(1);
        uservo.setUsername("admin");
        try {
            userService.addUser(uservo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
