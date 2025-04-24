/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.persistence;

/**
 * DATE: 08/04/2025
 * @author Esteban Colorado Vargas
 * objetivo: instanciar los DAO'S creados en la persistencia.
 */
public class DAOFactory {
    private static IEmployeeTypeDAO employeeTypeDAO = new EmployeeTypeDAO();
    private static IEmployeeDAO employeeDAO = new EmployeeDAO();
    private static IRecordDAO recordDAO = new RecordDAO();
    private static IKeyRoomDAO keyDAO  = new KeyRoomDAO();

    public static IEmployeeTypeDAO getEmployeeTypeDAO() {
        return employeeTypeDAO;
    }

    public static IEmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public static IRecordDAO getRecordDAO() {
        return recordDAO;
    }

    public static IKeyRoomDAO getKeyDAO() {
        return keyDAO;
    }
}
