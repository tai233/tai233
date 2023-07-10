package com.raven.repository;

import com.raven.domainModel.MauSac;
import com.raven.utility.HibernateUtility;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MauSacRepository {

    private Session session = HibernateUtility.getFACTORY().openSession();

    public List<MauSac> getAll() {
        List<MauSac> list;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            TypedQuery<MauSac> query = session.createQuery("SELECT p FROM MauSac p", MauSac.class);
            list = query.getResultList();
        }
        return list;
    }

    public Boolean addNew(MauSac mauSac) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean upDate(MauSac mauSac) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean delete(Integer id) {
        try (Session se = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = se.beginTransaction();
            Query query = se.createQuery("DELETE MauSac p WHERE p.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
