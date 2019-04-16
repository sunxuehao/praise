package cn.sun.dto;

import cn.sun.pojo.Mood;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: SXH
 * \* Date: 2019/4/9
 * \
 */
public class MoodDTO extends Mood implements Serializable {
    private String userName;
    private String userAccount;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
