package com.raven.repository;

import com.raven.domainModel.DotGiamGia;
import com.raven.utility.HibernateUtility;
import jakarta.persistence.Query;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class DotGiamGiaRepository {

    private Session session = HibernateUtility.getFACTORY().openSession();

    public List<DotGiamGia> getAll() {
        Query query = session.createQuery("FROM DotGiamGia");
        return query.getResultList();
    }

    public Boolean add(DotGiamGia dotGiamGia) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(dotGiamGia);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(DotGiamGia dotGiamGia) {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(dotGiamGia);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean delete(Integer id) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM DotGiamGia WHERE Id = :Id");
            query.setParameter("Id", id);
            query.executeUpdate();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public DotGiamGia findByName(String Ten) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {

            Query query = session.createQuery("From DotGiamGia  where TenDotGiamGia = :TenDotGiamGia");
            query.setParameter("TenDotGiamGia", Ten);
            return (DotGiamGia) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<DotGiamGia> timTen(String Ten) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            String sql = "from DotGiamGia where TenDotGiamGia = :TenDotGiamGia";
            Query query = session.createQuery(sql);
            query.setParameter("TenDotGiamGia", Ten);
            List<DotGiamGia> listTim = (List<DotGiamGia>) query.getResultList();
            session.close();
            return listTim;
        }

    }

    public List<DotGiamGia> timMa(String ma) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            String sql = "from DotGiamGia where MaGiamGia = :MaGiamGia";
            Query query = session.createQuery(sql);
            query.setParameter("MaGiamGia", ma);
            List<DotGiamGia> listTim = (List<DotGiamGia>) query.getResultList();
            session.close();
            return listTim;
        }

    }

    public List<DotGiamGia> timGiam(int ptGiam) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            String sql = "from DotGiamGia where PhanTramGiamGia = :PhanTramGiamGia";
            Query query = session.createQuery(sql);
            query.setParameter("PhanTramGiamGia", ptGiam);
            List<DotGiamGia> listTim = (List<DotGiamGia>) query.getResultList();
            session.close();
            return listTim;
        }

    }

    public void auto1() {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            String sql = "update DotGiamGia set TrangThai = 1 where GETDATE() between NgayBatDau and NgayKetThuc \n";
            transaction = session.beginTransaction();
            org.hibernate.query.Query q = session.createQuery(sql);
            q.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void auto2() {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            String sql = "update DotGiamGia set TrangThai = 0 where GETDATE() > NgayKetThuc \n";
            transaction = session.beginTransaction();
            org.hibernate.query.Query q = session.createQuery(sql);
            q.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void auto3() {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            String sql = "update DotGiamGia set TrangThai = 2 where GETDATE() < NgayBatDau\n";
            transaction = session.beginTransaction();
            org.hibernate.query.Query q = session.createQuery(sql);
            q.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void autoHuy(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            String sql = "update DotGiamGia set TrangThai = 0 where maHoaDon = :id";
            transaction = session.beginTransaction();
            org.hibernate.query.Query q = session.createQuery(sql);
            q.setParameter("id", id);
            q.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
