package com.poei2022.yolibeob;

import com.poei2022.yolibeob.dao.jpa.EMFManager;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {


        System.out.println("--------------- APP INITIALIZED ---------------");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("--------------- APP DESTROYED ---------------");
        EMFManager.closeEmf();
    }
}
