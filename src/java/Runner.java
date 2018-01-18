import models.entity.Employes;
import models.services.EmployesService;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args){

        Employes employe = new Employes();
        employe.setId(1);
        employe.setName("Василий");
        employe.setSurname("Уткин");
        employe.setPost("Парикмахер");
        employe.setPhone("911");
        employe.setEmail("пупкин@gmail.com");
        employe.setLogin("root");
        employe.setPassword("root");

        EmployesService employesService = new EmployesService();
        try {
            employesService.add(employe);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
