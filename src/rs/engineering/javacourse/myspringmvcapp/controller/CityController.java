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

import rs.engineering.javacourse.myspringmvcapp.entity.CityEntity;
import rs.engineering.javacourse.myspringmvcapp.entity.UserEntity;
import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.model.DTO;
import rs.engineering.javacourse.myspringmvcapp.model.UserDto;
import rs.engineering.javacourse.myspringmvcapp.model.UserUpdateDto;
import rs.engineering.javacourse.myspringmvcapp.service.IService;

@Controller
@RequestMapping(value = "/cities")
public class CityController {
	@Qualifier(value = "cityService")
	@Autowired
	private  IService<CityEntity> cityService;

	public CityController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("getAll")
	public String viewemp(Model m) {
		List<DTO> list = cityService.getAll(CityDto.class);
		m.addAttribute("list", list);
		return "city/getAll";
	}

	
	
	@ModelAttribute(name = "cityDto")
	public CityDto company() {
		return new CityDto(0L,"Bestragija");
	}
	@RequestMapping("/add")
	public String showform(Model m) {
		m.addAttribute("command", new CityDto(0l, "N/A"));
		return "city/add";
	}
	/*
	@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String addModel(HttpServletRequest request, HttpServletResponse response) {
			request.setAttribute("action", "Action: add new user");
			return "city/addModel";
		}
*/
	@GetMapping(value = "addModel")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: add()     ===================");
		System.out.println("====================================================================");
		ModelAndView modelAndView = new ModelAndView("city/add");
		
		DTO cityDto = new CityDto(0l, "N/A");
		modelAndView.addObject("cityDto",cityDto);
		
		return modelAndView;
	}
	
	
	
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute(name="cityDto") @Valid CityDto cityDto, BindingResult result) {
	//public String save (CityDto cityDto) {
		System.out.println("====================   CityController: save(@ModelAttribute)    ===================");
		ModelAndView modelAndView=new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName("city/add");
			System.out.println("====================   NOT OK    ===================");
			modelAndView.addObject("cityDto",cityDto);
		}else {
			modelAndView.setViewName("city/getAll");
			System.out.println(cityDto);
			System.out.println("====================   OK        ===================");
			cityService.saveOrUpdate(cityService.convertToEntity(cityDto));
			
		}
		return modelAndView;
	}
	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model m) {
		CityEntity city = cityService.findById(id);
		m.addAttribute("command", city);
		return "city/edit";
	}
	
	
	    // It updates model object. 
		@RequestMapping(value = "editsave", method = RequestMethod.POST)
		public String editsave(@ModelAttribute("city") CityDto city) {
			cityService.saveOrUpdate(cityService.convertToEntity(city));
			return "redirect:/cities/getAll";
		}

		@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
		public String delete(@PathVariable int id) {
			cityService.deleteById(id);
			return "redirect:/cities/getAll";
		}

		
		@RequestMapping(value = "/saveModel", method = RequestMethod.POST)
		public String saveModel(@ModelAttribute(name = "cityDto") CityDto city) {
			System.out.println(city);
			cityService.saveOrUpdate(cityService.convertToEntity(city));
			return "redirect:/cities/getAll";
		}
}
