/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.test;

import co.edu.sena.examplejpa.controller.EmployeeTypeController;
import co.edu.sena.examplejpa.controller.IEmployeeTypeController;
import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.utils.MessageUtils;
import java.util.List;

/**
 * date: 22/04/2025
 * @author Esteban Colorado Vargas objetivo: probar el controlador der tipo de
 * empleado
 */
public class TestEmployeeType {

    EmployeeType employeeType = new EmployeeType();
    IEmployeeTypeController controller = new EmployeeTypeController();

    public void insert() {
        try {
            employeeType.setDescript("NUEVO  TIPO");
            controller.insert(employeeType);
            MessageUtils.showInfoMessage("Tipo de empleado creado exitosamente...");
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al insertar Tipo de empleado: " + e.getMessage());
        }
    }

    public void update() {
        try {
            employeeType = DAOFactory.getEmployeeTypeDAO().findById(23);
            employeeType.setDescript("INSTRUCTOR CONTRATISTA");
            controller.update(employeeType);
            MessageUtils.showInfoMessage("Tipo de empleado actualizado exitosamente...");
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al actualizar tipo de empleado " + e.getMessage());
        }
    }

    public void delete() {
        try {
            controller.delete(23);
            MessageUtils.showInfoMessage("Tipo de empleado eliminado exitosamente...");
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al eliminar tipo de empleado " + e.getMessage());
        }
    }

    public void findAll() {
        try {
            List<EmployeeType> listEmployeeType = controller.findAll();
            for (EmployeeType e : listEmployeeType) {
                System.out.println("id: " + e.getId() + " / descript: " + e.getDescript());
            }
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al consultar todos los tipos de empleado" + e.getMessage());
        }
    }

    public void findById(Integer id) {
        try {
            // CONSULTAR POR ID
            System.out.println("****************************************************");
            EmployeeType employeeType1 = DAOFactory.getEmployeeTypeDAO().findById(id);
            if (employeeType1 != null) {
                System.out.println("id: " + employeeType1.getId() + " / Descript: " + employeeType1.getDescript());
            } else {
                System.out.println("No existe el EmployeeType con ese id...");
            }
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al consultar por id el tipo de empleado" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TestEmployeeType test = new TestEmployeeType();
        //test.insert()
        //test.update();
        //test.delete();
        test.findAll();
        test.findById(4);
    }
}
