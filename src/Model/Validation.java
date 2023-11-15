/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
       else if(TinhTuoi(user.getNgaySinh())<18)
           err.add("Tuổi chưa đủ 18t !!!");
        else if(TinhTuoi(user.getNgaySinh())>=60)
           err.add("Qúa tuổi lao động !!!");
       
       return err;
    }
    
    public int TinhTuoi(Date ngaySinh)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(ngaySinh);
        LocalDate dob = LocalDate.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH));
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dob, currentDate);
        int age = period.getYears();
        return age;
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
     
   public ArrayList<String> validatePass(String pass,String repass)
    {
       if(pass.isEmpty())
           err.add("Password can not be empty");
       else if(pass.length()<8)
           err.add("Password to short");
       else if (pass.length()>50)
           err.add("Password to long");
       else if(!isStrongPassword(pass))
           err.add("Enter strong pass");
           
       //Repass
       if(repass.isEmpty())
           err.add("Password can not be empty");
       else if(repass.length()<8)
           err.add("RePass to short");
       else if (repass.length()>50)
           err.add("Password to long");
       else if(!repass.equals(pass))
           err.add("Both pass are not matching");
            
       return err;
    }
    public ArrayList<String> validateUserName(String username)
    {
       if(username.isEmpty())
           err.add("UserName không được trống !!!");
       else if(!ConnectDB.TaiKhoanDAO.ValidateTaiKhoan(username))
           err.add("UserName đã được sử dụng!!! ");
       
       
       return err;
    }
}
