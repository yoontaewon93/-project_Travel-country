package com.study.springboot.jdbc;

import lombok.Data;

@Data
public class MyUserDTO {
	private int student_no;
	private String name;
	private int age;
	private String phone;
	private String address;
	private String memo;
	
	//jdbc Template - Mapper에서 필드가 있는 생성자를 넣으면 문제발생!
	//ojdbc6.jar 오른쪽클릭 후 add build path를 해서 추가해 줘야 됨.
	
	//Getter/Setter 생성
}
