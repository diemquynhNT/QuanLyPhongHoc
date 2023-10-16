/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class PhongHoc {
    private String idPhongHoc;
    private int soTang;
    private int soGhe;
    private boolean trangThaiHoatDong;
    private boolean trangThaiPhong;
    private int thietBi;

    public PhongHoc() {
    }

    public PhongHoc(String idPhongHoc, int soTang, int soGhe, boolean trangThaiHoatDong, boolean trangThaiPhong, int thietBi) {
        this.idPhongHoc = idPhongHoc;
        this.soTang = soTang;
        this.soGhe = soGhe;
        this.trangThaiHoatDong = trangThaiHoatDong;
        this.trangThaiPhong = trangThaiPhong;
        this.thietBi = thietBi;
    }

    public String getIdPhongHoc() {
        return idPhongHoc;
    }

    public void setIdPhongHoc(String idPhongHoc) {
        this.idPhongHoc = idPhongHoc;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public boolean isTrangThaiHoatDong() {
        return trangThaiHoatDong;
    }

    public void setTrangThaiHoatDong(boolean trangThaiHoatDong) {
        this.trangThaiHoatDong = trangThaiHoatDong;
    }

    public boolean isTrangThaiPhong() {
        return trangThaiPhong;
    }

    public void setTrangThaiPhong(boolean trangThaiPhong) {
        this.trangThaiPhong = trangThaiPhong;
    }

    public int getThietBi() {
        return thietBi;
    }

    public void setThietBi(int thietBi) {
        this.thietBi = thietBi;
    }
    
    
}
