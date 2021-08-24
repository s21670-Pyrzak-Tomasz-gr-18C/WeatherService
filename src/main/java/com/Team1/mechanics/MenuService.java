package com.Team1.mechanics;

import com.Team1.hibernate.DataBaseWorks;
import com.Team1.hibernate.model.AveragedWeatherData;
import com.Team1.hibernate.repository.AveregedWeatherDataRepository;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuService {

    public void performActionSelectedByUser(int userChoice) throws IOException {
        switch (userChoice) {
            case 1:
                DataBaseWorks dataBaseWorks = new DataBaseWorks();
                SessionFactory sessionFactory = dataBaseWorks.createSessionFactory();
                dataBaseWorks.createNewLocalisation(sessionFactory);
                break;
            case 2:
                DataBaseWorks dataBaseWorks1 = new DataBaseWorks();
                SessionFactory sessionFactory1 = dataBaseWorks1.createSessionFactory();
                dataBaseWorks1.showAllLocalisations(sessionFactory1);
                break;
            case 3:
                Scanner sc = new Scanner(System.in);
                System.out.println("Podaj nazwę miejscowści");
                String cityName = sc.nextLine();
                sc.close();
                ResultWorks resultWorks = new ResultWorks();
                resultWorks.showAndSaveResultQuery(cityName);
                break;
            case 4:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Podaj datę z której chcesz odczytać dane pogodowe (data w formacie YYYY-MM-DD)");
                String date = scanner.nextLine();
                DataBaseWorks dataBaseWorks2 = new DataBaseWorks();
                SessionFactory sessionFactory2 =dataBaseWorks2.createSessionFactory();

                AveregedWeatherDataRepository averegedWeatherDataRepository = new AveregedWeatherDataRepository(sessionFactory2.createEntityManager());
                List<AveragedWeatherData> listOfParametersForDate = averegedWeatherDataRepository.printAllSavedWeatherDateForLocalisation(LocalDate.parse(date));

                for (AveragedWeatherData data : listOfParametersForDate) {
                    System.out.println(data.toString());
                }
                break;
            default:
                System.out.println("niepoprawny wybór");
                break;

        }
    }
}
