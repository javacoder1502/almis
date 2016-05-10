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
public class ResponseController {
	
	@Autowired
	ContentCountImp contentCountImp;
	
   @RequestMapping("/Waphits/{content_type}/{conditionWise}")
	public ModelAndView WapHits(
			@PathVariable(value = "content_type") String content_type,
			@PathVariable(value = "conditionWise") String conditionWise){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("dateSubmit");
		modelAndView.addObject("onSubmitLink", "/ContentMIS/Waphits/"+content_type+"/"+conditionWise);
		
        return  modelAndView;
	}
	
	@RequestMapping("/Waphits/{content_type}/{conditionWise}/{date}")
	public ModelAndView WapHits(
			@PathVariable(value = "content_type") String content_type,
			@PathVariable(value = "conditionWise") String conditionWise,
			@PathVariable(value = "date") String date){
		
		System.out.println("content_type : "+content_type);
		System.out.println("conditionWise : "+conditionWise);
		System.out.println("date : "+date);
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<CountAndValue>  waphits=null;
		if(conditionWise.equalsIgnoreCase("hourwise")){
			  waphits =contentCountImp.getHitResponseHourWise(date, content_type);
		}
		if(conditionWise.equalsIgnoreCase("datewise")){
			System.out.println(" in  conditionWise :"+conditionWise);
			 waphits = contentCountImp.getHitResponseDateWise(date, content_type);
		}
		
		modelAndView.addObject("CountAndValue", waphits);
		modelAndView.addObject("tbl_column1_display_name", "Datetime");
		modelAndView.addObject("tbl_column2_display_name", "Counts");
		//modelAndView.setViewName("tableWith2Col.jsp");
		modelAndView.setViewName("tableWith2Col");
		return modelAndView;
	}

}
