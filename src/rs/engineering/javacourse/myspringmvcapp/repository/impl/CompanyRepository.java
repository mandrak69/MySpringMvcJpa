package rs.engineering.javacourse.myspringmvcapp.repository.impl;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import rs.engineering.javacourse.myspringmvcapp.entity.CompanyEntity;
import rs.engineering.javacourse.myspringmvcapp.repository.IRepository;



/*
 * zbog @Transaction nije uspevala anotacija da veze binove.....
 * 
 * 
 */



//@Transactional(propagation = Propagation.MANDATORY)
@Repository(value = "companyJpaRepository")
public class CompanyRepository implements IRepository<CompanyEntity> {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public CompanyEntity saveOrUpdate(CompanyEntity entity) {

		CompanyEntity companyEntity = entityManager.merge(entity);

		return companyEntity;
	}

	@Override
	public void delete(CompanyEntity entity) {

		CompanyEntity companyEntity = entityManager.find(CompanyEntity.class, entity.getNumber());
		entityManager.remove(companyEntity);

	}

	@Override
	public List<CompanyEntity> findAll() {

		@SuppressWarnings("unchecked")
		List<CompanyEntity> companyEntitys = entityManager.createNamedQuery("CompanyEntity.getAll").getResultList();

		return companyEntitys;
	}

	@Override
	public CompanyEntity findById(Long id) {

		CompanyEntity companyEntity = entityManager.createNamedQuery("CompanyEntity.findById", CompanyEntity.class)
				.setParameter("id", id).getSingleResult();

		return companyEntity;
	}

	@Override
	public CompanyEntity findByName(CompanyEntity entity) {
		CompanyEntity companyEntity = entityManager.createNamedQuery("CompanyEntity.findByName", CompanyEntity.class)
				.setParameter("name", entity.getName()).getSingleResult();

		return companyEntity;
	}

	@Override
	public List<CompanyEntity> findAllByPredicates(Collection<Predicate<CompanyEntity>> predicates) {
		List<CompanyEntity> allfrom = entityManager.createQuery("select u from City u", CompanyEntity.class).getResultList();
		Stream<CompanyEntity> allStream = allfrom.stream();
		for (Predicate<CompanyEntity> predicate : predicates) {
			allStream = allStream.filter(predicate);
		}

		return allStream.collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long id) {
		CompanyEntity companyEntity = entityManager.find(CompanyEntity.class, id);
		entityManager.remove(companyEntity);
		
	}

}
