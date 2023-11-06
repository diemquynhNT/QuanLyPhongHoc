/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

public class LichHoc {
    private String idLichHoc;
    private String monHoc;
    private String idUser;
    private Date ngay;
    private float soTiet;
    private String idPhong;
    private boolean trangThai;
    
     public LichHoc(String idLichHoc, String monHoc, String idUser, Date ngay, float soTiet, String idPhong, boolean trangThai) {
        this.idLichHoc = idLichHoc;
        this.monHoc = monHoc;
        this.idUser = idUser;
        this.ngay = ngay;
        this.soTiet = soTiet;
        this.idPhong = idPhong;
        this.trangThai = trangThai;
    }

    public LichHoc() {
    }

    public String getIdLichHoc() {
        return idLichHoc;
    }

    public void setIdLichHoc(String idLichHoc) {
        this.idLichHoc = idLichHoc;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public float getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(float soTiet) {
        this.soTiet = soTiet;
    }

    public String getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(String idPhong) {
        this.idPhong = idPhong;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
     
    
}
