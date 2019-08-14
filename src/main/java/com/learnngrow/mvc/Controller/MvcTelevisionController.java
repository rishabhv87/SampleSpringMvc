package com.learnngrow.mvc.Controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.learnngrow.mvc.Beans.Television;

@Controller
public class MvcTelevisionController {
	
	public static String getTvUrl = "http://localhost:8082/television/{tid}";
	public static String addTvUrl = "http://localhost:8082/addTelevision";
	
	public static String getAllTv = "http://localhost:8082/televisionListFromDB";
	public static String updateTv = "http://localhost:8082/updateTelevision";
	public static String deleteTv = "http://localhost:8082/deleteTelevision/{tid}";

	@RequestMapping("searchTv")
	public String routeToSearch() {
		return "searchTelevision.jsp";
	}
	
	@RequestMapping("addTv")
	public String routeToAddPage() {
		return "AddTelevision.jsp";
	}
	
	@RequestMapping("updateTv")
	public String routeToUpdatePage() {
		return "UpdateTelevision.jsp";
	}
	
	@RequestMapping("deleteTv")
	public String routeToDeletePage() {
		return "DeleteTelevision.jsp";
	}
	
	@RequestMapping("/getTelevision")
	public ModelAndView getTelevisionDetail(@RequestParam("tid") int tid) {
		RestTemplate rs = new RestTemplate();
		HashMap<String, Integer> var = new HashMap<String, Integer>();
		var.put("tid", tid);
		Television tv = rs.getForObject(getTvUrl, Television.class, var);
         ModelAndView mv = new ModelAndView();
         mv.addObject("tv",tv);
         mv.setViewName("Television.jsp");
		return mv;
	}
	
	@RequestMapping("/addTvToBackend")
	public ModelAndView addTelevisionDetail(Television tv) {
		ModelAndView mv = new ModelAndView();
		RestTemplate rs = new RestTemplate();
		rs.postForObject(addTvUrl, tv, Television.class, tv);
         mv.addObject("tv",tv);
         mv.setViewName("Television.jsp");
		return mv;
	}
	
	@RequestMapping("/updateTvToBackend")
	public ModelAndView updateTelevisionDetail(Television tv) {
		ModelAndView mv = new ModelAndView();
		RestTemplate rs = new RestTemplate();
		rs.postForObject(updateTv, tv, Television.class, tv);
         mv.addObject("tv",tv);
         mv.setViewName("Television.jsp");
		return mv;
	}
	
	@RequestMapping("/deleteTvAtBackend")
	public String deleteTelevisionDetail(@RequestParam("tid") int tid) {
		HashMap<String, Integer> var = new HashMap<String, Integer>();
		var.put("tid", tid);
		ModelAndView mv = new ModelAndView();
		RestTemplate rs = new RestTemplate();
		rs.delete(deleteTv, var);
       
		return "deleted.jsp";
	}
	
}
