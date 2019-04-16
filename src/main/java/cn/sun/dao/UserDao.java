package cn.sun.dao;

import cn.sun.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
//    查询用户
    User find(String id);
}
