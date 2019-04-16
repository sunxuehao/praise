package cn.sun.test;

import cn.sun.dao.UserDao;
import cn.sun.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: SXH
 * \* Date: 2019/4/5
 * \
 */
public class UserDaoTest extends BaseJunit4Test {
    @Resource
    private UserDao userDao;

    @Test
    public void find(){
        User sun_userList = userDao.find("1");
        System.out.println(sun_userList);
    }

}
