package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //identifies this class as a JPA entity (Java Persistence API)
public class Student {
	
	
	@Id	//marks a field in a model class as the primary key (in this case SID)
	private int sid;						//instance variables for Student class (student ID,
	private int gid;						//grade level, first and last names.
	private String fname;
	private String lname;
	
	
	public int getSid() {					//get method for student ID
		return sid;
	}
	public void setSid(int sid) {			//set method for student ID
		this.sid = sid;
	}
	public int getGid() {					//get method for grade level
		return gid;
	}
	public void setGid(int gid) {			//set method for grade level
		this.gid = gid;
	}
	public String getFname() {				//get method for student first name 
		return fname;
	}
	public void setFname(String fname) {	//set method for student first name
		this.fname = fname;
	}
	public String getLname() {				//get method for student last name 
		return lname;
	}
	public void setLname(String lname) {	//set method for student last name 
		this.lname = lname;
	}
	
	@Override  //overloads an instance method to add new behavior 
	public String toString() {				//Return string representation of object created after instantiation
		
		return "Student [sid=" + sid + ", gid=" + gid + ", fname=" + fname + ", lname=" + lname + "]";
	}
	
} //end Student Class

