package cn.sun.job;

import cn.sun.pojo.Mood;
import cn.sun.pojo.UserMoodPraiseRel;
import cn.sun.service.MoodService;
import cn.sun.service.UserMoodPraiseRelService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: SXH
 * \* Date: 2019/4/10
 * \
 */
@Component
@Configurable
@EnableScheduling
public class PraiseDataSaveDBJob {
    @Resource
    private RedisTemplate redisTemplate;
    private static final String PRAISE_HASH_KEY = "springmv.mybatis.boot.mood.id.list.key";

    @Resource
    private UserMoodPraiseRelService userMoodPraiseRelService;
    @Resource
    private MoodService moodService;

    @Scheduled(cron = "*/10 * * * * *")
    public void savePraiseDataToDB2(){
        Set<Integer> moods = redisTemplate.opsForSet().members(PRAISE_HASH_KEY);
        if (CollectionUtils.isEmpty(moods)){
            return;
        }
        for (int moodId : moods){
            if (redisTemplate.opsForSet().members(moodId) == null){
                continue;
            }else {
                Set<Integer> userIds = redisTemplate.opsForSet().members(moodId);
                if (CollectionUtils.isEmpty(userIds)){
                    continue;
                }else {
                    for (int userId : userIds){
                        UserMoodPraiseRel userMoodPraiseRel = new UserMoodPraiseRel();
                        userMoodPraiseRel.setMoodId(moodId);
                        userMoodPraiseRel.setUserId(userId);
                        userMoodPraiseRelService.save(userMoodPraiseRel);
                    }
                    Mood mood = moodService.findById(moodId);
                    mood.setPraiseNum(mood.getPraiseNum() + redisTemplate.opsForSet().size(moodId).intValue());
                    moodService.update(mood);
                    redisTemplate.delete(moodId);

                }
            }
        }
        redisTemplate.delete(PRAISE_HASH_KEY);
    }
}
