package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
@Mapper
public interface UserDao {
    /**
    *
    *用户增加
    **/
   @Insert("insert into t_user(id,name,age) values (#{id},#{name},#{age})")
   void addUser(User user);
   
   /**
    *用户数据修改
    *
    *
    * @param user
    * */
   @Update("update t_user set name=#{name},age=#{age} where id=#{id}")
   void updateUser(User user);

   /**
    * 用户数据删除
    * @param id
    */
   @Delete("delete from t_user where id=#{id}")
   void deleteUser(int id);

   /***
    * 根据名称查询用户信息
    */
   @Select("select id,name,age FROM t_user where name=#{username}")
   User findByName(@Param("username")String username);

   /**
    * 查询所有
    */
   @Select("Select id,name,age FROM t_user")
   List<User> findAll();


}
