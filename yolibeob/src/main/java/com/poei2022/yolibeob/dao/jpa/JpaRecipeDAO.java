package com.poei2022.yolibeob.dao.jpa;

import com.poei2022.yolibeob.dao.RecipeDAO;
import com.poei2022.yolibeob.dao.entity.Recipe;
import com.poei2022.yolibeob.dao.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class JpaRecipeDAO implements RecipeDAO {
    @Override
    public List<Recipe> findAll(){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        List<Recipe> recipes = null;
        recipes = em.createQuery("select r from Recipe r")
                .getResultList();
        return recipes;
    }

    @Override
    public List<Recipe> findAllStarter(){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        List<Recipe> recipes = null;
        recipes = em.createQuery("select r from Recipe r WHERE r.criteria = 'Starter'", Recipe.class)
                .getResultList();

        return recipes;
    }

    @Override
    public List<Recipe> findAllDessert(){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        List<Recipe> recipes = null;
        recipes = em.createQuery("select r from Recipe r WHERE r.criteria = 'Dessert'", Recipe.class)
                .getResultList();

        return recipes;
    }

    @Override
    public List<Recipe> findAllMainCourse(){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        List<Recipe> recipes = null;
        recipes = em.createQuery("select r from Recipe r WHERE r.criteria = 'Main course'", Recipe.class)
                .getResultList();

        return recipes;
    }

    @Override
    public List<Recipe> findAllDrink(){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        List<Recipe> recipes = null;
        recipes = em.createQuery("select r from Recipe r WHERE r.criteria = 'Drink'", Recipe.class)
                .getResultList();

        return recipes;
    }


    @Override
    public boolean create(Recipe recipe) {

        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(recipe);
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
    public Optional<Recipe> findById(long idParam){
        Recipe recipe = null;
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        try {
            recipe = em.find(Recipe.class, idParam);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.ofNullable(recipe);
    }

    @Override
    public boolean delete(long id){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Recipe recipe = em.find(Recipe.class, id);
            em.remove(recipe);
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
    public boolean edit(Recipe recipeToEdit) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            em.getTransaction().begin();
            Query query =em.createQuery("UPDATE Recipe r SET r.title = :title WHERE r.id = :id");
            query.setParameter("id", recipeToEdit.getId());
            query.setParameter("title", recipeToEdit.getTitle());
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
