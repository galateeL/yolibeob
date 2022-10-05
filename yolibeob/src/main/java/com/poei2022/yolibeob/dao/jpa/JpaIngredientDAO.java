package com.poei2022.yolibeob.dao.jpa;

import com.poei2022.yolibeob.dao.IngredientDAO;
import com.poei2022.yolibeob.dao.entity.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class JpaIngredientDAO implements IngredientDAO {
    @Override
    public List<Ingredient> findAll(){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        List<Ingredient> ingredients = null;
        ingredients = em.createQuery("select i from Ingredient i", Ingredient.class)
                .getResultList();
        return ingredients;
    }

    @Override
    public boolean create(Ingredient ingredient) {

        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(ingredient);
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
    public Optional<Ingredient> findById(long idParam){
        Ingredient ingredient = null;
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        try {
            ingredient = em.find(Ingredient.class, idParam);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.ofNullable(ingredient);
    }

    @Override
    public boolean delete(long id){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Ingredient ingredient = em.find(Ingredient.class, id);
            em.remove(ingredient);
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
    public boolean edit(Ingredient ingredientToEdit) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            em.getTransaction().begin();
            Query query =em.createQuery("UPDATE Ingredient i SET i.title = :title WHERE i.id = :id");
            query.setParameter("id", ingredientToEdit.getId());
            query.setParameter("title", ingredientToEdit.getTitle());
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

    @Override
    public Optional<Ingredient> findByName(String name){
        Ingredient ingredient = null;
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        try {
            ingredient = em.createQuery("select i from Ingredient i where i.title = :name", Ingredient.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.ofNullable(ingredient);
    }
}
