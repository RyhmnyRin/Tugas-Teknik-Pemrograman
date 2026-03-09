import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("============ Employee Management System ===========");

        Department deptIT = new Department("IT");
        EmploymentType typeFullTime = new EmploymentType("Full-Time");  

        Employee emp1 = new Employee(202515,"Salman", deptIT, typeFullTime, 5000000);
        Employee emp2 = new Employee(202516, "Faris", deptIT, typeFullTime, 6000000);

        EmployeeService service = new EmployeeService();

        service.addEmployee(emp1);
        service.addEmployee(emp2);

        System.out.println("Karyawan 1 berhasil ditambah -> ID: " + emp1.getId() + " | Nama: " + emp1.getName() + " | Dept: " + emp1.getDepartment().getName());
        System.out.println("Karyawan 2 berhasil ditambah -> ID: " + emp2.getId() + " | Nama: " + emp2.getName() + " | Dept: " + emp2.getDepartment().getName());
    }
}
