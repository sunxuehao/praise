package cn.sun.pojo;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: SXH
 * \* Date: 2019/4/9
 * \
 */
public class UserMoodPraiseRel implements Serializable {
    private int id;
    private int userId;
    private int moodId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoodId() {
        return moodId;
    }

    public void setMoodId(int moodId) {
        this.moodId = moodId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
