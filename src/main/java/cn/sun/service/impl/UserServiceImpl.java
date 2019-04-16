package cn.sun.service.impl;

import cn.sun.dao.UserDao;
import cn.sun.dto.UserDTO;
import cn.sun.pojo.User;
import cn.sun.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: SXH
 * \* Date: 2019/4/9
 * \
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public UserDTO find(String id) {
        User user = userDao.find(id);

        return converModel2DTO(user);
    }
    private UserDTO converModel2DTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setAccount(user.getAccount());
        userDTO.setName(user.getName());
        return  userDTO;
    }
}
