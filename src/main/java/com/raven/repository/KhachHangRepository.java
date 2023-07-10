package com.raven.repository;

import com.raven.domainModel.KhachHang;
import com.raven.domainModel.LoaiKhachHang;
import com.raven.domainModel.NhanVien;
import com.raven.utility.HibernateUtility;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KhachHangRepository {

    private Session session = HibernateUtility.getFACTORY().openSession();
    private String fromTable = "From KhachHang";

    public List<KhachHang> getAll() {
        Query query = session.createQuery(fromTable, KhachHang.class);
        return query.getResultList();
    }

    public List<KhachHang> getAllConHoatDong() {
        Query query = session.createQuery("FROM KhachHang where trangThai = 1");
        return query.getResultList();
    }

//    public static void main(String[] args) {
//        List<KhachHang> kh = new KhachHangRepo().getAll();
//        for(KhachHang khachhang : kh){
//            System.out.println(khachhang.toString());
//        }        
//    }
    public Boolean add(KhachHang khachHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(KhachHang khachHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean delete(String Id) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE KhachHang WHERE Id = :Id");
            query.setParameter("Id", Id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.fillInStackTrace();
            return false;
        }
    }

    public KhachHang getOne(Integer Id) {
        try {
            Query query = session.createQuery("Select p From KhachHang p where p.Id = :Id");
            query.setParameter("Id", Id);
            return (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return null;
    }
    
//     public KhachHang getByHoaDon(String Id) {
//        try {
//            Query query = session.createQuery("Select p From KhachHang p where p.Id = :Id");
//            query.setParameter("Id", Id);
//            return (KhachHang) query.getSingleResult();
//        } catch (Exception e) {
//            e.fillInStackTrace();
//        }
//        return null;
//    }

    public List<KhachHang> tim(String TenKhachHang) { // timf theo ngay

        try (Session session = HibernateUtility.getFACTORY().openSession();) {
            String sql = "from KhachHang where hoTen = :hoTen";
            Query query = session.createQuery(sql);
            query.setParameter("hoTen", TenKhachHang);
            List<KhachHang> listkh = (List<KhachHang>) query.getResultList();

            session.close();
            return listkh;
        }
    }

    public List<KhachHang> timTheoMa(String MaKhachHang) { // timf theo ngay

        try (Session session = HibernateUtility.getFACTORY().openSession();) {
            String sql = "from KhachHang where MaKhachHang = :MaKhachHang";
            Query query = session.createQuery(sql);
            query.setParameter("MaKhachHang", MaKhachHang);
            List<KhachHang> listkh = (List<KhachHang>) query.getResultList();

            session.close();
            return listkh;
        }
    }

    public List<LoaiKhachHang> getLoaiKhachHang() {
        Query query = session.createQuery("FROM LoaiKhachHang");
        return query.getResultList();
    }

}
