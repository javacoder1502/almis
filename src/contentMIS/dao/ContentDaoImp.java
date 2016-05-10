package contentMIS.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import contentMIS.domain.CountAndValue;

@Repository
public class ContentDaoImp implements ContentDao{

	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<String, Object>> selectResult(String sql) {
		 List<Map<String, Object>> ls 	=jdbcTemplate.queryForList(sql);
		return ls;
	}

	@Override
	public int getIntCount(String sql) {
		return jdbcTemplate.queryForObject(sql, Integer.class);
		
	}

}
