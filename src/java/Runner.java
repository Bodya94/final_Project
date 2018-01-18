import models.entity.Employes;
import models.services.EmployesService;

public class Runner {
    public static void main(String[] args){

        Employes employe = new Employes();
        employe.setId(5);
        employe.setName("Геннадий");
        employe.setSurname("Петренко");
        employe.setPost("Маникюрщик");
        employe.setPhone("099");
        employe.setEmail("петя@gmail.com");
        employe.setLogin("root1");
        employe.setPassword("root1");

        EmployesService employesService = new EmployesService();

        /*
        // method add
        try {
            employesService.add(employe);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/


        /*//meyhod getAll
        try {
            for (Employes empl : employesService.getAll()) {
                System.out.println(empl.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/



        /*
        //get by id
        try {
            employe = employesService.getByID(6);
            System.out.println(employe.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        /*
        //update
        try {
            employesService.update(employe);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        /*
        //delete
        try {
            employesService.remove(employe);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

    }
}
