package cn.sun.service.impl;

import cn.sun.dao.UserMoodPraiseRelDAO;
import cn.sun.pojo.UserMoodPraiseRel;
import cn.sun.service.UserMoodPraiseRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: SXH
 * \* Date: 2019/4/9
 * \
 */
@Service
public class UserMoodPraiseRelServiceImpl implements UserMoodPraiseRelService {
    @Resource
    private UserMoodPraiseRelDAO userMoodPraiseRelDAO;

    @Override
    public boolean save(UserMoodPraiseRel userMoodPraiseRel) {
        return userMoodPraiseRelDAO.save(userMoodPraiseRel);
    }
}
