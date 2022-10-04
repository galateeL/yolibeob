package com.poei2022.yolibeob.dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFManager {

    private static EntityManagerFactory EMF_SINGLETON = null;

    private EMFManager() {
        // avoid instantiation
    }

    public static EntityManagerFactory getEmf(){

        if (EMF_SINGLETON == null) {
            try {
                EMF_SINGLETON = Persistence.createEntityManagerFactory("PU");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Connexion impossible");
            }
        }
        return EMF_SINGLETON;
    }


    public static void closeEmf() {
        try {
            EMF_SINGLETON.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
