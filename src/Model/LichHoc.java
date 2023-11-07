/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

public class LichHoc {
    private String idLichHoc;
    private String idKhoaHoc;
    private String idUser;
    private Date ngay;
    private float ca;
    private String idPhong;
    private boolean trangThai;

    public LichHoc(String idLichHoc, String idKhoaHoc, String idUser, Date ngay, float ca, String idPhong, boolean trangThai) {
        this.idLichHoc = idLichHoc;
        this.idKhoaHoc = idKhoaHoc;
        this.idUser = idUser;
        this.ngay = ngay;
        this.ca = ca;
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

    public String getIdKhoaHoc() {
        return idKhoaHoc;
    }

    public void setIdKhoaHoc(String idKhoaHoc) {
        this.idKhoaHoc = idKhoaHoc;
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

    public float getCa() {
        return ca;
    }

    public void setCa(float ca) {
        this.ca = ca;
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
