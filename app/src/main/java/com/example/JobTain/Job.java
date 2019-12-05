package com.example.JobTain;


public class Job {
    String JobTitle,location,experience,Jobsalary,company_name,username;

    public Job(String job_title, String job_loc, String job_exp, String job_sal, String company_name, String user_name) {
        this.JobTitle = job_title;
        this.location = job_loc;
        this.experience = job_exp;
        this.Jobsalary = job_sal;
        this.company_name = company_name;
        this.username = user_name;
    }

    public Job() {
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getJobsalary() {
        return Jobsalary;
    }

    public void setJobsalary(String jobsalary) {
        Jobsalary = jobsalary;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

