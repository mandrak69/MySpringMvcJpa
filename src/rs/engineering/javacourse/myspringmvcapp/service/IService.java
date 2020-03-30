package rs.engineering.javacourse.myspringmvcapp.service;

import java.util.List;

import rs.engineering.javacourse.myspringmvcapp.entity.CityEntity;
import rs.engineering.javacourse.myspringmvcapp.model.DTO;

public interface IService<T> {

	public T findById(long id);

	public T saveOrUpdate(final T entity);


	public void deleteById(final long entityId);

	public T findByObject(T t);

	public boolean validate(T t);

	public List<DTO> getAll(Class<? extends DTO> c);

	public DTO convertToDto(T u, Class<? extends DTO> cl);

	public T convertToEntity(DTO dto);



	


}
