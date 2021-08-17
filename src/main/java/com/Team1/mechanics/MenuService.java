package com.Team1.mechanics;

public class MenuService {

    public void performActionSelectedByUser(int userChoice){
        switch (userChoice) {
            case 1:
                System.out.println("wybrałeś1");
                break;
            case 2:
                System.out.println("wybrałeś2");
                break;
            case 3:
                System.out.println("wybrałeś3");
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
