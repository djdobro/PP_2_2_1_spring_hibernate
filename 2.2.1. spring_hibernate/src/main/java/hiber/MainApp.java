package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("model1", 2312);
      userService.addCar(car1);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      userService.add(user1);

      Car car2 = new Car("model2", 2345);
      userService.addCar(car2);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      userService.add(user2);

      Car car3 = new Car("model3", 3456);
      userService.addCar(car3);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      userService.add(user3);

      Car car4 = new Car("model4", 4567);
      userService.addCar(car4);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);
      userService.add(user4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car`s model = " +user.getCar().getModel());
         System.out.println("Car`s series = " +user.getCar().getSeries());
         System.out.println();
      }


      userService.getUserByCar(car3);

      context.close();
   }
}
