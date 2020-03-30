package rs.engineering.javacourse.myspringmvcapp.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import rs.engineering.javacourse.myspringmvcapp.entity.CompanyEntity;
import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.model.CompanyDto;
import rs.engineering.javacourse.myspringmvcapp.model.DTO;
import rs.engineering.javacourse.myspringmvcapp.service.IService;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {
	@Qualifier(value = "cityService")
	@Autowired
	private IService<CityEntity> cityService;
	
	@Qualifier(value = "companyService")
	@Autowired
	private IService<CompanyEntity> companyService;
	/*
	@GetMapping
	public String home() {
		System.out.println("====================================================================");
		System.out.println("====================   CompanyController: home()  ===================");
		System.out.println("====================================================================");
		return "company/home";
	}
	*/
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showAllCompany() {
		ModelAndView modelAndView = new ModelAndView("company/getAll");
		 List<DTO> list = companyService.getAll(CompanyDto.class);
		modelAndView.addObject("list", list);
		return modelAndView;
	}
	
	
	
	@RequestMapping("getAll")
	public String viewemp(Model m) {
		
		return "redirect:/company/getAll";
	}
	
	@ModelAttribute(value = "cities")
	private List<DTO> getAllCities() {
		return cityService.getAll(CityDto.class);
	}
	@GetMapping(value = "add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================   cities ctrl: add()     ===================");
		ModelAndView modelAndView = new ModelAndView("companies/add");
		
		CompanyDto companyDto = new CompanyDto();
		modelAndView.addObject("companyDto",companyDto);
		modelAndView.addObject("cities", getAllCities());
		return modelAndView;
	}
	@RequestMapping(value = "/addModel", method = RequestMethod.GET)
	public String addModel(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("action", "Action: add new Company");
		return "companies/addModel";
	}
	/* Anotacija zbog koje poziva metodu pre starta jsp forme*/
	
	
	@ModelAttribute(name = "companyDto")
	public CompanyDto company() {
		return new CompanyDto("Bestragija", "Negde" ,"-  ",null);
	}
	

	@RequestMapping(value = "/saveModel", method = RequestMethod.POST)
	public String saveModel(@ModelAttribute(name = "companyDto") CompanyDto companyDto) {
		System.out.println(companyDto);
		companyService.saveOrUpdate(companyService.convertToEntity(companyDto));
		return "redirect:/company/getAll";
	}
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute(name="companyDto") CompanyDto companyDto, BindingResult result) {
		System.out.println("-1-2-"+companyDto);
		ModelAndView modelAndView=new ModelAndView();
		
		if (result.hasErrors()) {
			modelAndView.setViewName("company/add");
			System.out.println("================================ NOT OK =================================");
			modelAndView.addObject("companyDto",companyDto);
		}else {
			modelAndView.setViewName("company/home");
			System.out.println("================================     OK =================================");
			System.out.println(companyDto.toString());
			companyService.saveOrUpdate(companyService.convertToEntity(companyDto));		}
		return modelAndView;
	}
	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model m) {
		CompanyEntity company = companyService.findById(id);
		m.addAttribute("command", company);
		return "company/edit";
	}
	// It updates model object. 
		@RequestMapping(value = "/editsave", method = RequestMethod.POST)
		public String editsave(@ModelAttribute("companyDto") CompanyDto companyDto) {
			companyService.saveOrUpdate(companyService.convertToEntity(companyDto));
			return "redirect:/company/getAll";
		}
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String delete(@PathVariable int id) {
			companyService.deleteById(id);
			return "redirect:/company/getAll";
		}
}

/*
public class CompanyController {
	@Autowired
	CompanyService companyService;

	

	@RequestMapping("/add")
	public String showform(Model m) {
		m.addAttribute("command", new CompanyDto());
		return "company/add";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("company") CompanyDto company) {
		companyService.save(company);
		return "redirect:/companies/getAll";
	}

	@RequestMapping("/getAll")
	public String viewemp(Model m) {
		List<CompanyDto> list = companyService.getAll();
		m.addAttribute("list", list);
		return "company/getAll";
	}

	
	 It updates model object. 
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("company") CompanyDto company) {
		companyService.update(company);
		return "redirect:/companies/getAll";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		companyService.removeById(id);
		return "redirect:/companies/getAll";
	}

	@RequestMapping(value = "/addModel", method = RequestMethod.GET)
	public String addModel(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("action", "Action: add new Company");
		return "company/addModel";
	}

	@ModelAttribute(name = "companyDto")
	public CompanyDto company() {
		return new CompanyDto("Bestragija", "Negde");
	}

	@RequestMapping(value = "/saveModel", method = RequestMethod.POST)
	public String saveModel(@ModelAttribute(name = "user") CompanyDto company) {
		System.out.println(company);
		companyService.save(company);
		return "redirect:/companies/getAll";
	}

}
*/