package com.stc.dao;

import java.util.List;

import javax.annotation.Resource;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.StudentHLO;
import com.stc.dto.Student;
@Repository
public class StudentDAOImpl implements StudentDAO {
	private static final String GET_ALL_STUDS="from StudentHLO";
	@Resource
    private HibernateTemplate ht;
	@Override
	public StudentHLO getStudentWithId(Integer id) {
		System.out.println("dao id:"+id);
		StudentHLO st= ht.get(StudentHLO.class, id);
	
		return st;
	}
	@Override
	public List<StudentHLO> getAllStudents() {
		
		List<StudentHLO> listHlo=(List<StudentHLO>) ht.find(GET_ALL_STUDS);
		return listHlo;
	}
	@Override
	public StudentHLO updateStudent(StudentHLO hlo) {
	    StudentHLO stHlo= ht.merge(hlo);
		return stHlo;
	}

}
