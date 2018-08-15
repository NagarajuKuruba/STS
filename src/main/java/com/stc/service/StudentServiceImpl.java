package com.stc.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.nt.model.StudentHLO;
import com.stc.dao.StudentDAO;
import com.stc.dto.Student;
import com.stc.util.JsonUtil;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Resource
    private StudentDAO studentdao;
	@Override
	public Student getStudInfo(Integer id) {
		System.out.println("service id:"+id);
		StudentHLO stHlo=studentdao.getStudentWithId(id);
		//convert bo to dto
		Student stDto=new Student();
		BeanUtils.copyProperties(stHlo, stDto);
		return stDto;
	}
	@Override
	public List<Student> getAllStuds() {
		List<StudentHLO> listHlo=null;
		List<Student> listDto=null;
		Student st=null;
		listHlo=studentdao.getAllStudents();
		//convert listHlo to listDto
		listDto=new ArrayList<>();
		for(StudentHLO hlo:listHlo){
			st=new Student();
			BeanUtils.copyProperties(hlo, st);
			listDto.add(st);
		}
		return listDto;
	}
	@Override
	public Student modifyStudent(Student st) {
		StudentHLO stHlo=null;
		Student stDto=null;
		//convert sto to hlo
		stHlo=new StudentHLO();
		BeanUtils.copyProperties(st, stHlo);
		//call service method
		StudentHLO hlo= studentdao.updateStudent(stHlo);
		//convert hlo to dto
		stDto=new Student();
		BeanUtils.copyProperties(hlo, stDto);
		
		return stDto;
	}

}
