package com.stc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stc.dto.Student;
import com.stc.service.StudentService;

@RestController
public class BaseSTCController {
	@Resource
	private StudentService service;
	
	
    @RequestMapping(value="/user",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<Student> getUser(@QueryParam("id") Integer id){
        Student stDto=null;
		System.out.println("Fecthing user with id: "+id);
		if(id!=0){
			stDto=service.getStudInfo(id);
		}
		
		if(stDto==null){
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(stDto,HttpStatus.OK);
	}
	@RequestMapping(value="/users",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Student>> getAllStudents(){
    	List<Student> listStDto=null;
    	listStDto=service.getAllStuds();
    	if(listStDto==null){
    		return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
    	}else{
    		return new ResponseEntity<List<Student>>(listStDto,HttpStatus.OK);
    	}
    }
	@RequestMapping(value="/userUpdate",method=RequestMethod.GET)
	public ResponseEntity<Student> updateStudent(@QueryParam("id") Integer id){
		Student st=null;
		Student resSt=null;
		st=service.getStudInfo(id);
		if(st==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			st.setAddr("sec");
			//call service
			resSt=service.modifyStudent(st);
			return new ResponseEntity<>(resSt,HttpStatus.OK);	
		}
		
		
		
	}
	
}
