/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.test;

import co.edu.sena.examplejpa.controller.EmployeeController;
import co.edu.sena.examplejpa.controller.EmployeeTypeController;
import co.edu.sena.examplejpa.controller.IEmployeeController;
import co.edu.sena.examplejpa.controller.IEmployeeTypeController;
import co.edu.sena.examplejpa.model.Employee;
import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.utils.MessageUtils;
import java.util.List;

/**
 * date: 22/04/2025
 * @author Esteban Colorado Vargas objetivo: Probar consultas/transacciones en
 * tabla Employe
 */
public class TestEmployee {

    Employee employee = new Employee();
    IEmployeeController controller = new EmployeeController();

    public void insert() {
        try {
            employee = new Employee(1116070669L, "Esteban Colorado Vargas", "Calle 28a #33-47", "3185551310");
            //FOREIGN KEY
            IEmployeeTypeController employeeTypeController = new EmployeeTypeController();
            EmployeeType employeeType = employeeTypeController.findById(1);
            employee.setTypeId(employeeType);
            controller.insert(employee);
            MessageUtils.showInfoMessage("El empleado ha sido creado exitosamente...");
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al insertar empleado" + e.getMessage());
        }
    }

    public void update() {
        try {
            employee = new Employee(1000000044L, "Esteban Colorado Vargas", "Calle 28a #33-47", "3185551110");
            //FOREIGN KEY
            IEmployeeTypeController employeeTypeController = new EmployeeTypeController();
            EmployeeType employeeType = employeeTypeController.findById(4);
            employee.setTypeId(employeeType);
            controller.update(employee);
            MessageUtils.showInfoMessage("El empleado ha sido actualizado exitosamente...");
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al actualizar empleado" + e.getMessage());
        }
    }

    public void delete() {
            try {
            controller.delete(1116070669L);
                MessageUtils.showInfoMessage("El empleado ha sido eliominado correctamente...");
        } catch (Exception e) {
                MessageUtils.showErrorMessage("Error al eliminar empleado " +e.getMessage());
        }
    }

    public void findAll() {
        try {
            List<Employee> listEmployeeType = controller.findAll();
            for (Employee e : listEmployeeType) {
                System.out.println("documento: " + e.getDocument()+ " / Nombre: " + e.getFullname() + " / Tipo empleado: " + e.getTypeId().toString());
            }
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al consultar todos los tipos de empleado" + e.getMessage());
        }
    }

    public void findById(Long document) {
         try {
            // CONSULTAR POR ID
            System.out.println("****************************************************");
            Employee employeeType1 = DAOFactory.getEmployeeDAO().findById(document);
            if (employeeType1 != null) {
                System.out.println("Documento: " + employeeType1.getDocument()+ " / Nombre: " + employeeType1.getFullname());
            } else {
                System.out.println("No existe el EmployeeType con ese id...");
            }
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al consultar por id el tipo de empleado" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TestEmployee test = new TestEmployee();
//        test.insert();
//        test.update();
//        test.delete();
//        test.findAll();
//        test.findById(1000000044L);
    }
}
