package com.raven.repository;

import com.raven.domainModel.ChatLieu;
import com.raven.domainModel.KichThuoc;
import com.raven.domainModel.LoaiSanPham;
import com.raven.domainModel.MauSac;
import com.raven.domainModel.SanPham;
import com.raven.domainModel.SanPhamChiTiet;
import com.raven.utility.HibernateUtility;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class SanPhamChiTietRepository {

    private Session session = HibernateUtility.getFACTORY().openSession();
    private String fromTable = "From SanPhamChiTiet";

    public List<SanPhamChiTiet> getAll() {
        List<SanPhamChiTiet> list;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            TypedQuery<SanPhamChiTiet> query = session.createQuery("SELECT p FROM SanPhamChiTiet p", SanPhamChiTiet.class);
            list = query.getResultList();
        }
        return list;
    }
    
    
     public List<SanPhamChiTiet> findByName(String ten) {
        List<SanPhamChiTiet> listSP = new ArrayList<>();
        try (Session se = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = se.beginTransaction();
            Query query = se.createQuery("FROM SanPhamChiTiet WHERE MaSanPhamChiTiet like :Ten");
            query.setParameter("Ten", "%" + ten + "%");
            List<SanPhamChiTiet> listSearch = query.getResultList();
            for (SanPhamChiTiet sanPham : listSearch) {
                listSP.add(sanPham);
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<SanPham> getSanPham() {
        org.hibernate.query.Query query = session.createQuery("FROM SanPham");
        return query.getResultList();
    }

    public List<MauSac> getMauSac() {
        org.hibernate.query.Query query = session.createQuery("FROM MauSac");
        return query.getResultList();
    }

    public List<KichThuoc> getKichThuoc() {
        org.hibernate.query.Query query = session.createQuery("FROM KichThuoc");
        return query.getResultList();
    }

    public List<ChatLieu> getChatLieu() {
        org.hibernate.query.Query query = session.createQuery("FROM ChatLieu");
        return query.getResultList();
    }

    public List<LoaiSanPham> getLoaiSanPham() {
        org.hibernate.query.Query query = session.createQuery("FROM LoaiSanPham");
        return query.getResultList();
    }

    public Boolean add(SanPhamChiTiet sanPhamChiTiet) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(sanPhamChiTiet);
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
            org.hibernate.query.Query query = session.createQuery("DELETE SanPhamChiTiet p WHERE p.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.fillInStackTrace();
            return false;
        }
    }

    public SanPhamChiTiet getById(Integer id) {
        try {
            org.hibernate.query.Query query = session.createQuery("FROM SANPHAMCHITIET WHERE Id = :Id");
            query.setParameter("Id", id);
            return (SanPhamChiTiet) query.getSingleResult();
        } catch (Exception e) {
        }
        return null;
    }

    public SanPhamChiTiet getOneByMaCtsp(String ma) {
        String sql = fromTable + " where MaSanPhamChiTiet=:ma";
        Query query = session.createQuery(sql, SanPhamChiTiet.class);
        query.setParameter("ma", ma);
        return (SanPhamChiTiet) query.getSingleResult();
    }

    public List<SanPhamChiTiet> filterProducts(String mauSac,String chatLieu ,  String kichThuoc, String loaiSanPham) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {

            Criteria criteria = session.createCriteria(SanPhamChiTiet.class);

            if (mauSac != null && !mauSac.isEmpty()) {
                criteria.createAlias("mauSac", "mauSac")
                        .add(Restrictions.eq("mauSac.tenMauSac", mauSac));
            }

            if (chatLieu != null && !chatLieu.isEmpty()) {
                criteria.createAlias("chatLieu", "chatLieu")
                        .add(Restrictions.eq("chatLieu.tenChatLieu", chatLieu));
            }
            
              if (kichThuoc != null && !kichThuoc.isEmpty()) {
                criteria.createAlias("kichThuoc", "kichThuoc")
                        .add(Restrictions.eq("kichThuoc.tenKichThuoc", kichThuoc));
            }

            if (loaiSanPham != null && !loaiSanPham.isEmpty()) {
                criteria.createAlias("loaiSanPham", "loaiSanPham")
                        .add(Restrictions.eq("loaiSanPham.tenLoaiSanPham", loaiSanPham));
            }

            List<SanPhamChiTiet> filteredProducts = criteria.list();
            return filteredProducts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
