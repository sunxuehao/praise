package cn.sun.service;

import cn.sun.dto.MoodDTO;
import cn.sun.pojo.Mood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MoodService {
    List<MoodDTO> findAll();
    boolean praiseMood(int userId, int moodId);
    boolean update(@Param("mood")Mood mood);
    Mood findById(int id);

    boolean praiseMoodForRedis(int userId , int moodId);
    List<MoodDTO> findAllForRedis();
}
