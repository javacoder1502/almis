package contentMIS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contentMIS.domain.ContentPrvCount;
import contentMIS.domain.CountAndValue;

@Service
public class ContentCount extends ContentCountImp{

	@Override
	public List<CountAndValue> getuploadedContentCountDatewise(String catType, String date) {
		List<CountAndValue> countAndValue_ls =  new ArrayList<CountAndValue>();
		 String sql = "select cat,count(*) as temp from  "+contentTable.getTable(catType)+" where  "
					+ "timestamp like '"+date+"%' group by cat";
		 List<Map<String, Object>> ls =  contentDaoImp.selectResult(sql);
		  countAndValue_ls = setCountAndValueDomain(ls);
		  return countAndValue_ls;
	}

	@Override
	public List<CountAndValue> getuploadedContentTotal(String catType) {
		List<CountAndValue> countAndValue_ls =  new ArrayList<CountAndValue>();
		 String sql = "select cat,count(*) as temp from  "+contentTable.getTable(catType)+" group by cat";
					 
		 List<Map<String, Object>> ls =  contentDaoImp.selectResult(sql);
		  countAndValue_ls = setCountAndValueDomain(ls);
		  return countAndValue_ls;
	}

	
	
	//method using for pagination
	@Override
	public List<ContentPrvCount> getResponseContentWise(String content_type, String lang_param, String date, int pageNumber,int display_count) {
	
	
	String sql="";
	int staringLimit = getStaringLimit(pageNumber,display_count);
		
	
	if(lang_param.equalsIgnoreCase("All")){
		sql = "select name,prv,count(*) as temp from  content_response where content_type like '"+content_type+"' and datetime like "
		   		+ "'"+date+"%' group by name   order by datetime desc  limit "+staringLimit+","+display_count;
	}else{
		sql = "select name,prv,count(*) as temp from  content_response where content_type like '"+content_type+"' and datetime like "
		   		+ "'"+date+"%' and  language like '"+lang_param+"' group by name   order by datetime desc  limit "+staringLimit+","+display_count;
	}
	
	System.out.println("sql ---"+sql);
	List<Map<String, Object>> ls =  contentDaoImp.selectResult(sql);
	System.out.println(" after result ");
	
	List<ContentPrvCount> ContentPrvCount_ls =  new ArrayList<ContentPrvCount>();
	
	 for (Map<String, Object> row : ls) {
		 ContentPrvCount contentPrvCount =  new ContentPrvCount();
		 System.out.println(" name "+(String)row.get("name"));
		 System.out.println(" prv "+(String)row.get("prv"));
		 System.out.println(" count "+((Long)row.get("temp")).intValue());
		 contentPrvCount.setName((String)row.get("name"));
		 contentPrvCount.setContent_prv((String)row.get("prv"));
		 contentPrvCount.setCount(((Long)row.get("temp")).intValue());
		 
		 ContentPrvCount_ls.add(contentPrvCount);
	}
	 System.out.println("returning value ");
     return ContentPrvCount_ls;
 }
	
	
	//method using for pagination
	@Override
	public int getTotalCounts(String content_type, String lang_param,
			String date, int pageNumber) {
		
		
		String sql="";
		if(lang_param.equalsIgnoreCase("All")){
			 sql = "select count(distinct name) as temp from   content_response where content_type like '"+content_type+"' and datetime like "
			   		+ "'"+date+"%'";
		}else{
			 sql = "select count(distinct name) as temp from  content_response where content_type like '"+content_type+"' and datetime like "
				   		+ "'"+date+"%' and  language like '"+lang_param+"' ";
		}
	
		System.out.println("sql ---"+sql);
		int total_counts = contentDaoImp.getIntCount(sql);
		
		return total_counts;
	}
	
	
	
	
	//method using for pagination
	public int getStaringLimit(int page_number,int display_counts){

		if(page_number==1){
			return 0;
		}else{
			//if p.no=2 then (2-1) = 1 then 1*10(where 10 is the display_counts)
			//so 10 is the starting limit  in pagenumber 2
			return (page_number-1)*display_counts;
		}
		
	}

	@Override
	public List<CountAndValue> getHitResponseDateWise(String datetime,
			String content_type) {
		List<CountAndValue> waphits=	ResponseDao.getHitResponseDateWise(datetime, content_type);
		
		return waphits;
	}

	@Override
	public List<CountAndValue> getHitResponseHourWise(String datetime,
			String content_type) {
		List<CountAndValue> waphits	= ResponseDao.getHitResponseHourWise(datetime, content_type);
		return waphits;
	}

	


}
