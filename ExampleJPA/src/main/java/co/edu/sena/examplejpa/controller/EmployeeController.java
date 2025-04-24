/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.Employee;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * date: 25/03/2025
 * @author Esteban Colorado Vargas objetivo: implementar la interface para
 * controlar el modelo employee
 */
public class EmployeeController implements IEmployeeController {

    @Override
    public void insert(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("El empleado es nulo...");
        }
        if (employee.getDocument() == 0) {
            throw new Exception("El documento del empleado no puede ser 0...");
        }
        if ("".equals(employee.getFullname())) {
            throw new Exception("el nombre es obligatorio...");
        }
        if ("".equals(employee.getDireccion())) {
            throw new Exception("la direccion es obligatoria...");
        }
        if ("".equals(employee.getTelefono())) {
            throw new Exception("El telefono es obligatorio...");
        }
        //FK
        if (employee.getTypeId()  ==  null) {
            throw new Exception("El tipo de empleado es obligatorio");
        }
        //FK
        Employee employeeExists = DAOFactory.getEmployeeDAO().findById(employee.getDocument());
        if (employeeExists != null) {
            throw new Exception("ya existe un empleado con ese documento...");
        }
        
        //INSERT
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeDAO().insert(employee);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("El empleado es nulo...");
        }
        if (employee.getDocument() == 0) {
            throw new Exception("El documento del empleado no puede ser 0...");
        }
        if ("".equals(employee.getFullname())) {
            throw new Exception("el nombre es obligatorio...");
        }
//        if ("".equals(employee.getAddress())) {
//            throw new Exception("la direccion es obligatoria...");
//        }
//        if ("".equals(employee.getPhone())) {
//            throw new Exception("El telefono es obligatorio...");
//        }
        //FK
        if (employee.getTypeId()== null) {
            throw new Exception("El tipo de empleado es obligatorio");
        }
        //FK
        Employee employeeExists = DAOFactory.getEmployeeDAO().findById(employee.getDocument());
        if (employeeExists == null) {
            throw new Exception("no existe el empleado...");
        }
        
        //MERGE
        employeeExists.setFullname(employee.getFullname());
        employeeExists.setDireccion(employee.getDireccion());
        employeeExists.setTelefono(employee.getTelefono());
        employeeExists.setTypeId(employee.getTypeId());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeDAO().update(employeeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long document) throws Exception {
        if (document == 0) {
            throw new Exception("El documento es obligatorio...");
        }
        Employee employeeExists = DAOFactory.getEmployeeDAO().findById(document);
        if (employeeExists == null) {
            throw new Exception("no existe el empleado...");
        }
        //ELIMINAR
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeDAO().delete(employeeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Employee> findAll() throws Exception {
        return DAOFactory.getEmployeeDAO().findAll();
    }

    @Override
    public Employee findById(Long document) throws Exception {
        if (document == 0) {
            throw new Exception("el documento es obligatorio...");
        }
        return DAOFactory.getEmployeeDAO().findById(document);
    }
}
