package com.sivapurni.myhealthapp;

public class dirModal {
    String Date,Time,BPStatus;
    int Systolic,Diastolic,id;
    public dirModal() {
    }
    public dirModal(String date, String time,String bpStatus, int systolic,
                    int diastolic) {
        this.Date = date;
        this.Time = time;
        this.BPStatus = bpStatus;
        this.Systolic = systolic;
        this.Diastolic = diastolic;
    }
    public dirModal(int id,String time,String date, String bpStatus,int
            systolic, int diastolic) {
        this.id = id;
        this.Date = date;
        this.Time = time;
        this.BPStatus = bpStatus;
        this.Systolic = systolic;
        this.Diastolic = diastolic;
    }
    public String getDate() {
        return Date;
    }
    public void setDate(String name) {
        this.Date = Date;
    }
    public String getTime() {
        return Time;
    }
    public void setTime(String mail) {
        this.Time = Time;
    }
    public String getBpStatus() {
        return BPStatus;
    }
    public void setBpStatus(String phoneNo) {
        this.BPStatus = BPStatus;
    }
    public int getSystolic() {
        return Systolic;
    }
    public void setSystolic(String dept) {
        this.Systolic = Systolic;
    }

    public int getDiastolic() {
        return Diastolic;
    }
    public void setDiastolic(String dept) {
        this.Diastolic = Diastolic;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


}
