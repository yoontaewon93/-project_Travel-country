package com.study.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.study.springboot.dto.Member;

//스프링 프레임워크에서는 Entity의 기본적인 삽입, 조회, 수정, 삭제가 가능하도록 
//CrudRepository라는 인터페이스를 만들어 놓음.
public interface MemberRepository extends CrudRepository<Member, Long> {
	//메소드 이름을 기반(Query Method)으로 해서 만들어도 되고 
	//@Query를 이용해 기존의 SQL처럼 만들어도 됩니다.
	//Query Method 종류 : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
	
	List<Member> findByNameAndAgeLessThan(String name, int age);

	@Query("select t from Member t where name=:name and age < :age")
	List<Member> findByNameAndAgeLessThanSQL(@Param("name") String name, @Param("age") int age);
	
	List<Member> findByNameAndAgeLessThanOrderByAgeDesc(String name, int age);
	
	List<Member> findAllByNameLike(String name);

}

