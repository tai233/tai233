package com.raven.mainTest;

import com.raven.domainModel.KhachHang;

public class ChonKhachHang {

    public static KhachHang khachHang;

    public ChonKhachHang() {

    }

    public static KhachHang getKhachHang() {
        return khachHang;
    }

    public static void setKhachHang(KhachHang khachHang) {
        ChonKhachHang.khachHang = khachHang;
    }
}
