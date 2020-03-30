package rs.engineering.javacourse.myspringmvcapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rs.engineering.javacourse.myspringmvcapp.entity.UserEntity;
import rs.engineering.javacourse.myspringmvcapp.model.DTO;
import rs.engineering.javacourse.myspringmvcapp.model.UserDto;
import rs.engineering.javacourse.myspringmvcapp.model.UserUpdateDto;
import rs.engineering.javacourse.myspringmvcapp.service.IService;

@Controller
@RequestMapping(value="/users")
public class UserController {
	@Qualifier(value = "userService")
	@Autowired
	private IService<UserEntity> userService;
	



	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}



	@RequestMapping(method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response) {
	
		return "redirect:/users/getAll";
	}
	
	
	@RequestMapping("getAll")
	public String viewemp(Model m) {
		List<DTO> list = userService.getAll(UserDto.class);
		m.addAttribute("list", list);
		return "user/getAll";
	}
	
	
	@RequestMapping("/add")
	public String showform(Model m) {
		m.addAttribute("command", new UserUpdateDto("--", "N/A","98","ter"));
		return "user/add";
	}
	
		
		
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") UserDto user) {
		userService.saveOrUpdate(userService.convertToEntity(user));
		return "redirect:/users/getAll";
	}
	/*
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute(name="userFullDto") @Valid UserDto userFullDto, BindingResult result) {
	//public String save (UserDto userDto) {
		System.out.println("====================   UserController: save(@ModelAttribute)    ===================");
		ModelAndView modelAndView=new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName("user/add");
			System.out.println("====================   NOT OK    ===================");
			modelAndView.addObject("userFullDto",userFullDto);
		}else {
			modelAndView.setViewName("users/getAll");
			System.out.println(userFullDto);
			System.out.println("====================   OK        ===================");
			userService.saveOrUpdate(userService.convertToEntity(userFullDto));
		}
		return modelAndView;
	}

*/


	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model m) {
		UserEntity user = userService.findById(id);
		m.addAttribute("command", user);
		return "user/edit";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("user") UserDto user) {
		userService.saveOrUpdate(userService.convertToEntity(user));
		return "redirect:/users/getAll";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		userService.deleteById(id);
		return "redirect:/users/getAll";
	}

	@RequestMapping(value = "/addModel", method = RequestMethod.GET)
	public String addModel(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("action", "Action: add new user");
		return "user/addModel";
	}

	@ModelAttribute(name = "userDto")
	public UserDto user() {
		return new UserDto("guest", "guest", "", "");
	}

	@RequestMapping(value = "/saveModel", method = RequestMethod.POST)
	public String saveModel(@ModelAttribute(name = "userDto") UserDto user) {
		System.out.println(user);
		userService.saveOrUpdate(userService.convertToEntity(user));
		return "redirect:/users/getAll";
	}

}