package com.damon.user.mapper;

import com.damon.user.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;


@Mapper
public interface UserMapper {
	
	@Insert("insert into user(name,username,password,role,status) values(#{name},#{username},#{password},#{role},#{status})")
	@SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
	void addUser(User user);
	
	@Select("SELECT id FROM user where username=#{username}")
	Integer checkUser(@Param("username") String username);
	
	@Select("SELECT * FROM user where username=#{username}")
	User findUser(@Param("username") String username);

}
