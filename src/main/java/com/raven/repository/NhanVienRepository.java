
package com.raven.repository;

import com.raven.domainModel.ChucVu;
import com.raven.domainModel.NhanVien;
import com.raven.utility.HibernateUtility;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class NhanVienRepository {
    
      private Session session = HibernateUtility.getFACTORY().openSession();
      
      
    public List<NhanVien> getAllDangLam() {
        Query query = session.createQuery("FROM NhanVien where trangThai = 1");
        return query.getResultList();
    }
    
     public List<NhanVien> getAllNghiLam() {
        Query query = session.createQuery("FROM NhanVien where trangThai = 0");
        return query.getResultList();
    }

    public List<ChucVu> getChucVu() {
        Query query = session.createQuery("FROM ChucVu");
        return query.getResultList();
    }

    public Boolean add(NhanVien taiKhoan) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(taiKhoan);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.fillInStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE NhanVien SET trangThai = 0 WHERE id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.fillInStackTrace();
            return false;
        }
    }
    
     public NhanVien getByMaAndMatKhau(String ma , String matKhau) {
        try {
            Query query = session.createQuery("Select p From NhanVien p where p.maNhanVien = :ma and p.matKhau = :matKhau" );
            query.setParameter("maNhanVien", ma);
              query.setParameter("matKhau", matKhau);
            return (NhanVien) query.getSingleResult();
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return null;
    }
    
    
    public NhanVien getByMa(String ma) {
        try {
            Query query = session.createQuery("Select p From NhanVien p where p.maNhanVien = :ma");
            query.setParameter("maNhanVien", ma);
            return (NhanVien) query.getSingleResult();
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return null;
    }
      
    
}
