package kr.co.sist.aak.module.instructor.studentList.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.aak.domain.instructor.StudentListDomain;
import kr.co.sist.aak.module.instructor.studentList.service.StudentListService;

@Controller
@RequestMapping("/instructor")
public class StudentListController {
	
	@Autowired(required = false)
	private StudentListService sls;
	

	@GetMapping("/studentList.do")
	public String searchList(@RequestParam(required = false) String searchType,
	                         @RequestParam(required = false) String searchKeyword,
	                         Model model) {
	    
	    List<StudentListDomain> list;
	    
	    try {
	        if ("aa".equals(searchType) && searchKeyword != null && !searchKeyword.trim().isEmpty()) {
	            list = sls.searchById(searchKeyword); 
	        } else if ("bb".equals(searchType) && searchKeyword != null && !searchKeyword.trim().isEmpty()) {
	            list = sls.searchBySubCode(searchKeyword); 
	        } else if ("cc".equals(searchType) && searchKeyword != null && !searchKeyword.trim().isEmpty()) {
	            list = sls.searchByname(searchKeyword); 
	        } else {
	            list = sls.searchList(); 
	        }
	        
	        model.addAttribute("listStudent", list);
	        model.addAttribute("searchType", searchType);
	        model.addAttribute("searchKeyword", searchKeyword);
	    } catch (PersistenceException e) {
	        model.addAttribute("error", "error" + e.getMessage());
	        list = new ArrayList<>();
	    }
	    

	    return "/instructor/studentList";
	}


}
