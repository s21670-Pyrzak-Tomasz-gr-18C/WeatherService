package com.Team1.mechanics;

import com.Team1.hibernate.DataBaseWorks;

public class MenuService {

    public void performActionSelectedByUser(int userChoice){
        switch (userChoice) {
            case 1:
                break;
            case 2:
                System.out.println("wybrałeś2");
                break;
            case 3:
                DataBaseWorks dataBaseWorks =  new DataBaseWorks();
                dataBaseWorks.createSessionFactory();
                break;
            case 4:
                System.out.println("wybrałeś4");
                break;
            default:
                System.out.println("niepoprawny wybór");
                break;
        }

    }
}
