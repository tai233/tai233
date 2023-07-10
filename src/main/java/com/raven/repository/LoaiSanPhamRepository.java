package com.raven.repository;

import com.raven.domainModel.LoaiSanPham;
import com.raven.utility.HibernateUtility;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoaiSanPhamRepository {

    private Session session = HibernateUtility.getFACTORY().openSession();

    public List<LoaiSanPham> getAll() {
        List<LoaiSanPham> list;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            TypedQuery<LoaiSanPham> query = session.createQuery("SELECT p FROM LoaiSanPham p", LoaiSanPham.class);
            list = query.getResultList();
        }
        return list;
    }

    public Boolean addNew(LoaiSanPham loaiSanPham) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(loaiSanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean upDate(LoaiSanPham loaiSanPham) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(loaiSanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean delete(Integer id) {
        try (Session se = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = se.beginTransaction();
            Query query = se.createQuery("DELETE LoaiSanPham p WHERE p.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
