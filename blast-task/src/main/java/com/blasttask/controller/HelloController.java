package com.blasttask.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.blasttask.entity.Fruit;



@Controller
@RequestMapping("hello")
public class HelloController {


	@RequestMapping(value="{fruit}.json", method = RequestMethod.GET)
	public @ModelAttribute  void sayHello(@PathVariable String fruit ,ModelMap model){
		Fruit ff=new Fruit();
		ff.setName(fruit);
		model.addAttribute("model",ff);
	}
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public @ModelAttribute void login(String username,String password,ModelMap model,HttpServletResponse response){
		/*String result="";
		if(username.equals("xbb") && password.equals("123")){
			result="登录成功";
			model.addAttribute("result", result);
			
		}else{
			result="登录失败";
			model.addAttribute("result", result);
		}*/
		try {
			response.getOutputStream().write(new String("登录成功").getBytes() );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="test.do", method = RequestMethod.GET)
	public  String login(String username,String password){
		String result="";
		if(username.equals("xbb") && password.equals("123")){
			result="登录成功";
			
		}else{
			result="登录失败";
		}
		return result;
	}
	
	@RequestMapping(value="uploadFile.do", method = RequestMethod.POST)
	public  String uploadFile(Fruit fruit,@RequestParam("file")CommonsMultipartFile file ) {
		System.out.println("afasdf");
//		System.out.println(fileUpload.getName());
		return null;
	}
}
