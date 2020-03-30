package rs.engineering.javacourse.myspringmvcapp.repository.impl;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import rs.engineering.javacourse.myspringmvcapp.entity.CityEntity;
import rs.engineering.javacourse.myspringmvcapp.repository.IRepository;

@Repository("cityJpaRepository")
public class CityJpaRepository implements IRepository<CityEntity> {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public CityEntity saveOrUpdate(CityEntity entity) {
		System.out.println("pre persist" + entity.toString());
		entityManager.persist(entity);
		System.out.println("posle persist" + entity.toString());

		return entity;

	}

	@Override
	public void delete(CityEntity entity) {

		entityManager.remove(entityManager.find(CityEntity.class, entity.getNumber()));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CityEntity> findAll() {

		return entityManager.createNamedQuery("City.getAll").getResultList();

	}

	@Override
	public CityEntity findById(Long id) {

		return entityManager.createNamedQuery("City.getByNumber", CityEntity.class).setParameter("number", id)
				.getSingleResult();

	}

	@Override
	public CityEntity findByName(CityEntity entity) {
		CityEntity cityEntity = entityManager.createNamedQuery("City.getByName", CityEntity.class)
				.setParameter("name", entity.getName()).getSingleResult();

		return cityEntity;
	}

	@Override
	public List<CityEntity> findAllByPredicates(Collection<Predicate<CityEntity>> predicates) {
		List<CityEntity> allfrom = entityManager.createQuery("select u from City u", CityEntity.class).getResultList();
		Stream<CityEntity> allStream = allfrom.stream();
		for (Predicate<CityEntity> predicate : predicates) {
			allStream = allStream.filter(predicate);
		}

		return allStream.collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long id) {

		CityEntity tr = entityManager.find(CityEntity.class, id);
		System.out.println("id - " + id);
		System.out.println("citytt" + tr.toString());
		entityManager.remove(tr);

	}

}
