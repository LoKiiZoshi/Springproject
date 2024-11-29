package com.brodyway.Springproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.brodyway.Springproject.Model.Department;
import com.brodyway.Springproject.Service.DepartmentService;
import com.brodyway.Springproject.utils.DepartmentExcelView;
import com.brodyway.Springproject.utils.DepartmentPdfView;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;

	@GetMapping("/department")
	public String getdepartment() {
		return "Department";
	}

	@PostMapping("/department")
	public String postdepartment(@ModelAttribute Department dept) {
		deptService.addDept(dept);
		return "Department";
	}

	@GetMapping("/departmentList")
	public String getDeptList(Model model) {
		model.addAttribute("dList", deptService.getAllDepts());
		return "DepertamentlistForm";
	}

	@GetMapping("/dept/delete")
	public String delete(@RequestParam int id) {
		deptService.deleteDept(id);

		return "redirect:/departmentList";

	}

	@GetMapping("/dept/edit")
	public String edit(@RequestParam int id, Model model) {
		model.addAttribute("dmodel", deptService.getDeptById(id));
		return "DepartmentEditForm";

	}

	@PostMapping("/dept/update")
	public String update(@ModelAttribute Department dept) {
		deptService.updateDept(dept);
		return "redirect:/departmentList";
	}
	
	
	@GetMapping("/dept/view")
	public String viewdept(@RequestParam int id,Model model) {
		model.addAttribute("dmodel",deptService.getDeptById(id));
		return "DepartmentViewForm";
		
	}
	
	@PostMapping("/dept/Back")
	public String backdept(@ModelAttribute Department dept) {
		deptService.addDept(dept);
		return"redirect:/departmentList";
	}
	
	@GetMapping("/dept/excel")
	public ModelAndView excel() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("dList",deptService.getAllDepts());
		mv.setView(new DepartmentExcelView());
		return mv;
	}
	@GetMapping("/dept/pdf")
	public ModelAndView pdf() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("dList",deptService.getAllDepts());
		mv.setView(new DepartmentPdfView());
		return mv;
		
		
		
	}
}
