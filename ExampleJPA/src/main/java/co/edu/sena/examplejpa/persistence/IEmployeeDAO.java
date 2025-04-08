/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.persistence;

import co.edu.sena.examplejpa.model.Employee;
import java.util.List;

/**
 *date: 08/04/2025
 * @author Esteban Colorado Vargas
 */
public interface IEmployeeDAO {
    public void insert(Employee employee) throws Exception;
    public void update(Employee employee) throws Exception;
    public void delete(Employee employee) throws Exception;
    public Employee findById(long document) throws Exception;
    public List<Employee> findAll() throws Exception;
}
