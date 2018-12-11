package polaris.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import polaris.entity.User;
import polaris.service.UserService;
import polaris.util.ImageUtil;

@RestController
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/queryUsers")
	public List<Map<String,Object>> queryUsers(){
		return userService.queryUsers();
	}
	
	@RequestMapping(value="/queryAllUsers")
	public List<User> queryAllUsers(){
		return userService.queryAllUsers();
	}
	
	@RequestMapping(value="/")
	public ModelAndView index(){
		return new ModelAndView("index");
	}
	@RequestMapping(value="/toLoginPage")
	public ModelAndView toLoginPage(){
		return new ModelAndView("loginPage");
	}
	@RequestMapping(value="/capture")
	public ModelAndView capture(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		BufferedImage bi = ImageUtil.createImage(req.getSession(), 4);
		ImageIO.write(bi, "png", resp.getOutputStream());
		return null;
	}
	
	@RequestMapping(value="/user/{id}")
	public String userOptions(HttpServletRequest req, 
			@PathVariable("id") Integer id,				//'_method' : 'put'
			@RequestParam Map<String, Object> params){
		System.out.println(id);
		params.forEach((k,v)->System.out.println(k+"->"+v));
		String method = req.getMethod().toUpperCase();
		switch (method) {
		case "GET":
			
			break;
		case "POST":
			
			break;
		case "PUT":
			System.out.println("123456");
			break;
		case "DELETE":
			
			break;
		}
		return "Hello wo1rld";
	}
	
	
}
