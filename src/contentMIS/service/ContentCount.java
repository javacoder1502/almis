package contentMIS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

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
	


}
