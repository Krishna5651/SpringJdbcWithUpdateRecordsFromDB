package com.mahagan.test;

import com.mahagan.dao.ProjectDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application-context.xml");
        ProjectDao projectDao=applicationContext.getBean("projectDao", ProjectDao.class);
        int rowCount=projectDao.updateProjects(1,"Library Management System");
        System.out.println("Updated one row Successfully"+rowCount);
    }
}