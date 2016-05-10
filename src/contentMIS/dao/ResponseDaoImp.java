package contentMIS.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import contentMIS.domain.CountAndValue;

@Repository
public class ResponseDaoImp implements ResponseDao{
String datetime;
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CountAndValue> getHitResponseDateWise(String datetime_temp,String content_type) {
		
		datetime = datetime_temp;
		String sql ="select dateTime,count(*) as temp from waphit where "
				+ "datetime like '"+datetime+"%' and content_type like '"+content_type+"'";
		System.out.println("sql : "+sql);
		List<CountAndValue> waphits = this.jdbcTemplate.query(
				sql,
		        new RowMapper<CountAndValue>() {
		            public CountAndValue mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	CountAndValue waphit = new CountAndValue();
		            	waphit.setValue(datetime);
		            	waphit.setCount(rs.getInt("temp"));
		                return waphit;
		            }
		        });
		return waphits;
	}

	@Override
	public List<CountAndValue> getHitResponseHourWise(String datetime,String content_type) {
		String sql = "select substr(dateTime,1,13),count(*) as temp from waphit where  "
				+ "datetime like '"+datetime+"%' and content_type like '"+content_type+"' group by substr(dateTime,1,13)";
		
		
		System.out.println("sql : "+sql);
		List<CountAndValue> waphits = this.jdbcTemplate.query(
				sql,
		        new RowMapper<CountAndValue>() {
		            public CountAndValue mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	CountAndValue waphit = new CountAndValue();
		            	waphit.setValue(rs.getString(1));
		            	waphit.setCount(rs.getInt(2));
		                return waphit;
		            }
		        });
		return waphits;
	}

}
