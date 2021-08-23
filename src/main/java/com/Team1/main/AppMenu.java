package com.Team1.main;

import com.Team1.mechanics.MenuService;

import java.io.IOException;
import java.util.Scanner;

public class AppMenu {

    private int choice = 0;

    private String menu = "Wybierz jedną z opcji: \n" +
            "1.Dodaj lokalizacje do bazy danych\n" +
            "2.Wyświetl wszyskie lokalizacje dostępne w bazie\n" +
            "3.Wyświetl bierzące dane dla wybranej lokalizacji\n" +
            "4.Wyświetl historyczne dane dla wybranej lokalizacji\n";

    public void start() throws IOException {
        showMenu();
        getUserChoice();
        MenuService menuService = new MenuService();
        menuService.performActionSelectedByUser(choice);
    }

    public void showMenu(){
        System.out.println(menu);
    }

    public void getUserChoice(){
        Scanner scanner = new Scanner(System.in);
        this.choice = scanner.nextInt();
    }

}
