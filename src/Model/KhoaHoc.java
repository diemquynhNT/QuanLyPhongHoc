/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class KhoaHoc {
    private String idKhoaHoc;
    private String nameKhoaHoc;
    private boolean trangThaiKH;

    public KhoaHoc(String idKhoaHoc, String nameKhoaHoc, boolean trangThaiKH) {
        this.idKhoaHoc = idKhoaHoc;
        this.nameKhoaHoc = nameKhoaHoc;
        this.trangThaiKH = trangThaiKH;
    }

    public boolean isTrangThaiKH() {
        return trangThaiKH;
    }

    public void setTrangThaiKH(boolean trangThaiKH) {
        this.trangThaiKH = trangThaiKH;
    }
    

    public KhoaHoc() {
    }

    
    public String getIdKhoaHoc() {
        return idKhoaHoc;
    }

    public void setIdKhoaHoc(String idKhoaHoc) {
        this.idKhoaHoc = idKhoaHoc;
    }

    public String getNameKhoaHoc() {
        return nameKhoaHoc;
    }

    public void setNameKhoaHoc(String nameKhoaHoc) {
        this.nameKhoaHoc = nameKhoaHoc;
    }
    
}
