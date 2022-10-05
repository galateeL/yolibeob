package com.poei2022.yolibeob.dao.jpa;

import com.poei2022.yolibeob.dao.UserDAO;
import com.poei2022.yolibeob.dao.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class JpaUserDAO implements UserDAO {

    @Override
    public List<User> findAll(){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        List<User> users = null;
        users = em.createQuery("select u from User u")
                .getResultList();
        return users;
    }

    @Override
    public boolean create(User user) {

        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(user);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public Optional<User> findById(long idParam){
        User user = null;
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        try {
            user = em.find(User.class, idParam);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public boolean delete(long id){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            User user = em.find(User.class, id);
            em.remove(user);
            et.commit();
            return true;
        } catch (RuntimeException e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean edit(User userToEdit) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            em.getTransaction().begin();
            Query query =em.createQuery("UPDATE User u SET u.lastName = :lastName,u.firstName = :firstName,u" +
                    ".avatarUrl= :avatarUrl, u.password= :password WHERE " +
                    "u" +
                    ".id = :id");
            query.setParameter("id", userToEdit.getId());
            query.setParameter("lastName", userToEdit.getLastName());
            query.setParameter("firstName", userToEdit.getFirstName());
            query.setParameter("avatarUrl", userToEdit.getAvatarUrl());
            query.setParameter("password", userToEdit.getPassword());
            query.executeUpdate();
            et.commit();
        }catch(Exception e ){
            if(et.isActive()) {
                et.rollback();
            }
        }finally {
            em.close();
        }
        return false;
    }
}
