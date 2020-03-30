package rs.engineering.javacourse.myspringmvcapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.engineering.javacourse.myspringmvcapp.entity.CityEntity;
import rs.engineering.javacourse.myspringmvcapp.model.DTO;
import rs.engineering.javacourse.myspringmvcapp.repository.impl.CityJpaRepository;
import rs.engineering.javacourse.myspringmvcapp.service.IService;

@Service(value = "cityService")
@Transactional
public class CityServiceImpl implements IService<CityEntity> {

	@Qualifier(value = "cityJpaRepository")
	@Autowired
	private CityJpaRepository cityRepository;

	@Autowired
	private ModelMapper modelMapper;

	// call from ctrl to save instance of dtoImpl object

	@Override
	public List<DTO> getAll(Class<? extends DTO> c) {

		List<DTO> citiesDto = new ArrayList<>();
		List<CityEntity> cityiesEntity = cityRepository.findAll();
		for (CityEntity cityEntity : cityiesEntity) {
			citiesDto.add(convertToDto(cityEntity, c));
		}
		return citiesDto;
	}

	@Override
	public CityEntity findById(long id) {
		CityEntity cityEntity = cityRepository.findById(id);
		return cityEntity;
	}

	@Override
	public CityEntity saveOrUpdate(CityEntity cityEntity) {
		if (validate(cityEntity)) {
			cityEntity=cityRepository.saveOrUpdate(cityEntity);
		}
		return cityEntity;
	}

	@Override
	public CityEntity findByObject(CityEntity cityEntity) {
		System.out.println("-----nioje implement");
		return null;
	}

	@Override
	public DTO convertToDto(CityEntity u, Class<? extends DTO> cl) {
		DTO cityDto = (DTO) modelMapper.map(u, cl);

		return cityDto;
	}

	@Override
	public CityEntity convertToEntity(DTO cityDto) {
		CityEntity city = modelMapper.map(cityDto, CityEntity.class);
		return city;
	}

	@Override
	public boolean validate(CityEntity cityEntity) {
		System.out.println("---- treba implementirati proveru DTO prema Entity objektu");
		return true;
	}

	@Override
	public void deleteById(long id) {

		cityRepository.deleteById(id);

	}

}
