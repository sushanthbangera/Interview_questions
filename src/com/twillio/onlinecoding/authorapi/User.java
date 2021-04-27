package com.twillio.onlinecoding.authorapi;

public class User {

	private Integer id;

	private String username;

	private String about;

	private Integer submitted;

	private String updated_at;

	private Integer submission_count;

	private Integer comment_count;

	private double created_at;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Integer getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Integer submitted) {
		this.submitted = submitted;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public Integer getSubmission_count() {
		return submission_count;
	}

	public void setSubmission_count(Integer submission_count) {
		this.submission_count = submission_count;
	}

	public Integer getComment_count() {
		return comment_count;
	}

	public void setComment_count(Integer comment_count) {
		this.comment_count = comment_count;
	}

	public double getCreated_at() {
		return created_at;
	}

	public void setCreated_at(double created_at) {
		this.created_at = created_at;
	}

}
