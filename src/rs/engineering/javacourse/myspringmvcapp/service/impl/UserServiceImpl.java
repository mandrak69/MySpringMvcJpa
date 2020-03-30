package rs.engineering.javacourse.myspringmvcapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.engineering.javacourse.myspringmvcapp.config.DtoUtils;
import rs.engineering.javacourse.myspringmvcapp.entity.UserEntity;
import rs.engineering.javacourse.myspringmvcapp.model.DTO;
import rs.engineering.javacourse.myspringmvcapp.model.UserCreateDto;
import rs.engineering.javacourse.myspringmvcapp.model.UserReadDto;
import rs.engineering.javacourse.myspringmvcapp.model.UserUpdateDto;
import rs.engineering.javacourse.myspringmvcapp.repository.IRepository;
import rs.engineering.javacourse.myspringmvcapp.service.IService;
@Transactional
@Service(value = "userService")
public class UserServiceImpl implements IService<UserEntity> {

	
	@Qualifier(value = "userJpaRepository")
	@Autowired
	private IRepository<UserEntity> userRepository;

	@Autowired
	private ModelMapper modelMapper;
	

	// ---------------------- vraca zeljenu DTO klasu od Entity klase

	public DTO createUserDTO() {
		UserEntity user = new UserEntity();
//		  user.setId(1);
//		  user.setName(“User number 1”);
//		  user.setEmail(“Email number 1”);
//		  user.setPassword(“Password number 1”);
//		 
		return new DtoUtils().convertToDto(user, new UserCreateDto());
	}

	public DTO readUser() {
		UserEntity user = new UserEntity();
//		  user.setId(1);
//		  user.setName(“User number 1”);
//		  user.setEmail(“Email number 1”);
//		  user.setPassword(“Password number 1”);
//		 
		return new DtoUtils().convertToDto(user, new UserReadDto());
	}
//  convert from userDTO ->Entity then Entity-> to USERUpdateDTO object ... two converts
	
	
	public DTO updateUser(DTO userDTO) {
		UserEntity user = (UserEntity) new DtoUtils().convertToEntity(new UserEntity(), userDTO);

		return new DtoUtils().convertToDto(user, new UserUpdateDto());
	}

	@Override
	public UserEntity findById(long id) {
		UserEntity userEntity = userRepository.findById(id);
		return userEntity;
	}
	// call from ctrl to save instance of dtoImpl object

		public UserEntity create(DTO dto) {
			UserEntity userEntity = modelMapper.map(dto, UserEntity.class);
			System.out.println(userEntity.toString());
			if (validate(userEntity)) {
				userRepository.saveOrUpdate(userEntity);
			}
			return userEntity;
		}

		@Override
		public List<DTO> getAll(Class<?  extends DTO> c) {

			List<DTO> citiesDto = new ArrayList<>();
			List<UserEntity> cityiesEntity = userRepository.findAll();
			for (UserEntity userEntity : cityiesEntity) {
				citiesDto.add(convertToDto(userEntity, c));
			}
			return citiesDto;
		}

	

		@Override
		public UserEntity saveOrUpdate(UserEntity userEntity) {
			if (validate(userEntity)) {
				userEntity=userRepository.saveOrUpdate(userEntity);
			}
			return userEntity;
		}

		@Override
		public UserEntity findByObject(UserEntity userEntity) {
			System.out.println("-----nioje implement");
			return null;
		}

		@Override
		public DTO convertToDto(UserEntity u, Class<? extends DTO> cl) {
			DTO cityDto = (DTO) modelMapper.map(u, cl);

			return cityDto;
		}

		@Override
		public UserEntity convertToEntity(DTO cityDto) {
			UserEntity city = modelMapper.map(cityDto, UserEntity.class);
			return city;
		}

		@Override
		public boolean validate(UserEntity userEntity) {
			System.out.println("---- treba implementirati proveru DTO prema Entity objektu");
			return true;
		}


		@Override
		public void deleteById(long id) {

			userRepository.deleteById(id);
	

		}

	}
