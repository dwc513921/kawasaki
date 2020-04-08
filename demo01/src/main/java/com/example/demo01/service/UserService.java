package com.example.demo01.service;

import com.example.demo01.mapper.UserMapper;
import com.example.demo01.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper usermapper;

    public int count (){
        return usermapper.count();
    }

    public List<User> InfoAll(int page, int limit){
        return usermapper.InfoAll(page,limit);
    }

    public List<User> getInfoByName(String name,int page, int limit){
        return usermapper.getInfoByName(name,page,limit);
    }
}
