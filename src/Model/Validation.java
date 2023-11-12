/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class Validation {
    ArrayList<String> err=new ArrayList<String>();
    
    public ArrayList<String> validateUsers(Users user)
    {
        if(user.getHoTen().isEmpty())
            err.add("Họ tên không được trống !!!");
        else if(!isString(user.getHoTen()))
            err.add("Lỗi kí tự !!");
        
       if(user.getEmail().isEmpty())
           err.add("Mail không được trống !!!");
       else if(!isValidEmail(user.getEmail()))
           err.add("Mail không hợp lệ !!!");
       
       if(user.getSdt().isEmpty())
           err.add("SĐT không được trống !!!");
       else if(user.getSdt().length()!=10)
           err.add("SĐT chưa hợp lệ !!! ");
       else if (!isDigit(user.getSdt()))
           err.add("SSDT không có kí tự");
       if(user.getDiaChi().isEmpty())
           err.add("Địa chỉ không được trống !!!");
       else if(user.getTrinhDo().isEmpty())
           err.add("Trình độ không được trống !!!");
       if(user.getNgaySinh()==null)
           err.add("Ngày sinh không được trống !!!");
       
       return err;
    }
    
    public boolean  isValidEmail(String email)
    {
        String regexPattern = "[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        java.util.regex.Pattern p= java.util.regex.Pattern.compile(regexPattern);
        Matcher m=p.matcher(email);
        return m.matches();
    
    }
     public boolean  isString(String name)
    {
        String regexPattern = "^[\\p{L} '-]+$";
        java.util.regex.Pattern p= java.util.regex.Pattern.compile(regexPattern);
        Matcher m=p.matcher(name);
        return m.matches();
    
    }
     public ArrayList<String> CheckData(Users u)
     {
           if(!ConnectDB.UsersDAO.ValidateData(u.getEmail(), u.getSdt()))
             err.add("Đã có người dùng sử dụng email hoặc sdt này !!!! ");
           return err;
     }
      public ArrayList<String> CheckDataUpdate(Users u)
     {
           if(!ConnectDB.UsersDAO.ValidateDataUpdate(u.getEmail(), u.getSdt(),u.getIdUser()))
             err.add("Đã có người dùng sử dụng email hoặc sdt này !!!!");
           return err;
     }
    
     public boolean  isStrongPassword(String pass)
    {
        String regexPattern = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).*$";
        java.util.regex.Pattern p= java.util.regex.Pattern.compile(regexPattern);
        Matcher m=p.matcher(pass);
        return m.matches();
    
    }
     public boolean  isDigit(String phone)
    {
        boolean digits=phone.chars().allMatch(Character::isDigit);
        return digits;
    
    }
}