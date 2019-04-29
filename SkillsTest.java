package com.niit.SkillMappingBackEnd.TestCase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.SkillMappingBackEnd.Entity.Skills;
import com.niit.SkillMappingBackEnd.Entity.Users;
import com.niit.SkillMappingBackEnd.Repository.SkillsDaoImp;

public class SkillsTest {
	private static SkillsDaoImp skillDao = new SkillsDaoImp();
	private Skills skill = new Skills();
	
	@BeforeClass
	public static void init() {
		skillDao = new SkillsDaoImp();
	}
@Ignore

	@Test
	public void testInsertUser() {
		boolean flag;
		skill = new Skills();
	    skill.setEmpid(125);
		skill.setId(67);
		skill.setSkillname("python");
		skill.setCertification("certifiaction8");
		skill.setExperinceyears(5);
		
		
		
		flag = skillDao.insertUser(skill);
		assertEquals("Failed to insert userdetails!", true, flag);
		
		
	}

	
@Ignore
	@Test
	public void testgetSkillById() {
	skill = skillDao.getSkillById(125);
		assertEquals("Failed to get User !", "python", skill.getSkillname());
	}

 @Ignore

 @Test
	public void testUpdateUser() {

	skill  = skillDao.getSkillById(890);
		skill.setSkillname("c++");
		boolean flag = skillDao.updateSkills(skill);
		assertEquals("Failed to update skilldetails!", true, flag);
	}

	@Ignore
	@Test
	public void testDeleteUser() {

		boolean flag = skillDao.deleteUser(890);
		assertEquals("Failed to delete skilldetails!", true, flag);
	}
//	@Ignore
	@Test
	public void  getUserByskillname() {
	List<Skills> list=skillDao. getUserByskillname("python");
	assertEquals("no user present with that skill!",1,list.size());

	}
}	