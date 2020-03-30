package rs.engineering.javacourse.myspringmvcapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.engineering.javacourse.myspringmvcapp.entity.CityEntity;
import rs.engineering.javacourse.myspringmvcapp.entity.CompanyEntity;
import rs.engineering.javacourse.myspringmvcapp.model.DTO;
import rs.engineering.javacourse.myspringmvcapp.repository.IRepository;
import rs.engineering.javacourse.myspringmvcapp.service.IService;

@Service(value = "companyService")
@Transactional
public class CompanyServiceImpl implements IService<CompanyEntity> {

	@Qualifier(value = "companyJpaRepository")
	@Autowired
	private IRepository<CompanyEntity> companyRepository;
	
	@Qualifier(value = "cityJpaRepository")
	@Autowired
	private IRepository<CityEntity> cityRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	
	public CompanyServiceImpl() {
	}

	

	public List<DTO> getAll(Class<? extends DTO> c) {

		List<DTO> companiesDto = new ArrayList<>();
		List<CompanyEntity> companiesEntity = companyRepository.findAll();
		
		for (CompanyEntity companyEntity : companiesEntity) {
			System.out.println(companyEntity.toString());
			companiesDto.add(convertToDto(companyEntity, c));
		}
		return companiesDto;
	}

	@Override
	public CompanyEntity findById(long id) {
		CompanyEntity companyEntity = companyRepository.findById(id);
		return companyEntity;
	}

	

	@Override
	public CompanyEntity findByObject(CompanyEntity companyEntity) {
		System.out.println("-----nioje implement");
		return null;
	}

	@Override
	public DTO convertToDto(CompanyEntity u, Class<? extends DTO> cl) {
		 DTO companyDto = modelMapper.map(u, cl);

		return companyDto;
	}

	@Override
	public CompanyEntity convertToEntity(DTO cityDto) {
		CompanyEntity companyEntity = modelMapper.map(cityDto, CompanyEntity.class);
		return companyEntity;
	}

	@Override
	public boolean validate(CompanyEntity companyEntity) {
		System.out.println("---- treba implementirati proveru DTO prema Entity objektu");
		return true;
	}

	@Override
	public CompanyEntity saveOrUpdate(CompanyEntity entity) {
		if (validate(entity)) {
			entity = companyRepository.saveOrUpdate(entity);
		}
		return entity;
	}
	@Override
	public void deleteById(long id) {

		companyRepository.deleteById(id);

	}

	public IRepository<CityEntity> getCityRepository() {
		return cityRepository;
	}

	public void setCityRepository(IRepository<CityEntity> cityRepository) {
		this.cityRepository = cityRepository;
	}



	

}