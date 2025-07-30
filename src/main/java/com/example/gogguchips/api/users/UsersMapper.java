package com.example.gogguchips.api.users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UsersMapper {
    void insertUser(UsersData user);
    UsersData selectUserById(String id);
    UsersData selectUserByAccount(String account);
    UsersData selectUserByEmail(String email);
}