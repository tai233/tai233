
package com.raven.repository;

import com.raven.utility.HibernateUtility;
import com.raven.domainModel.*;

import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class BanHangRepository {
     private Session session = HibernateUtility.getFACTORY().openSession();

    public List<HoaDon> getHoaDonByMa(String ma) {
        Query query = session.createQuery("Select p From HoaDon p where p.nhanVien.maNhanVien = :ma and p.trangThai = 1 ORDER BY p.ma DESC", HoaDon.class);
        query.setParameter("ma", ma);
        return query.getResultList();
    }

    public List<HoaDon> getHoaDonDaThanhToan(String maNV) {
        Query query = session.createQuery("Select p From HoaDon p where p.nhanVien.ma = :maNV and p.trangThai.tenTrangThai = 2 ORDER BY p.ma DESC", HoaDon.class);
        query.setParameter("maNV", maNV);
        return query.getResultList();
    }

    public List<HoaDon> getHoaDonDaHuy(String maNV) {
        Query query = session.createQuery("Select p From HoaDon p where p.nhanVien.ma = :maNV and p.trangThai.tenTrangThai = 0 ORDER BY p.ma DESC", HoaDon.class);
        query.setParameter("maNV", maNV);
        return query.getResultList();
    }

    public List<HoaDonChiTiet> getHDCTByHoaDon(String ma) {
        Query query = session.createQuery("Select p from HoaDonChiTiet p where p.hoaDon.ma = :ma", HoaDonChiTiet.class);
        query.setParameter("ma", ma);
        return query.getResultList();
    }

    public HoaDon getByMaHD(String maHD) {
        try {
            Query query = session.createQuery("FROM HoaDon WHERE Ma = :Ma");
            query.setParameter("Ma", maHD);
            return (HoaDon) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public KhachHang getByMaKH(String maKhachHang) {
        try {
            Query query = session.createQuery("SELECT p FROM KhachHang p WHERE p.maKhachHang = :maKhachHang");
            query.setParameter("maKhachHang", maKhachHang);
            return (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
 

    public Boolean updateSLSP(SanPhamChiTiet chiTietSP, String id) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE ChiTietSP p SET p.soLuongTon = :soLuongTon WHERE p.id = :id");
            query.setParameter("soLuongTon", chiTietSP.getSoLuongTon());
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//    public Boolean huyDon(HoaDon hoaDon, String idHD) {
//        try (Session session = HibernateUtility.getFACTORY().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            Query query = session.createQuery("UPDATE HoaDon p SET p.trangThai.id = :trangThai, p.lyDo = :lyDo, p.ngaySua = :ngaySua WHERE p.id = :idHD");
//            query.setParameter("trangThai", hoaDon.getTrangThai());
//            query.setParameter("lyDo", hoaDon.getLyDo());
//            query.setParameter("ngaySua", hoaDon.getNgaySua());
//            query.setParameter("idHD", idHD);
//            query.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
////    }

//    public Boolean thanhToan(HoaDon hoaDon, String id) {
//        try (Session session = HibernateUtility.getFACTORY().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            Query query = session.createQuery("UPDATE HoaDon p SET p.khuyenMai.id = :idKM, p.trangThai = :trangThai, "
//                    + "p.ngayThanhToan = :ngayThanhToan, p.tongTien = :tongTien, "
//                    + "p.thanhTien = :thanhTien, p.tienTraLai = :tienTraLai, p.tienKM = :tienKM "
//                    + "WHERE p.id = :id");
//            query.setParameter("idKM", hoaDon.getKhuyenMai().getId());
//            query.setParameter("trangThai", hoaDon.getTrangThai());
//            query.setParameter("ngayThanhToan", hoaDon.getNgayThanhToan());
//            query.setParameter("tongTien", hoaDon.getTongTien());
//            query.setParameter("thanhTien", hoaDon.getThanhTien());
//            query.setParameter("tienTraLai", hoaDon.getTienTraLai());
//            query.setParameter("tienKM", hoaDon.getTienKM());
//            query.setParameter("id", id);
//            query.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    public Boolean updateKhach(HoaDon hoaDon, String id) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE HoaDon p SET p.khachHang.id = :idKhachHang WHERE p.id = :id");
            query.setParameter("idKhachHang", hoaDon.getKhachHang().getId());
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean tangSL(HoaDonChiTiet hoaDonChiTiet, String idHDCT) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE HoaDonChiTiet p SET p.soLuong = :soLuong + p.soLuong WHERE p.id = :idHDCT");;
            query.setParameter("soLuong", hoaDonChiTiet.getSoLuong());
            query.setParameter("idHDCT", idHDCT);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean giamSL(HoaDonChiTiet hoaDonChiTiet, String idHDCT) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE HoaDonChiTiet p SET p.soLuong = p.soLuong - :soLuong WHERE p.id = :idHDCT");
            query.setParameter("soLuong", hoaDonChiTiet.getSoLuong());
            query.setParameter("idHDCT", idHDCT);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean upadteTangSP(SanPhamChiTiet chiTietSP, String id) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE SanPhamChiTiet p SET p.soLuongTon = :soLuongTon + p.soLuongTon WHERE p.id = :id");
            query.setParameter("soLuongTon", chiTietSP.getSoLuongTon());
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean upadteGiamSP(SanPhamChiTiet chiTietSP, String id) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE ChiTietSP p SET p.soLuongTon = p.soLuongTon - :soLuongTon  WHERE p.id = :id");
            query.setParameter("soLuongTon", chiTietSP.getSoLuongTon());
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean xoaHDCT(String idHDCT) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM HoaDonChiTiet p WHERE p.id = :idHDCT");
            query.setParameter("idHDCT", idHDCT);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    
}
