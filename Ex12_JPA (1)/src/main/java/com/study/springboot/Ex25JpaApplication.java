package com.study.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.study.springboot.dao.MemberRepository;
import com.study.springboot.dto.Member;

import oracle.jdbc.proxy.annotation.Post;

@EntityScan(basePackages="com.study.springboot.dto")
@EnableJpaRepositories(basePackages="com.study.springboot.dao")
@SpringBootApplication
public class Ex25JpaApplication implements CommandLineRunner {

	@Autowired
	MemberRepository memberRepository;
	
   public static void main(String[] args) {
       SpringApplication.run(Ex25JpaApplication.class, args);
   }

	@Override
	public void run(String... args) throws Exception {

		//findAll()- select 문이고 전체를 조회합니다.
		//findOne() - select 문이고 특정값을 조회합니다. where절과 같습니다.
		//save() - insert 와 update문을 실행합니다.
		//delete - delete문을 실행합니다.	
		
		memberRepository.save(new Member("hong", 10));
		memberRepository.save(new Member("tom", 15));
		memberRepository.save(new Member("john", 10));
		memberRepository.save(new Member("hana", 5));
		
		Optional<Member> optionalPost = memberRepository.findById((long) 2);
		if (optionalPost.isPresent()) {
			Member member = optionalPost.get();
			System.out.println(member.toString());
		}
		
		Iterable<Member> list1 = memberRepository.findAll();
		
		System.out.println("findAll() Method.");
		for( Member m : list1){
			System.out.println(m.toString());
		}
		
		System.out.println("findByNameAndAgeLessThan() Method.");
		List<Member> list2 = memberRepository.findByNameAndAgeLessThan("hong", 15);
		for( Member m : list2){
			System.out.println(m.toString());
		}
		
		System.out.println("findByNameAndAgeLessThanSQL() Method.");
		List<Member> list3 = memberRepository.findByNameAndAgeLessThanSQL("hong", 15);
		for( Member m : list3){
			System.out.println(m.toString());
		}
		
		System.out.println("findByNameAndAgeLessThanSQL() Method.");
		List<Member> list4 = memberRepository.findByNameAndAgeLessThanOrderByAgeDesc("hong", 15);
		for( Member m : list4){
			System.out.println(m.toString());
		}

		System.out.println("findAllByNameLike() Method.");
		List<Member> list5 = memberRepository.findAllByNameLike("%o%");
		for( Member m : list5){
			System.out.println(m.toString());
		}
		
		//System.out.println("deleteAll() Method.");
		//memberRepository.deleteAll();
	}
}