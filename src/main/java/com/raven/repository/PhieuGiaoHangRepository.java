package com.raven.repository;

import com.raven.domainModel.HoaDon;
import com.raven.domainModel.KhachHang;
import com.raven.domainModel.NhanVien;
import com.raven.domainModel.PhieuGiaoHang;
import com.raven.domainModel.SanPham;
import com.raven.utility.HibernateUtility;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class PhieuGiaoHangRepository {

    private Session session = HibernateUtility.getFACTORY().openSession();

    public List<PhieuGiaoHang> getAll() {
        List<PhieuGiaoHang> list;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            TypedQuery<PhieuGiaoHang> query = session.createQuery("SELECT p FROM PhieuGiaoHang p ", PhieuGiaoHang.class);
            list = query.getResultList();
        }
        return list;
    }

    public KhachHang getKhachHangByHoaDonId(int khachHangId) {

        try (Session session = HibernateUtility.getFACTORY().openSession()) {

            String query = "SELECT hd.khachHang FROM HoaDon hd WHERE hd.khachHang.id = :khachHangId";
            TypedQuery<KhachHang> typedQuery = session.createQuery(query, KhachHang.class);
            typedQuery.setParameter("khachHangId", khachHangId);
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public KhachHang getKhachHangByHoaDon(String maHoaDon) {

        try (Session session = HibernateUtility.getFACTORY().openSession()) {

            String query = "SELECT hd.khachHang FROM HoaDon hd WHERE hd.maHoaDon = :maHoaDon";
            TypedQuery<KhachHang> typedQuery = session.createQuery(query, KhachHang.class);
            typedQuery.setParameter("maHoaDon", maHoaDon);
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PhieuGiaoHang> getAllChuaGiao() {

        Query query = session.createQuery("FROM PhieuGiaoHang where trangThai = 0");
        return query.getResultList();

    }

    public List<PhieuGiaoHang> getAllDaLay() {

        Query query = session.createQuery("FROM PhieuGiaoHang where trangThai = 1");
        return query.getResultList();
    }

    public List<PhieuGiaoHang> getAllDangGiao() {

        Query query = session.createQuery("FROM PhieuGiaoHang where trangThai = 2");
        return query.getResultList();
    }

    public List<PhieuGiaoHang> getAllDaGiao() {

        Query query = session.createQuery("FROM PhieuGiaoHang where trangThai = 3");
        return query.getResultList();
    }

    public List<HoaDon> getHoaDon() {
        org.hibernate.query.Query query = session.createQuery("FROM HoaDon");
        return query.getResultList();
    }

    public List<KhachHang> KhachHang() {
        org.hibernate.query.Query query = session.createQuery("FROM KhachHang");
        return query.getResultList();
    }

    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> list;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            TypedQuery<HoaDon> query = session.createQuery("SELECT p FROM HoaDon p", HoaDon.class);
            list = query.getResultList();
        }
        return list;
    }

    public Boolean addNew(PhieuGiaoHang phieuGiaoHang) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(phieuGiaoHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public Boolean upDateDaLay(Integer id) {
//        try (Session session = HibernateUtility.getFACTORY().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            session.saveOrUpdate(phieuGiaoHang);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public Boolean upDateDangGiao(Integer id) {
//        try (Session session = HibernateUtility.getFACTORY().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            Query query = session.createQuery("Update PhieuGiaohang SET trangThai = 2 WHERE id = :id");
//            query.setParameter("id", id);
//            query.executeUpdate();
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public Boolean upDateDaGiao(Integer id) {
//        try (Session session = HibernateUtility.getFACTORY().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            Query query = session.createQuery("Update PhieuGiaohang SET trangThai = 3 WHERE id = :id");
//            query.setParameter("id", id);
//            query.executeUpdate();
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
    public List<SanPham> findByName(String ten) {
        Transaction trans = null;
        List<SanPham> listSP = new ArrayList<>();
        try (Session se = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = se.beginTransaction();
            Query query = se.createQuery("FROM SanPham WHERE TenSanPham like :Ten");
            query.setParameter("Ten", "%" + ten + "%");
            List<SanPham> listSearch = query.getResultList();
            for (SanPham sanPham : listSearch) {
                listSP.add(sanPham);
            }
            trans.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

}
