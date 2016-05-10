package contentMIS.dao;

import java.util.List;
import java.util.Map;

public interface ContentDao {
	
	
	public  List<Map<String, Object>> selectResult(String sql);
	
	//
	public int getIntCount(String sql);
	

}
