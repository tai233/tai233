package com.raven.repository;

import com.raven.utility.HibernateUtility;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raven.domainModel.ChatLieu;
import jakarta.persistence.TypedQuery;

public class ChatLieuRepository {

    private Session session = HibernateUtility.getFACTORY().openSession();

    public List<ChatLieu> getAll() {
        List<ChatLieu> list;
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            TypedQuery<ChatLieu> query = session.createQuery("SELECT p FROM ChatLieu p", ChatLieu.class);
            list = query.getResultList();
        }
        return list;
    }

    public Boolean addNew(ChatLieu chatLieu) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(chatLieu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean upDate(ChatLieu chatLieu) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(chatLieu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean delete(Integer id) {
        try (Session session = HibernateUtility.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE ChatLieu p WHERE p.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
