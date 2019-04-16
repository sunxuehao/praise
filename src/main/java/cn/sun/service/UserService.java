package cn.sun.service;

import cn.sun.dto.MoodDTO;
import cn.sun.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO find(String id);
}
