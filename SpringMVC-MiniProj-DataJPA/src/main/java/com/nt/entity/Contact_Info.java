package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;



@Data
@Entity
@Table(name="ContactInfo")

public class Contact_Info {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name ="Contact_Name")
	private String contactName;
	@Column(name="email")
	private String email;
	@Column(name ="phone_no")
	private long phoneNo;

	@Column(name = "active_swch")
	private String activeSwch;

	
}
