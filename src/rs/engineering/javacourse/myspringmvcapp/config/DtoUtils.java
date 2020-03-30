package rs.engineering.javacourse.myspringmvcapp.config;

import org.modelmapper.ModelMapper;

import rs.engineering.javacourse.myspringmvcapp.model.DTO;

public class DtoUtils {
	 
	  public DTO convertToDto(Object obj, DTO mapper) {
	    return new ModelMapper().map(obj, mapper.getClass());
	  }
	 
	  public Object convertToEntity(Object obj, DTO mapper) {
	    return new ModelMapper().map(mapper, obj.getClass());
	  }
	 }