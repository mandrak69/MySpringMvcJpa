package rs.engineering.javacourse.myspringmvcapp.formatter;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;

import rs.engineering.javacourse.myspringmvcapp.config.DtoUtils;
import rs.engineering.javacourse.myspringmvcapp.entity.CompanyEntity;
import rs.engineering.javacourse.myspringmvcapp.model.CompanyDto;
import rs.engineering.javacourse.myspringmvcapp.service.IService;

public class CompanyDtoFormatter implements Formatter<CompanyDto> {
	@Qualifier(value = "companyService")
	@Autowired
	private IService<CompanyEntity> companyService;

	

	@Override
	public String print(CompanyDto cityDto, Locale locale) {
		System.out.println("=======CompanyDTO : print============================================");
		System.out.println(cityDto);
		System.out.println("==========================================================================");
		return cityDto.toString();
	}

	@Override
	public CompanyDto parse(String city, Locale locale) {
		System.out.println("=======CompanyDTO: parse============================================");
		System.out.println(city);
		System.out.println("==========================================================================");

		Long number = Long.parseLong(city);
		System.out.println(number);
		System.out.println(locale + "--+locale++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		return (CompanyDto) new DtoUtils().convertToDto(companyService.findById(number), new CompanyDto());

	}
}
