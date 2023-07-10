
package com.raven.repository;

import com.raven.domainModel.KichThuoc;
import com.raven.utility.HibernateUtility;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class KichThuocRepository {
      private Session session = HibernateUtility.getFACTORY().openSession();
      
       public List<KichThuoc> getAll() {
        List<KichThuoc> list;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            TypedQuery<KichThuoc> query = session.createQuery("SELECT p FROM KichThuoc p", KichThuoc.class);
            list = query.getResultList();
        }
        return list;
    }

    public Boolean addNew(KichThuoc kichThuoc) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(kichThuoc);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean upDate(KichThuoc kichThuoc) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(kichThuoc);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean delete(Integer id) {
        try (Session se = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = se.beginTransaction();
            Query query = se.createQuery("DELETE KichThuoc p WHERE p.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
