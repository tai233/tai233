
package com.raven.repository;

import com.raven.domainModel.HoaDonChiTiet;
import com.raven.utility.HibernateUtility;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HoaDonChiTietRepository {
     private Session session = HibernateUtility.getFACTORY().openSession();

    private String fromTable = "FROM HoaDonChiTiet";

    public List<HoaDonChiTiet> getAll() {
        Query query = session.createQuery(fromTable, HoaDonChiTiet.class);
        return (ArrayList<HoaDonChiTiet>) query.getResultList();
    }

    public Boolean save(HoaDonChiTiet hoaDonChiTiet) {
        Transaction transaction = null;
        try ( Session session = HibernateUtility.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hoaDonChiTiet);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(HoaDonChiTiet hoaDonChiTiet) {
        Transaction transaction = null;
        try ( Session session = HibernateUtility.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(hoaDonChiTiet);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean delete(HoaDonChiTiet hoaDonChiTiet) {
        Transaction transaction = null;
        try ( Session session = HibernateUtility.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hoaDonChiTiet);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

//    public Boolean deleteByIdHd(int idhd) {
//        Transaction transaction = null;
//        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
//            Query query = session.createQuery(fromTable+"where idhoadon = :idhoadon");
//            query.setParameter("idhoadon", idhd);
//            transaction = session.beginTransaction();
//            session.delete(HoaDonChiTiet.class);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }
    public HoaDonChiTiet getOne(int id) {
        String sql = fromTable + "where id=:id";
        Query query = session.createQuery(sql, HoaDonChiTiet.class);
        query.setParameter("id", id);
        return (HoaDonChiTiet) query.getSingleResult();
    }

    public List<HoaDonChiTiet> getHdctByIdHd(int id) {
       try (Session session = HibernateUtility.getFACTORY().openSession();) {
            String sql = "from HoaDonChiTiet where HoaDonID = :id";
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            List<HoaDonChiTiet> listkh = (List<HoaDonChiTiet>) query.getResultList();

            session.close();
            return listkh;
        }
    }

    public HoaDonChiTiet getHdctByIdCtsp(int idCtsp) {
        String sql = fromTable + " where ChiTietSanPhamID =:idctsp";
        Query query = session.createQuery(sql, HoaDonChiTiet.class);
        query.setParameter("idctsp", idCtsp);
        return (HoaDonChiTiet) query.getSingleResult();
    }

    public HoaDonChiTiet getHdctByIdCtspAndIdHd(int idCtsp, int idHd) {
        String sql = fromTable + " where ChiTietSanPhamID =:idctsp and HoaDonID =:idhd";
        Query query = session.createQuery(sql, HoaDonChiTiet.class);
        query.setParameter("idctsp", idCtsp);
        query.setParameter("idhd", idHd);

        return (HoaDonChiTiet) query.getSingleResult();
    }
}
