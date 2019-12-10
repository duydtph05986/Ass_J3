/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSV;

/**
 *
 * @author Admin
 */
public class Student {
   String hoten,masv;
   float tienganh,tinhoc,GDTC,Diemtb;

    public Student() {
    }

   
    public Student(String hoten, String masv, float tienganh, float tinhoc, float GDTC, float Diemtb) {
        this.hoten = hoten;
        this.masv = masv;
        this.tienganh = tienganh;
        this.tinhoc = tinhoc;
        this.GDTC = GDTC;
        this.Diemtb = Diemtb;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public float getTienganh() {
        return tienganh;
    }

    public void setTienganh(float tienganh) {
        this.tienganh = tienganh;
    }

    public float getTinhoc() {
        return tinhoc;
    }

    public void setTinhoc(float tinhoc) {
        this.tinhoc = tinhoc;
    }

    public float getGDTC() {
        return GDTC;
    }

    public void setGDTC(float GDTC) {
        this.GDTC = GDTC;
    }

    public float getDiemtb() {
        return Math.round(((tienganh + tinhoc + GDTC) / 3) * 100)/ 100;
    }

    public void setDiemtb(float Diemtb) {
        this.Diemtb = Diemtb;
    }
   
   
}
