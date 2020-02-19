package com.nt.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nt.contact.Contact;
import com.nt.entity.Contact_Info;
import com.nt.service.ContactService;

import antlr.collections.impl.LList;

@RestController
@Configuration

public class ContactDetailsRestController {

	@Autowired
	private ContactService service;

	@RequestMapping(value="/saveContact.htm" ,method = RequestMethod.POST,produces = "application/json")
	//@request Body is used to bind the request data to the parameter that is specified 

	public ResponseEntity<Contact> saveEmp(@RequestBody Contact cnctDtls){
		HttpHeaders headers= new HttpHeaders();

		if(cnctDtls==null) {
			return  new ResponseEntity<Contact>(HttpStatus.BAD_REQUEST);
		}
		Contact_Info info= new Contact_Info();

		BeanUtils.copyProperties(cnctDtls, info);

		service.saveContact(info);
		headers.add("Contact saved ::",String.valueOf(info.getId()));

		return new ResponseEntity<Contact>(cnctDtls,headers,HttpStatus.CREATED);


	}


	@RequestMapping(value="/showAllContacts.htm", method=RequestMethod.GET,produces = "application/json")
	public ResponseEntity<List<Contact>> handleShowAllRequest(){
		HttpHeaders headers= new HttpHeaders();
		List<Contact_Info> listInfo=	(List<Contact_Info>) service.retrieveAllContacts();
		
		if(listInfo.isEmpty()) {
			return new ResponseEntity<List<Contact>>(HttpStatus.BAD_REQUEST);
		}
		
		List<Contact> listCnct= new ArrayList<Contact>();
		listInfo.forEach(cnct->{
			Contact cnt= new Contact();
			BeanUtils.copyProperties(cnct,cnt);
			listCnct.add(cnt);
		});
		//System.out.println(cnt.getId());
		headers.add("No of records found are ::",String.valueOf(listCnct.size()));
		return new ResponseEntity<List<Contact>>(listCnct,headers,HttpStatus.FOUND);
	}

	
	
	
}
