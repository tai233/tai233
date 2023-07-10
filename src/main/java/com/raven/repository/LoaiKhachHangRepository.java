package com.raven.repository;

import com.raven.domainModel.LoaiKhachHang;
import com.raven.utility.HibernateUtility;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoaiKhachHangRepository {

    private Session session = HibernateUtility.getFACTORY().openSession();
    
     public List<LoaiKhachHang> getAll() {
        List<LoaiKhachHang> list;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            TypedQuery<LoaiKhachHang> query = session.createQuery("SELECT p FROM LoaiKhachHang p", LoaiKhachHang.class);
            list = query.getResultList();
        }
        return list;
    }

    public Boolean addNew(LoaiKhachHang loaiKhachHang) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(loaiKhachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean upDate(LoaiKhachHang loaiKhachHang) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(loaiKhachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean delete(Integer id) {
        try (Session se = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = se.beginTransaction();
            Query query = se.createQuery("DELETE LoaiKhachHang p WHERE p.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    
    
   
}
