/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class ValidationLichHoc {
     ArrayList<String> err=new ArrayList<String>();
    
    public ArrayList<String> validationLichHoc(LichHoc lh)
    {
        int soLuongGV1Ca=ConnectDB.LichHocDAO.CountGVTrong1Ca(lh.getNgay(), lh.getCa(),lh.getIdUser());
        int soLuongPhong1Ca=ConnectDB.LichHocDAO.CountLopTrong1Ca(lh.getNgay(), lh.getCa(),lh.getIdPhong());
        Boolean lichhoc=ConnectDB.LichHocDAO.ValidateLichHoc(lh);
        if(soLuongGV1Ca>=1)
            err.add("Giáo viên đã có lịch học trong ca này !!!");
        if(soLuongPhong1Ca>=1)
            err.add("Phòng học đã có lịch học trong ca này !!!");
        if(!lichhoc)
            err.add("Trùng lịch học !!!");
        return err;
       
    }
    
     public ArrayList<String> validationUpdateLichHoc(LichHoc lh)
    {
        int soLuongGV1Ca=ConnectDB.LichHocDAO.CountGVTrong1Ca(lh.getNgay(), lh.getCa(),lh.getIdUser());
        int soLuongPhong1Ca=ConnectDB.LichHocDAO.CountLopTrong1Ca(lh.getNgay(), lh.getCa(),lh.getIdPhong());
        Boolean lichhoc=ConnectDB.LichHocDAO.ValidateLichHoc(lh);
        if(soLuongGV1Ca>=2)
            err.add("Giáo viên đã có lịch học trong ca này !!!");
        if(soLuongPhong1Ca>=2)
            err.add("Phòng học đã có lịch học trong ca này !!!");
        if(!lichhoc)
            err.add("Trùng lịch học !!!");
        return err;
       
    }
       
        
       
    
}
