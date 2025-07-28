package com.example.gogguchips.api.users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UsersMapper {
    void insertUser(UsersData user);
//    UsersData selectUserByEmail(String email);
    UsersData selectUserByAccount(String account);
}