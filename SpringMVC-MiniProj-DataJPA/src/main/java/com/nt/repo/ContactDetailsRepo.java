package com.nt.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nt.entity.Contact_Info;

@Repository("contactRepo")
@Configuration
public interface ContactDetailsRepo extends CrudRepository<Contact_Info,Serializable> {

//	@Query("update contactinfo set contactName=:contactName,email=:email,phoneNo=:phoneNo,activeSwch=:activeSwch where id=:id" )
//	public int update(@Param("contactName")String contactName,@Param("email")String email,@Param("phoneNo")long phoneNo,@Param("activeSwch")String activeSwch,@Param("eid")int eid);


	public List<Contact_Info> findByActiveSwch(String activeSwch);
}

