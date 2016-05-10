package contentMIS.utility.table;

import org.springframework.stereotype.Component;


@Component
public class PaginationHelper {

	private int total_counts ;
	private int total_pages;
    private int display_content_pe_page=2;
	


/**
 * @return the total_counts
 */
public int getTotal_counts() {
	return total_counts;
}


/**
 * @param total_counts the total_counts to set
 */
public void setTotal_counts(int total_counts) {
	this.total_counts = total_counts;
}

/**
 * @return the total_pages
 */
public int getTotal_pages() {
	return total_pages;
}

/**
 * @param total_pages the total_pages to set
 */
public void setTotal_pages(int display_result,int total_rows) {
 
	
	System.out.println("display_result :"+display_result+" total_rows "+total_rows);
	
	int total_pages_temp = total_rows/display_result;
	
	System.out.println("total_pages_temp "+total_pages_temp);
	
	
	if(total_rows % display_result !=0){
		System.out.println(" in if ");
		total_pages_temp = total_pages_temp+1;
		
	}
	System.out.println("total_pages_temp "+total_pages_temp);
	//return total_pages;
	
	total_pages = total_pages_temp;
}


/**
 * @return the display_content_pe_page
 */
public int getDisplay_content_pe_page() {
	return display_content_pe_page;
}


/**
 * @param display_content_pe_page the display_content_pe_page to set
 */
public void setDisplay_content_pe_page(int display_content_pe_page) {
	this.display_content_pe_page = display_content_pe_page;
}


}
