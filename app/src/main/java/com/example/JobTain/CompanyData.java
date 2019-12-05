package com.example.JobTain;

public class CompanyData {
    String company_name,head,email,founder,ceo,nation,contact,foundedyear,username;
    String choice1="",choice2="",choice3="",choice4="",choice5="",choice6="";

    public CompanyData() {
    }

    public CompanyData(String company_name, String head, String email, String founder, String ceo, String nation, String contact, String foundedyear, boolean f1, boolean f2, boolean f3, boolean f4, boolean f5, boolean f6,String username) {
        this.company_name = company_name;
        this.head = head;
        this.email = email;
        this.founder = founder;
        this.ceo = ceo;
        this.nation = nation;
        this.contact = contact;
        this.foundedyear = foundedyear;
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

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFoundedyear() {
        return foundedyear;
    }

    public void setFoundedyear(String foundedyear) {
        this.foundedyear = foundedyear;
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
