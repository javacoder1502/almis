package contentMIS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import contentMIS.domain.ContentPrvCount;
import contentMIS.domain.CountAndValue;
import contentMIS.service.ContentCountImp;
import contentMIS.utility.table.PaginationHelper;

@Controller
public class ContentController {

	@Autowired
	ContentCountImp contentCountImp;

	@Autowired
	PaginationHelper paginationHelper;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

	@RequestMapping("/contentUploadDetails/{content_type}")
	public ModelAndView contentUpload(
			@PathVariable(value = "content_type") String content_type) {

		ModelAndView model = new ModelAndView();
		model.setViewName("dateSubmit");
//		model.addObject("onSubmitLink", content_type);
		model.addObject("onSubmitLink", "/ContentMIS/contentUploadDetails/"+content_type);
		return model;
	}

	@RequestMapping("/contentUploadDetails/{content_type}/{date}")
	public ModelAndView contentUpload(
			@PathVariable(value = "content_type") String content_type,
			@PathVariable(value = "date") String date) {
		
		ModelAndView model = new ModelAndView();
		model.addObject("onSubmitLink", content_type);
		
		if (date.equalsIgnoreCase("total")) {
			//model.setViewName("valCountDisplayTotal");
			model.setViewName("tableWith2ColWithHeader");

			List<CountAndValue> ls = contentCountImp
					.getuploadedContentTotal(content_type);
			model.addObject("CountAndValue", ls);
			return model;
		}
		
		model.setViewName("tableWith2Col");
		model.addObject("tbl_column1_display_name", "Category");
		model.addObject("tbl_column2_display_name", "Counts");
		
		List<CountAndValue> ls = contentCountImp
				.getuploadedContentCountDatewise(content_type, date);
		model.addObject("CountAndValue", ls);
		return model;
	}

	// pagination
	@RequestMapping("/contentResponse/{content_type}")
	public ModelAndView contentResponse(
			@PathVariable(value = "content_type") String content_type) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("dateAndLanDrop");
		modelAndView.addObject("onSubmitLink", "/ContentMIS/contentResponse/"
				+ content_type);
		return modelAndView;
	}

	// pagination
	@RequestMapping("/contentResponse/{content_type}/{date}")
	public ModelAndView contentResponse(
			@PathVariable(value = "content_type") String content_type,
			@PathVariable(value = "date") String date,
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "lang_param", required = false) String lang_param) {

		if (pageNumber == null) {
			pageNumber = 1;
		}

		// lang_param is request_param it may be present or not
		// if it not present then set lang_param value ="all" to combine the
		// result of all languages
		if (lang_param == null) {
			lang_param = "all";
		}
		paginationHelper.setTotal_counts(contentCountImp.getTotalCounts(
				content_type, lang_param, date, pageNumber.intValue()));
		
		paginationHelper.setTotal_pages(
				paginationHelper.getDisplay_content_pe_page(),
				paginationHelper.getTotal_counts());
		
		List<ContentPrvCount> contentPrvCount_ls = contentCountImp
				.getResponseContentWise(content_type, lang_param, date,
						pageNumber,
						paginationHelper.getDisplay_content_pe_page());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView
				.addObject("total_pages", paginationHelper.getTotal_pages());
		
		modelAndView.addObject("contentPrvCount", contentPrvCount_ls);
		
		modelAndView.addObject("onClickPageUrl", "/ContentMIS/contentResponse/"
				+ content_type + "/" + date + "?lang_param=" + lang_param);
		
//		modelAndView.setViewName("displayPage");
		modelAndView.addObject("tbl_column1_display_name", "Preview");
		modelAndView.addObject("tbl_column2_display_name", "Name");
		modelAndView.addObject("tbl_column3_display_name", "Counts");
		modelAndView.setViewName("tableWith3Col");
		return modelAndView;

	}

}
