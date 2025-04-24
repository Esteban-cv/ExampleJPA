/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Date: 25/03/2025
 *
 * @author Esteban Colorado Vargas objective: implementar la interface para
 * controlar el modelo employeetype
 */
public class EmployeeTypeController implements IEmployeeTypeController {

    @Override
    public void insert(EmployeeType employeeType) throws Exception {
        if (employeeType == null) {
            throw new Exception("el tipo de empleado es nulo...");
        }
        if ("".equals(employeeType.getDescript())) {
            throw new Exception("La descripcion es obligatoria...");
        }
        //INSERTAR
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().insert(employeeType);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(EmployeeType employeeType) throws Exception {
        if (employeeType == null) {
            throw new Exception("el tipo de empleado es nulo...");
        }
        if(employeeType.getId() == 0) {
            throw new Exception("El id es obligatorio...");
        }
        if("".equals(employeeType.getDescript())) {
            throw new Exception("La descripcion es obligatoria...");
        }

        //consultar si el employeetype existe en la base de datos...
        EmployeeType employeeTypeExists = DAOFactory.getEmployeeTypeDAO().findById(employeeType.getId());
        if (employeeTypeExists == null) {
            throw new Exception("El tipo de empleado no existe...");
        }

        //MERGE
        employeeTypeExists.setDescript(employeeType.getDescript());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().update(employeeTypeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        // CONSULTAR SI EL ID EXISTE EN LA BASE DE DATOS...
        EmployeeType employeeTypeExists = DAOFactory.getEmployeeTypeDAO().findById(id);
        if (employeeTypeExists == null) {
            throw new Exception("El tipo de empleado no existe...");
        }

        //ELIMINAR
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().delete(employeeTypeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<EmployeeType> findAll() throws Exception {
        return DAOFactory.getEmployeeTypeDAO().findAll();
    }

    @Override
    public EmployeeType findById(Integer id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        return DAOFactory.getEmployeeTypeDAO().findById(id);
    }
}
