package com.example.mapper;

import com.example.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;

/**
 * @author WangRui
 */
@Controller
@Mapper
public interface LoginMapper {

    User check(User user);

    User findUserById(String id);
}
