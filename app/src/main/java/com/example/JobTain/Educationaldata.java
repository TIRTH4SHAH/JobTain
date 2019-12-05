package com.example.JobTain;

public class Educationaldata {
    String college,cgp,field,projects;
    String firstname,lastname,email,phonenumber,day,month,year;
    String username;

    String choice1,choice2,choice3,choice4,choice5,choice6;

    public Educationaldata() {
    }

    public Educationaldata(String firstname, String lastname, String email, String phonenumber, String college, String cgp, String field, String projects, boolean f1, boolean f2, boolean f3, boolean f4, boolean f5, boolean f6,String username) {
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.phonenumber=phonenumber;
        this.college = college;
        this.cgp = cgp;
        this.field = field;
        this.projects = projects;
        this.username=username;
        if (f1){
            choice1="Artificial Intelligence";
        }
        if (f2){
            choice2="Cloud Computing";
        }
        if (f3){
            choice3="Software Developer";
        }
        if (f4){
            choice4="Backend Developer";
        }
        if (f5){
            choice5="Frontend Developer";
        }
        if (f6){
            choice6="Backend Developer";
        }
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCgp() {
        return cgp;
    }

    public void setCgp(String cgp) {
        this.cgp = cgp;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getChoice5() {
        return choice5;
    }

    public void setChoice5(String choice5) {
        this.choice5 = choice5;
    }

    public String getChoice6() {
        return choice6;
    }

    public void setChoice6(String choice6) {
        this.choice6 = choice6;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
