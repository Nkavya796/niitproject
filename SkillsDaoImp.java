package com.niit.SkillMappingBackEnd.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.SkillMappingBackEnd.Entity.Skills;
import com.niit.SkillMappingBackEnd.Entity.Users;
import com.niit.SkillMappingBackEnd.Utility.DbConnect;

public class SkillsDaoImp {
	static Connection con = null;

	public SkillsDaoImp() {
		con = DbConnect.connect();
	}
	//inserting user details
		public boolean insertUser(Skills skill) {
			Skills user1 = new Skills();
			try {
				PreparedStatement ps = con.prepareStatement("INSERT INTO Skill VALUES (?,?,?,?,?)");
				ps.setInt(1, skill.getEmpid());
				ps.setInt(2, skill.getId());
				ps.setString(3, skill. getSkillname());
				ps.setString(4, skill.getCertification());
				ps.setInt(5, skill.getExperinceyears());
				
				
				int i = ps.executeUpdate();
				if (i > 0) {
					System.out.println("employee details  inserted successful");

					return true;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return false;
		}
		//updating skills details
		public boolean updateSkills(Skills skill) {
			 //Skills skill=new Skills();
			int rowsUpdated = 0;

			try {
				PreparedStatement ps = con.prepareStatement("UPDATE Skill SET skillname=? WHERE empId=?");
				// user1 = getUserById(uId);
				ps.setString(1,skill.getSkillname());
				ps.setInt(2, skill.getId());
				// ps.setString(4, user1.getEmailId());

				rowsUpdated = ps.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
				return true;

			}
			return false;
		}
		//Retrieving user by Id
		public Skills getSkillById(int uid) {
			Skills skill = new Skills();

			

		
						try {

							PreparedStatement ps = con.prepareStatement("select * from Skill where empId=?");
							ps.setInt(1, uid);
							ResultSet rs = ps.executeQuery();
							if (rs.next()) {
								skill.setEmpid(rs.getInt(1));
								skill.setId(rs.getInt(2));
								skill.setSkillname(rs.getString(3));
								skill.setCertification(rs.getString(4));
								skill.setExperinceyears(rs.getInt(5));
								
							}

						} catch (Exception ex) {
							ex.printStackTrace();
						}
						return skill;
					}
				
				

		//Deleting user by Id
		public boolean deleteUser(int id) {

			int rowsUpdated = 0;
			try {

				PreparedStatement ps = con.prepareStatement("delete from Skill where empId=?");
				ps.setInt(1, id);
				rowsUpdated = ps.executeUpdate();
				if (rowsUpdated > 0) {
					System.out.println("employee details  deleted successfully");

					return true;

				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return false;

		}
		
		
		/*public boolean authorizeUser(int empId, String pwd)
		{
			boolean flag=false;
			Skills u = new Skills();
			PreparedStatement ps;
			try {
				ps = con.prepareStatement
						("select * from Skill where empId=? and password=?");
				ps.setInt(1, empId);
				ps.setString(2, pwd);
				ResultSet rs =ps.executeQuery();
				flag = rs.next();
				
				  ps=con.prepareStatement("SELECT password from user where empId=?");  
				  ps.setInt(2, empId);
					ps.setString(1, pwd);
			       if(empId==u.getEmpid() && pwd.equals(u.getPassword())){  
			            return true;  
			        }
			else {  
			            return false;  
			        }  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



			return flag;*\

		}
		
		/*public static List<Users> getAllUsers(){  
			List<skill> list=new ArrayList<skill>();  

			try{  

				PreparedStatement ps=con.prepareStatement("select * from user");  
				ResultSet rs=ps.executeQuery();  
				while(rs.next()){  
					skill.setEmpid(rs.getInt(1));
					skill.setId(rs.getInt(2));
					skill.setSkillname(rs.getString(3));
					skill.setCertification(rs.getString(4));
					skill.setExperinceyears(rs.getInt(5));
					
					list.add(skill);  
				}  
				con.close();  
			}catch(Exception e){e.printStackTrace();}  

			return list;  
		}  */
		
			
			public static List<Skills>  getUserByskillname(String skillname){  
				List<Skills> list=new ArrayList<>();  
				Skills skill = new Skills();
			try {

				PreparedStatement ps = con.prepareStatement("select * from Skill where skillname=?");
				ps.setString(1, skillname);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					skill.setEmpid(rs.getInt(1));
					skill.setId(rs.getInt(2));
					skill.setSkillname(rs.getString(3));
					skill.setCertification(rs.getString(4));
					skill.setExperinceyears(rs.getInt(5));
					list.add(skill);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return list;
		}
	}



