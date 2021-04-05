package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.jdbc.IMyUserDAO;

@Controller
public class MyController {

	@Autowired
	private IMyUserDAO userDao;

	@RequestMapping("/")
	public @ResponseBody String root() throws Exception {
		return "MyBatis 예제";
	}
	
	//테스트 URL : http://localhost:8081/userlist
	//@GetMapping("/userlist") - GET방식 
	//@PostMapping("/userlist") - POST방식
	@RequestMapping(value="/userlist", method = RequestMethod.GET)
	public String userlist( Model model ) {
		model.addAttribute("users", userDao.list());
		return "userlist"; //userlist.jsp 호출됨.
	}

}







