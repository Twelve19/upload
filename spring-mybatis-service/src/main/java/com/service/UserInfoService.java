package com.service;

import com.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> getAll(int pageNum,int pageSize);

    void deleteAndinsert(int id,String name);
}
