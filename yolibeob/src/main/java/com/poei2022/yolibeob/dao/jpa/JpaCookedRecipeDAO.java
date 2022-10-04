package com.poei2022.yolibeob.dao.jpa;

import com.poei2022.yolibeob.dao.CookedRecipeDAO;
import com.poei2022.yolibeob.dao.entity.CookedRecipe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class JpaCookedRecipeDAO implements CookedRecipeDAO {
    @Override
    public List<CookedRecipe> findAll(){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        List<CookedRecipe> cookedRecipes = null;
        cookedRecipes = em.createQuery("select c from CookedRecipe c")
                .getResultList();
        return cookedRecipes;
    }

    @Override
    public boolean create(CookedRecipe cookedRecipe) {

        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(cookedRecipe);
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
    public Optional<CookedRecipe> findById(long idParam){
        CookedRecipe cookedRecipe = null;
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        try {
            cookedRecipe = em.find(CookedRecipe.class, idParam);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.ofNullable(cookedRecipe);
    }

    @Override
    public boolean delete(long id){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            CookedRecipe cookedRecipe = em.find(CookedRecipe.class, id);
            em.remove(cookedRecipe);
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
    public boolean edit(CookedRecipe cookedRecipeToEdit) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            em.getTransaction().begin();
            Query query =em.createQuery("UPDATE CookedRecipe c SET c.cookDate = :cookDate WHERE c.id = :id");
            query.setParameter("id", cookedRecipeToEdit.getId());
            query.setParameter("cookDate", cookedRecipeToEdit.getCookDate());
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
