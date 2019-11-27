package com.dao;

import com.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoDao {
    List<UserInfo> getAll(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    void delete(int id);

    void insert(String name);
}
