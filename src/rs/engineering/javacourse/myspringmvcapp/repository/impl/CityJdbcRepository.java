package rs.engineering.javacourse.myspringmvcapp.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import rs.engineering.javacourse.myspringmvcapp.entity.CityEntity;
import rs.engineering.javacourse.myspringmvcapp.repository.IRepository;

@Repository(value = "cityJdbcRepository")
public class CityJdbcRepository implements IRepository<CityEntity> {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private SimpleJdbcInsert simpleJdbcInsert;

	private SimpleJdbcCall simpleJdbcCall;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public CityEntity saveOrUpdate(CityEntity cityEntity) {
		String query = "INSERT INTO city VALUES (?,?)";
		jdbcTemplate.update(query, cityEntity.getNumber(), cityEntity.getName());
		return cityEntity;
	}

	@Override
	public void delete(CityEntity cityEntity) {
		String deleteQuery = "delete from City where name = ?";
		jdbcTemplate.update(deleteQuery, cityEntity.getName());

	}

	@Override
	public CityEntity findByName(CityEntity t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findAll() {
		String sql = "SELECT * from city";
		List<CityEntity> listUser = jdbcTemplate.query(sql, new RowMapper<CityEntity>() {
			@Override
			public CityEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				CityEntity city = new CityEntity();
				city.setNumber(rs.getLong("number"));
				return city;
			}

		});
		return listUser;
	}

	@Override
	public CityEntity findById(final Long id) {
		final String query = "SELECT * FROM EMPLOYEE WHERE ID = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { id }, new RowMapper<CityEntity>() {
			@Override
			public CityEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				CityEntity city = new CityEntity();
				city.setNumber(rs.getLong("number"));
				return city;
			}

		});
	}
	
	public int addCityUsingSimpelJdbcInsert(final CityEntity emp) {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("Number", emp.getNumber());
		parameters.put("Name", emp.getName());

		return simpleJdbcInsert.execute(parameters);
	}

	

	public String getEmployeeUsingMapSqlParameterSource() {
		final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 1);

		return namedParameterJdbcTemplate.queryForObject("SELECT FIRST_NAME FROM EMPLOYEE WHERE ID = :id",
				namedParameters, String.class);
	}

	public int getUsingBeanPropertySqlParameterSource() {
		final CityEntity employee = new CityEntity();
		employee.setName("James");

		final String SELECT_BY_ID = "SELECT COUNT(*) FROM EMPLOYEE WHERE FIRST_NAME = :firstName";

		final SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(employee);

		return namedParameterJdbcTemplate.queryForObject(SELECT_BY_ID, namedParameters, Integer.class);
	}

	public int[] batchUpdateUsingNamedParameterJDBCTemplate(final List<CityEntity> employees) {
		final SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(employees.toArray());
		final int[] updateCounts = namedParameterJdbcTemplate
				.batchUpdate("INSERT INTO City VALUES (:id, :firstName, :lastName, :address)", batch);
		return updateCounts;
	}

	public CityEntity getUsingSimpleJdbcCall(int id) {
		SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
		Map<String, Object> out = simpleJdbcCall.execute(in);

		CityEntity emp = new CityEntity();
		emp.setName((String) out.get("FIRST_NAME"));
		// emp.setNumber((String) out.get("LAST_NAME"));

		return emp;
	}

	@Override
	public List<CityEntity> findAllByPredicates(Collection<Predicate<CityEntity>> predicates) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		String deleteQuery = "delete from City where name = ?";
		jdbcTemplate.update(deleteQuery, id);
		
	}

}
