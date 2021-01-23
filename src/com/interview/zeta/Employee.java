package com.interview.zeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Employee {

	/*
	 * making it final is not necessary as we are not providing the setters
	 * 
	 * But cross verify if it would cause any other pitfall
	 */
	private final String name;

	private final List<String> projects;

	public Employee(String name, List<String> projects) {
		this.name = name;

		List<String> tempProjects = new ArrayList<>();
		tempProjects.addAll(projects);

		this.projects = tempProjects;
	}

	public String getName() {
		return name;
	}

	public List<String> getProjects() {
		return Collections.unmodifiableList(this.projects);
	}

}
