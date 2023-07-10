
package com.raven.mainTest;

import com.raven.domainModel.NhanVien;


public class UserLogin {
      public static NhanVien nv;
    public  UserLogin(){
        
    }
    public static NhanVien getNhanVien(){
        return nv;
    }
    public static void setNhanVien(NhanVien nv){
        UserLogin.nv=nv;
    }
}
