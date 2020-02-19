package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.contact.Contact;
import com.nt.entity.Contact_Info;
import com.nt.service.ContactService;

@Controller

public class ContactInfoController {

	@Autowired
	ContactService service;
	
	private Logger logger= LoggerFactory.getLogger(ContactInfoController.class);
	
	
	@RequestMapping(value ="/home.htm")
	public String loadHomePage( Map<String,Object> map) {
		logger.debug("Home page Method is executed");
		Contact c= new Contact();
		map.put("cnctDtls",c);
		logger.debug("Home page Method is Ended");
		logger.info("Home page is loaded");
		return "home";
	}
	
	//@RequestMapping(value = "/save.htm",method = RequestMethod.POST)
	@PostMapping("/save.htm")
	public String handleSaveRequest(@ModelAttribute("cnctDtls") Contact cnctDtls,Map<String,Object> map){
		Contact_Info info= new Contact_Info();
		logger.debug("Save page Method is executed");
		BeanUtils.copyProperties(cnctDtls, info);
		String result=service.saveContact(info);
		map.put("resmsg",result);
		logger.debug("Save page Method is Ended");
		logger.info("Save page is loaded");
		return "home";

	}


	@RequestMapping("/showAll.htm")
	public String handleShowAllRequest(Map<String,Object> map) {
		logger.debug("Save page Method is executed");
		List<Contact_Info> listInfo=	(List<Contact_Info>) service.retrieveAllContacts();
		map.put("resmsg",listInfo);
		logger.debug("Save page Method is Ended");
		logger.info("Save page is loaded");
		return "ContactList";
	}


	@RequestMapping("/edit.htm")
	public String handleEditBtn(HttpServletRequest req,Map<String,Object> map,@ModelAttribute("cnctDtls")Contact cnctDtls) {
	
		logger.debug("Edit page Method is executed");
		int id=Integer.parseInt( req.getParameter("id"));
		Contact info=service.retrieveContactById(id);
		map.put("cnctDtls", info);
		logger.debug("Edit page Method is Ended");
		logger.info("Edit page is loaded with values");
		return "home";

	}
	
	@RequestMapping("/delete.htm")
	public String hanldeDeleteRequest(HttpServletRequest req,RedirectAttributes rd) {
		logger.debug("Delete page Method is executed");
		int id=Integer.parseInt(req.getParameter("id"));
		Contact c=service.retrieveContactById(id);
		Contact_Info entity=new Contact_Info();
		BeanUtils.copyProperties(c, entity);
		
		String resmsg=service.deleteContact(entity);
		//rd.addAttribute("delmsg", resmsg);
		rd.addFlashAttribute("delmsg",resmsg);
		logger.debug("Delete page Method is Ended");
		logger.info("Delete page is Redirected to showAll Method");
		return "redirect:/showAll.htm";
		
	}
}