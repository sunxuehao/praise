package cn.sun.dao;

import cn.sun.pojo.Mood;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoodDao {
    List<Mood> findAll();
    boolean update(@Param("mood") Mood mood);
    Mood findById(int id);
}
