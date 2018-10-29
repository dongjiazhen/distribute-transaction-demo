package com.zhuguang.jack.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zhuguang.jack.db1.dao.UserDb1Mapper;
import com.zhuguang.jack.db2.dao.UserDb2Mapper;
import com.zhuguang.jack.service.UserService;
import com.zhuguang.jack.vo.UserVO;
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserDb1Mapper db1Mapper;
    
    @Autowired
    UserDb2Mapper db2Mapper;
    
    /** 
     *  往期视频加小露老师QQ：1533922121
     *  Jack老师QQ： 2943489129
     *  时间   ：     2018年1月5日 下午8:32:53 
     *  作者   ：   烛光学院【Jack老师】
     *  
     *  这个方法需要对两个数据库进行操作
     */
    @Transactional(rollbackFor = Exception.class)
    public int addUser(UserVO user) throws Exception {
        
        //这个操作的db1数据库
        db1Mapper.addUser(user);
        //这个操作的是db2数据库
        db2Mapper.addUser(user);
        
        //throw new RuntimeException("自定义异常！");
        
        return 1;
    }
}
