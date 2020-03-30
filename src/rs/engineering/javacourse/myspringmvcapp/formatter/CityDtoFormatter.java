package rs.engineering.javacourse.myspringmvcapp.formatter;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;

import rs.engineering.javacourse.myspringmvcapp.config.MyModelMapper;
import rs.engineering.javacourse.myspringmvcapp.entity.CityEntity;
import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.service.IService;

public class CityDtoFormatter implements Formatter<CityDto> {
	@Qualifier(value = "cityService")
	@Autowired
	private IService<CityEntity> cityService;
	private MyModelMapper modelMaper = new MyModelMapper();

	@Override
	public String print(CityDto cityDto, Locale locale) {
		System.out.println("==1=====CityDtoFormatter: print============================================");
		System.out.println(cityDto);
		System.out.println("===2=======================================================================");
		return cityDto.toString();
	}

	@Override
	public CityDto parse(String city, Locale locale) {
		System.out.println("=======CityDtoFormatter: parse============================================");
		System.out.println(city);
		System.out.println("==========================================================================");

		long number = Long.parseLong(city);
		System.out.println(locale + "--+locale++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 CityEntity ci= cityService.findById(number);
		System.out.println("iz formateraa a aaaaaa");
		CityDto k = modelMaper.map(ci, CityDto.class);
		//CityDto k = DtoUtils().convertToDto(cityService.findById(number), new CityDto());
		System.out.println("iz fromatera"  );
		return k;

	}

}
