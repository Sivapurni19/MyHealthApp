package com.sivapurni.myhealthapp;

public class dirModal {
    String name,mail,phoneNo,dept;
    int id,ext;
    public dirModal() {
    }
    public dirModal(String name, String dept,String mail, String phoneNo,
                    int ext) {
        this.name = name;
        this.mail = mail;
        this.phoneNo = phoneNo;
        this.dept = dept;
        this.ext = ext;
    }
    public dirModal(int id,String name,String dept, String phoneNo,String
            mail, int ext) {
        this.name = name;
        this.mail = mail;
        this.phoneNo = phoneNo;
        this.dept = dept;
        this.id = id;
        this.ext = ext;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getExt() {
        return ext;
    }
    public void setExt(int ext) {
        this.ext = ext;
    }
}
