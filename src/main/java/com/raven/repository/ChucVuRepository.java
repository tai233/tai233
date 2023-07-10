package com.raven.repository;

import com.raven.domainModel.ChucVu;
import com.raven.utility.HibernateUtility;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ChucVuRepository {

    private Session session = HibernateUtility.getFACTORY().openSession();

    public List<ChucVu> getAll() {
        List<ChucVu> list;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            TypedQuery<ChucVu> query = session.createQuery("SELECT p FROM ChucVu p", ChucVu.class);
            list = query.getResultList();
        }
        return list;
    }

    public Boolean addNew(ChucVu chucVu) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean upDate(ChucVu chucVu) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean delete(Integer id) {
        try (Session se = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = se.beginTransaction();
            Query query = se.createQuery("DELETE ChucVu p WHERE p.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
