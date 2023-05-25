package com.sivapurni.myhealthapp;

public class dirModal {
    String date,time,bpStatus;
    int systolic,diastolic,id;
    public dirModal() {
    }
    public dirModal(String date, String time,String bpStatus, int systolic,
                    int diastolic) {
        this.date = date;
        this.time = time;
        this.bpStatus = bpStatus;
        this.systolic = systolic;
        this.diastolic = diastolic;
    }
    public dirModal(int id,String time,String date, String bpStatus,int
            systolic, int diastolic) {
        this.date = date;
        this.time = time;
        this.bpStatus = bpStatus;
        this.systolic = systolic;
        this.diastolic = diastolic;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String name) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String mail) {
        this.time = time;
    }
    public String getBpStatus() {
        return bpStatus;
    }
    public void setBpStatus(String phoneNo) {
        this.bpStatus = bpStatus;
    }
    public int getSystolic() {
        return systolic;
    }
    public void setSystolic(String dept) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }
    public void setDiastolic(String dept) {
        this.diastolic = diastolic;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


}
