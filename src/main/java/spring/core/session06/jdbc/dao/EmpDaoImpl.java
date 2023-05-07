package spring.core.session06.jdbc.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Emp> querEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Emp> getOne(Integer eid) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(String ename, Integer age) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] batchCreate(List<Object[]> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Integer eid, String ename, Integer age) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer eid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
