package com.study.springboot.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

//@Mapper : MyBatis의 객체매핑 어노테이션임.
@Mapper
public interface IMyUserDAO {
	List<MyUserDTO> list(); //mapper xml파일의 "list"와 연결됨.
}








