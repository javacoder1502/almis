package contentMIS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import contentMIS.dao.ContentDaoImp;
import contentMIS.dao.ResponseDao;
import contentMIS.domain.ContentPrvCount;
import contentMIS.domain.CountAndValue;
import contentMIS.utility.table.ContentTable;


public abstract class ContentCountImp {
	
	@Autowired
	ContentTable contentTable;
	
	@Autowired
	ContentDaoImp contentDaoImp;
	
	@Autowired
	ResponseDao ResponseDao;
	
	
	
  public List<CountAndValue> setCountAndValueDomain(List<Map<String, Object>> ls){
		List<CountAndValue> countAndValue_ls =  new ArrayList<CountAndValue>();
		
		 for (Map<String, Object> row : ls) {
			 CountAndValue countAndValue =  new CountAndValue();
			 countAndValue.setValue((String)row.get("cat"));
			 countAndValue.setCount(((Long)row.get("temp")).intValue());
			 
			 countAndValue_ls.add(countAndValue);
		}
	return countAndValue_ls;
		
	}
	
	public abstract List<CountAndValue> getuploadedContentCountDatewise(String catType,String date);
	
	public abstract List<CountAndValue> getuploadedContentTotal(String catType);
	
	
	public abstract List<ContentPrvCount> getResponseContentWise(String content_type, String lang_param, String date,int pageNumber, int display_count);
	
    public abstract int getTotalCounts(String content_type, String lang_param, String date,int pageNumber);
    
    
    
	public abstract List<CountAndValue> getHitResponseDateWise(String datetime);
	public abstract List<CountAndValue> getHitResponseHourWise(String datetime);
    	

}
