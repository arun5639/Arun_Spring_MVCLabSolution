package com.Learning.Event.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.Learning.Event.DAO.DAOStudService;
import com.Learning.Event.Entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private DAOStudService daoStudService;
	
	@RequestMapping("/list")
	public String getWelcome(ModelMap modelMap) {
		List<Student> stud = daoStudService.getAllStudent();
		modelMap.addAttribute("allStudent", stud);
		return "list";
	}
	
	@RequestMapping("/addForm")
	public String addForm(ModelMap modelMap, @ModelAttribute ("student") Student stud, @ModelAttribute ("String") String rError) {
		
		modelMap.addAttribute("student", stud);
		if (rError!=null)
			modelMap.addAttribute("Err", rError);
		return "addForm";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute ("student") Student thestud, ModelMap modelMap, RedirectAttributes ra) {
		String err = "Record already exists";
		String errL = "Fields cannot be blank";
		
		if(thestud.getStudName().isEmpty() || thestud.getStudDept().isEmpty() || thestud.getStudCountry().isEmpty()) {
			ra.addFlashAttribute("student", thestud);
			ra.addFlashAttribute("String", errL);
			return "redirect:addForm"; 
		}			
		
		if (daoStudService.addStudent(thestud)==true) {
			return "redirect:list"; 
		}
		else {
			System.out.println("STUD"+thestud.toString());
			ra.addFlashAttribute("student", thestud);
			ra.addFlashAttribute("String", err);
			return "redirect:addForm"; 
		}				
	}		
		
	@RequestMapping("/update")
	public String update(@ModelAttribute ("student") Student thestudent, ModelMap modelMap) {
		daoStudService.updateStudent(thestudent); 
		return "redirect:list"; 
	}	 	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studId") int studId, ModelMap modelMap) {
		daoStudService.deleteStudent(studId);	
		return "redirect:list"; 
	}
	
	@RequestMapping("/showFormUpdate")
	public String update(@RequestParam("studId") int studId, ModelMap modelMap) {
		Student stud = daoStudService.getStudent(studId);
		modelMap.addAttribute("student", stud);
		return "update";
	}	
}
