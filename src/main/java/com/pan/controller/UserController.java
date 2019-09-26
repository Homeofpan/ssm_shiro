package com.pan.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("login")
	public String toLoginPage() {
		return "login";
	}
	@GetMapping("noAuth")
	public String noAuth() {
		return "noAuth";
	}
	
	//@RequiresAuthentication
	@GetMapping("user/index")
	public String userIndex() {
		return "user/index";
	}
	
	//注意使用注解时,没有权限或者没有登录会抛出异常,而不会转去配置文件配置的noAuth页面
	//要处理这个问题,需要在mvc的配置文件中来捕捉这些异常信息，指定捕获异常后需要跳转的页面
	//@RequiresPermissions(value= {"user:add"})
	@GetMapping("add")
	public String add() {
		return "user/add";
	}
	
	//@RequiresPermissions(value= {"user:update"})
	@GetMapping("update")
	public String update() {
//		SecurityUtils.getSecurityManager().getSession(key)
		return "user/update";
	}
	
	
	@PostMapping("login")
	public String login(String name,String password,Boolean isRememberMe,Model model,RedirectAttributes attributes) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(name,password);
		if(isRememberMe != null) {
			token.setRememberMe(isRememberMe);
		}
		try {
			subject.login(token);
			Session session = subject.getSession();
			session.setAttribute("myuser", "user");
			return "redirect:user/index";
		} catch (UnknownAccountException e) {
			attributes.addAttribute("msg","用户名或密码错误");
			return "redirect:login";
		} catch (IncorrectCredentialsException e) {
			attributes.addAttribute("msg","用户名或密码错误");
			return "redirect:login";
		} catch (ExcessiveAttemptsException e) {
			attributes.addAttribute("msg","登录失败次数过多,拒绝登录");
			return "redirect:login";
		} catch (AuthenticationException eExcessiveAttemptsException) {
			attributes.addAttribute("msg","登录失败,请重试");
			return "redirect:login";
		}
	}
}
