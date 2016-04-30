package contentMIS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import contentMIS.domain.CountAndValue;
import contentMIS.service.ContentCountImp;

@Controller
public class ContentController {
	
	@Autowired
	ContentCountImp contentCountImp;
	
	@RequestMapping("/index")
	public ModelAndView index(){
		System.out.println("in index ");
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	
	@RequestMapping("/contentUploadDetails/{content_type}")
	public ModelAndView contentUpload(@PathVariable(value="content_type") String content_type){
		ModelAndView model = new ModelAndView();
		model.setViewName("datewise");
		model.addObject("onSubmitLink", content_type);
		return model;
	}
	
	@RequestMapping("/contentUploadDetails/{content_type}/{date}")
	public ModelAndView contentUpload(@PathVariable(value="content_type") String content_type,
			@PathVariable(value="date") String date){
	    ModelAndView model = new ModelAndView();
		
		
		model.addObject("onSubmitLink", content_type);
		
		if(date.equalsIgnoreCase("total")){
			model.setViewName("valCountDisplayTotal");
			
			List<CountAndValue> ls = 	contentCountImp.getuploadedContentTotal(content_type);
			model.addObject("CountAndValue", ls);
			return model;
		}
		model.setViewName("valCountDisplay");
		List<CountAndValue> ls = 	contentCountImp.getuploadedContentCountDatewise(content_type, date);
		model.addObject("CountAndValue", ls);
		return model;
	}

}
