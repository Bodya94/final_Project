import models.entity.Customer;
import models.entity.Employes;
import models.entity.Register;
import models.entity.Service;
import models.services.CustomerService;
import models.services.EmployesService;
import models.services.RegisterService;
import models.services.ServiceS;

public class Runner {
    public static void main(String[] args){


        Service service = new Service();
        service.setId(7);
        service.setKind("Стрижка");
        service.setCost(300);


        ServiceS serviceS = new ServiceS();

        /*try {
            serviceS.add(service);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/


        Customer customer = new Customer();
        customer.setId(5);
        customer.setName("Alexandr");
        customer.setSurname("Петренко");
        customer.setPhone("099");
        customer.setEmail("петя@gmail.com");
        customer.setLogin("root1");
        customer.setPassword("root1");

        CustomerService customerService = new CustomerService();

      /*  try {
            customerService.add(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/


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

        Register register = new Register();
        RegisterService registerService = new RegisterService();
        register.setDate("25/05/2018");
        register.setCustomerId(2);
        register.setEmployeId(2);
        register.setServiceId(2);
        /*try {
            registerService.add(register);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/



        /*try {
            List<Register> registerList = registerService.getByEmployeID(2);
            for (Register reg: registerList) {
                System.out.println(reg.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        /*
        //delete
        try {
            registerService.remove(register);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/



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
