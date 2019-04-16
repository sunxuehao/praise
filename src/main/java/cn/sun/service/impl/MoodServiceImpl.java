package cn.sun.service.impl;

import cn.sun.dao.MoodDao;
import cn.sun.dao.UserDao;
import cn.sun.dao.UserMoodPraiseRelDAO;
import cn.sun.dto.MoodDTO;
import cn.sun.pojo.Mood;
import cn.sun.pojo.User;
import cn.sun.pojo.UserMoodPraiseRel;
import cn.sun.service.MoodService;
import cn.sun.service.UserService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.print.attribute.standard.Destination;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: SXH
 * \* Date: 2019/4/9
 * \
 */
@Service
public class MoodServiceImpl implements MoodService {
    @Resource
    private MoodDao moodDao;

    @Resource
    private UserDao userDao;

    //    千万别忘记加上resource注释啊！！！！！！！
    @Resource
    private UserMoodPraiseRelDAO userMoodPraiseRelDAO;

    @Resource
    private RedisTemplate redisTemplate;
    //    设置一个命名的规范：项目名称+模块名称+具体内容
    private static final String PRAISE_HASH_KEY = "springmv.mybatis.boot.mood.id.list.key";

    @Override
    public List<MoodDTO> findAll() {
        List<Mood> moodList = moodDao.findAll();

        return converModel2DTO(moodList);
    }

    @Override
    public boolean praiseMood(int userId, int moodId) {
        UserMoodPraiseRel userMoodPraiseRel = new UserMoodPraiseRel();
        userMoodPraiseRel.setUserId(userId);
        userMoodPraiseRel.setMoodId(moodId);
        userMoodPraiseRelDAO.save(userMoodPraiseRel);
        Mood mood = this.findById(moodId);
        mood.setPraiseNum(mood.getPraiseNum() + 1);
        this.update(mood);
        return Boolean.TRUE;
    }

    @Override
    public boolean update(Mood mood) {
        return moodDao.update(mood);
    }

    @Override
    public Mood findById(int id) {
        return moodDao.findById(id);
    }

    @Override
    public boolean praiseMoodForRedis(int userId, int moodId) {
        MoodDTO moodDTO = new MoodDTO();
        moodDTO.setUserId(String.valueOf(userId));
        moodDTO.setId(moodId);

        redisTemplate.opsForSet().add(PRAISE_HASH_KEY, moodId);
        redisTemplate.opsForSet().add(moodId, userId);
        return false;

    }


    @Resource
    private UserService userService;

    @Override
    public List<MoodDTO> findAllForRedis() {
        List<Mood> moodList = moodDao.findAll();
        if (CollectionUtils.isEmpty(moodList)) {
            return Collections.EMPTY_LIST;
        }
        List<MoodDTO> moodDTOList = new ArrayList<MoodDTO>();
        for (Mood mood : moodList) {
            MoodDTO moodDTO = new MoodDTO();
            moodDTO.setId(mood.getId());
            moodDTO.setUserId(mood.getUserId());
            moodDTO.setPraiseNum(mood.getPraiseNum() + redisTemplate.opsForSet().size(mood.getId()).intValue());
            moodDTO.setPublishTime(mood.getPublishTime());
            moodDTO.setContent(mood.getContent());

            User user = userDao.find(mood.getUserId());
            moodDTO.setUserName(user.getName());
            moodDTO.setUserAccount(user.getAccount());
            moodDTOList.add(moodDTO);

        }
        return moodDTOList;
    }

    private List<MoodDTO> converModel2DTO(List<Mood> moodList) {
        if (CollectionUtils.isEmpty(moodList)) {
            return Collections.EMPTY_LIST;
        }
        List<MoodDTO> moodDTOList = new ArrayList<MoodDTO>();

        for (Mood mood : moodList) {
            MoodDTO moodDTO = new MoodDTO();
            moodDTO.setId(mood.getId());
            moodDTO.setContent(mood.getContent());
            moodDTO.setPraiseNum(mood.getPraiseNum());
            moodDTO.setPublishTime(mood.getPublishTime());
            moodDTO.setUserId(mood.getUserId());
            moodDTOList.add(moodDTO);
//            设置用户信息
            User user = userDao.find(mood.getUserId());
            moodDTO.setUserName(user.getName());
            moodDTO.setUserAccount(user.getAccount());
        }
        return moodDTOList;
    }
}
