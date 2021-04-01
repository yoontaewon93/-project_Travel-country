package com.study.springboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Entity: DB에 저장하기 위해서 유저가 정의한 클래스
@Entity
//@Entity의 클래스명과 데이터베이스의 테이블명이 다르면 
//@Table(name="XXX") 같은 형식으로 작성
//@Table(name="Users")
@Table(name="MEMBER")
public class Member {
	
	//@Id_어노테이션 : 일반적으로 키(primary key)를 가지는 변수에 선언합니다. 
	//@GeneratedValue 어노테이션 : 해당 Id 값을 어떻게 자동으로 생성할지 
	//          전략을 선택함. 여기서 선택한 전략은 "AUTO"입니다.
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_sequencer_gen")
	@SequenceGenerator(sequenceName = "member_seq", allocationSize = 1, name = "member_sequencer_gen")
	private long id;
	
	//@Column 선언은 꼭 필요한 것은 아님. 이름 변경시 선언.
	@Column(name="name") 
	private String name;
	
	@Column
	private int age;
	
	public Member() { } //초기생성자 필요함.
	
	public Member(String name, int age) { //필드가 있는 생성자
		this.name = name;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "[" + id + "] name = " + name + ", age = " + age;
	}
}

