/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class PhongHoc {
    private String idPhongHoc;
    private int soTang;
    private int soGhe;
    private boolean trangThaiSuDung;
    private String thietBi;

    public PhongHoc(String idPhongHoc, int soTang, int soGhe, boolean trangThaiSuDung, String thietBi) {
        this.idPhongHoc = idPhongHoc;
        this.soTang = soTang;
        this.soGhe = soGhe;
        this.trangThaiSuDung = trangThaiSuDung;
        this.thietBi = thietBi;
    }

    public PhongHoc() {
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

    public boolean isTrangThaiSuDung() {
        return trangThaiSuDung;
    }

    public void setTrangThaiSuDung(boolean trangThaiSuDung) {
        this.trangThaiSuDung = trangThaiSuDung;
    }

    public String getThietBi() {
        return thietBi;
    }

    public void setThietBi(String thietBi) {
        this.thietBi = thietBi;
    }
    
    

   
    
}
