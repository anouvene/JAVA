package hb.java.services;

import java.util.List;

import hb.java.exceptions.SchoolNotExistsException;
import hb.java.testHashmap.School;

public interface SchoolService {
	/**
	 * To retrieve School object
	 * @param school
	 * @throws SchoolNotExistsException 
	 */
	public School getSchool(String schoolName) throws SchoolNotExistsException;
	
	/**
	 * To retrieve School objects via schools.xml
	 * @param schoolFileName schools.xml
	 */
	public List<School> getSchoolXml(String schoolFileName);
	
}
