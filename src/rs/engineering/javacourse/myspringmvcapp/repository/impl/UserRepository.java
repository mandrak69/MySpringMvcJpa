package rs.engineering.javacourse.myspringmvcapp.repository.impl;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import rs.engineering.javacourse.myspringmvcapp.entity.CompanyEntity;
import rs.engineering.javacourse.myspringmvcapp.entity.UserEntity;
import rs.engineering.javacourse.myspringmvcapp.repository.IRepository;

@Repository(value = "userJpaRepository")
public class UserRepository implements IRepository<UserEntity> {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public UserEntity saveOrUpdate(UserEntity entity) {

		UserEntity cityEntity = entityManager.merge(entity);

		return cityEntity;
	}

	@Override
	public void delete(UserEntity entity) {

		UserEntity cityEntity = entityManager.find(UserEntity.class, entity.getId());
		entityManager.remove(cityEntity);

	}

	@Override
	public List<UserEntity> findAll() {

		@SuppressWarnings("unchecked")
		List<UserEntity> allFind = entityManager.createNamedQuery("User.getAll").getResultList();

		return allFind;
	}

	@Override
	public UserEntity findById(Long id) {

		UserEntity cityEntity = entityManager.createNamedQuery("User.getById", UserEntity.class)
				.setParameter("id", id).getSingleResult();

		return cityEntity;
	}

	@Override
	public UserEntity findByName(UserEntity entity) {
		UserEntity cityEntity = entityManager.createNamedQuery("User.getByEmail", UserEntity.class)
				.setParameter("email", entity.getEmail()).getSingleResult();

		return cityEntity;
	}

	@Override
	public List<UserEntity> findAllByPredicates(Collection<Predicate<UserEntity>> predicates) {
		List<UserEntity> allfrom = entityManager.createQuery("select u from User u", UserEntity.class).getResultList();
		Stream<UserEntity> allStream = allfrom.stream();
		for (Predicate<UserEntity> predicate : predicates) {
			allStream = allStream.filter(predicate);
		}

		return allStream.collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long id) {
		UserEntity userEntity = entityManager.find(UserEntity.class, id);
		entityManager.remove(userEntity);

	}

	public void getSqlBuildRes() {

		CriteriaBuilder criteriaBuilderObj = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> queryObj = criteriaBuilderObj.createQuery();
		Root<UserEntity> from = queryObj.from(UserEntity.class);

		// Step #1 - Displaying All Records
		System.out.println("\n! Display All Records For The 'user' Table !\n");
		CriteriaQuery<Object> selectQuery = queryObj.select(from);

		TypedQuery<Object> typedQuery = entityManager.createQuery(selectQuery);
		List<Object> employeeList = typedQuery.getResultList();

//-----------------------------------
		// SELECT c FROM Country c WHERE c.population > :p
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserEntity> q = cb.createQuery(UserEntity.class);
		Root<UserEntity> c = q.from(UserEntity.class);
		ParameterExpression<Integer> p = cb.parameter(Integer.class);

		q.select(c).where(cb.gt(c.get("population"), p));

		TypedQuery<UserEntity> query = entityManager.createQuery(q);
		query.setParameter(p, 10000000);
		List<UserEntity> results = query.getResultList();
		// -------------------------------------------------------
//	        SELECT c.firstname, SUM(c.lastname)
//	        FROM Country c
//	        WHERE 'Pera' MEMBER OF c.ROLE
//	        GROUP BY c.email
//	        HAVING COUNT(c) > 1
//	        

		CriteriaQuery<UserEntity> q1 = cb.createQuery(UserEntity.class);
		ParameterExpression<Integer> p1 = cb.parameter(Integer.class);
		Root<UserEntity> c1 = q1.from(UserEntity.class);
		q1.multiselect(c1.get("firstname"), cb.sum(c1.get("lastname")));
		q1.where(cb.isMember("Pera", c1.get("ROLE")));
		q1.groupBy(c1.get("email"));
		q1.having(cb.gt(cb.count(c1), 1));

		TypedQuery<UserEntity> query1 = entityManager.createQuery(q1);
		query1.setParameter(p, 10000000);
		List<UserEntity> results1 = query1.getResultList();

	}

}
