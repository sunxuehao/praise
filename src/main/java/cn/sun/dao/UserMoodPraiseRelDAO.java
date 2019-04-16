package cn.sun.dao;

import cn.sun.pojo.UserMoodPraiseRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMoodPraiseRelDAO {
    boolean save(@Param("userMoodPraiseRel") UserMoodPraiseRel userMoodPraiseRel);
}
