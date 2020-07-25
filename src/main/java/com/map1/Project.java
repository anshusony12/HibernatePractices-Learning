package com.map1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int pid;
	@Column(name="project_name")
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private List<Emp> employees;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Emp> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Emp> employees) {
		this.employees = employees;
	}

	public Project(int pid, String projectName, List<Emp> employees) {
		super();
		this.pid = pid;
		this.projectName = projectName;
		this.employees = employees;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
