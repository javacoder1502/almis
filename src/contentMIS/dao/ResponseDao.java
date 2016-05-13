package contentMIS.dao;

import java.util.List;

import contentMIS.domain.CountAndValue;

public interface ResponseDao {
	
	
	public List<CountAndValue> getHitResponseDateWise(String datetime);
	public List<CountAndValue> getHitResponseHourWise(String datetime);

}
