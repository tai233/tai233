package com.raven.repository;

import com.raven.domainModel.ChucVu;
import com.raven.domainModel.HoaDon;
import com.raven.utility.HibernateUtility;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HoaDonRepository {

    private Session session = HibernateUtility.getFACTORY().openSession();

    private String fromTable = "FROM HoaDon";

    public List<HoaDon> getAll() {
        List<HoaDon> list;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            TypedQuery<HoaDon> query = session.createQuery("SELECT p FROM HoaDon p", HoaDon.class);
            list = query.getResultList();
        }
        return list;
    }
    
 

    public List<HoaDon> getHdWhere(int tt, int id) {
        Query query = session.createQuery(fromTable + "  where trangThai =:tt and idNhanVien = :id order by id desc", HoaDon.class);
        query.setParameter("tt", tt);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public Boolean save(HoaDon hoaDon) {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(HoaDon hoaDon) {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean delete(HoaDon hoaDon) {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public HoaDon getOne(int id) {
        String sql = fromTable + " where id=:id";
        Query query = session.createQuery(sql, HoaDon.class);
        query.setParameter("id", id);
        return (HoaDon) query.getSingleResult();
    }

    public HoaDon getOneByMaHD(String maHoaDon) {
        String sql = fromTable + " where maHoaDon=:maHoaDon";
        Query query = session.createQuery(sql, HoaDon.class);
        query.setParameter("maHoaDon", maHoaDon);
        return (HoaDon) query.getSingleResult();
    }

    public List<HoaDon> getHoaDonByIdNV(int maNv) {
        String sql = fromTable + " where idNhanVien=:idnv order by id desc";
        Query query = session.createQuery(sql, HoaDon.class);
        query.setParameter("idnv", maNv);
        return query.getResultList();
    }
}
