package spring.core.session06.jdbc.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.core.session06.jdbc.entity.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> queryAll() {
		String sql = "select eid, ename, age, createtime from emp";
		List<Map<String, Object>> emps = jdbcTemplate.queryForList(sql);
		return emps;
	}

	@Override
	public List<Emp> queryEmps() {
		String sql = "select eid, ename, age, createtime from emp";
		List<Emp> emps = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
		return emps;
	}

	@Override
	public Optional<Emp> getOne(Integer eid) {
		String sql = "select eid, ename, age, createtime from emp where eid=?";
		Object[] argsObjects = { eid };
		Emp emp = null;
		try {
			emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class));

		} catch (Exception e) {
			// TODO: handle exception
		}
		Optional<Emp> optEmp = Optional.ofNullable(emp);
		// TODO Auto-generated method stub
		return optEmp;
	}

	@Override
	public Integer count() {
		String sql = "select count(*) from emp";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	public int create(String ename, Integer age) {
		String sql = "Insert into emp(ename, age) values(?, ?)";

		int rowcount = 0;
		try {

			rowcount = jdbcTemplate.update(sql, ename, age);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		// TODO Auto-generated method stub
		return rowcount;
	}

	@Override
	public int[] batchCreate(List<Object[]> list) {
		String sql = "Insert into emp(ename, age) values(?, ?)";
		int[] rowcounts = jdbcTemplate.batchUpdate(sql, list);
		return rowcounts;
	}

	@Override
	public int update(Integer eid, String ename, Integer age) {
		String sql = "Update emp set ename=?, age=? where eid=?";
		int rowcount = jdbcTemplate.update(sql, ename, age, eid);
		return rowcount;
	}

	@Override
	public int delete(Integer eid) {
		String sql = "Delete from emp where eid=?";
		int rowcount = jdbcTemplate.update(sql, eid);
		// TODO Auto-generated method stub
		return rowcount;
	}

	@Override
	public Double getAvgOfAge() {
		String sql = "select AVG(age) from emp";
		Double aveOfAge = jdbcTemplate.queryForObject(sql, Double.class);
		return aveOfAge;
	}

}
