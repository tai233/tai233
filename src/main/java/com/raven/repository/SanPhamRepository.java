package com.raven.repository;

import com.raven.domainModel.SanPham;
import com.raven.utility.HibernateUtility;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SanPhamRepository {

    private Session session = HibernateUtility.getFACTORY().openSession();

    public List<SanPham> getAll() {
        List<SanPham> list;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            TypedQuery<SanPham> query = session.createQuery("SELECT p FROM SanPham p", SanPham.class);
            list = query.getResultList();
        }
        return list;
    }

    public Boolean addNew(SanPham sanPham) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean upDate(SanPham sanPham) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean delete(Integer id) {
        try (Session se = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = se.beginTransaction();
            Query query = se.createQuery("Update SanPham SET trangThai = 0  WHERE id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<SanPham> findByName(String ten) {
        List<SanPham> listSP = new ArrayList<>();
        try (Session se = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = se.beginTransaction();
            Query query = se.createQuery("FROM SanPham WHERE TenSanPham like :Ten");
            query.setParameter("Ten", "%" + ten + "%");
            List<SanPham> listSearch = query.getResultList();
            for (SanPham sanPham : listSearch) {
                listSP.add(sanPham);
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }
    
    public List<SanPham> findByXuatXu(String ten) {
        List<SanPham> listSP = new ArrayList<>();
        try (Session se = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = se.beginTransaction();
            Query query = se.createQuery("FROM SanPham WHERE XuatXu like :Ten");
            query.setParameter("Ten", "%" + ten + "%");
            List<SanPham> listSearch = query.getResultList();
            for (SanPham sanPham : listSearch) {
                listSP.add(sanPham);
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }
    

}
