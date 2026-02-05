package com;

public class Marks {
	String subject;
	String marks;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	
	
	public void display()
	{
		System.out.println(subject+" "+marks);
	}
}
