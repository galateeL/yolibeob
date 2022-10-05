package com.poei2022.yolibeob.dao.jpa;

import com.poei2022.yolibeob.dao.IngredientRecipeDAO;
import com.poei2022.yolibeob.dao.entity.IngredientRecipe;
import com.poei2022.yolibeob.dao.entity.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaIngredientRecipeDAO implements IngredientRecipeDAO {
    @Override
    public List<IngredientRecipe> findAll(){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        List<IngredientRecipe> ingredientRecipeList = null;
        ingredientRecipeList = em.createQuery("select i from IngredientRecipe i", IngredientRecipe.class)
                .getResultList();
        return ingredientRecipeList;
    }

    @Override
    public boolean create(IngredientRecipe ingredientRecipe) {

        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(ingredientRecipe);
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
    public Optional<IngredientRecipe> findById(long idParam){
        IngredientRecipe ingredientRecipe = null;
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        try {
            ingredientRecipe = em.find(IngredientRecipe.class, idParam);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.ofNullable(ingredientRecipe);
    }

    @Override
    public boolean delete(long id){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            IngredientRecipe ingredientRecipe = em.find(IngredientRecipe.class, id);
            em.remove(ingredientRecipe);
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
    public List<IngredientRecipe> findByRecipe(Recipe recipe) {
        List<IngredientRecipe> ingredientRecipes = new ArrayList<>();
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        try {
            ingredientRecipes = em.createQuery("select i from IngredientRecipe i where i.recipe.id = :id", IngredientRecipe.class)
                    .setParameter("id", recipe.getId())
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return ingredientRecipes;
    }

    @Override
    public boolean deleteByRecipe(Recipe recipe){
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            List<IngredientRecipe> ingredientRecipeList = findByRecipe(recipe);
            for (IngredientRecipe ingredientRecipe : ingredientRecipeList) {
                em.remove(em.contains(ingredientRecipe) ? ingredientRecipe : em.merge(ingredientRecipe));
            }
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

}
