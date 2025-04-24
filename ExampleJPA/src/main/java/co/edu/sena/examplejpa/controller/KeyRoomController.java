/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.KeyRoom;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * date: 25/03/2025
 * @author Esteban Colorado Vargas
 * objetivo: implementar la interface para controlar el modelo key
 */
public class KeyRoomController implements IKeyRoomController{

    @Override
    public void insert(KeyRoom keyRoom) throws Exception {
        if("".equals(keyRoom.getName())) {
            throw new Exception("El nombre es obligatorio...");
        }
        if("".equals(keyRoom.getRoom())) {
            throw new Exception("La sala es obligatoria...");
        }
        if(keyRoom.getCount() < 1) {
            throw new Exception("La cantidad no puede ser 0...");
        }
        // INSERTAR
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyDAO().insert(keyRoom);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(KeyRoom keyRoom) throws Exception {
        if(keyRoom == null) {
            throw new Exception("La llave es nula...");
        }
        if(keyRoom.getId() == 0) {
            throw new Exception("El id de la llave no puede ser 0...");
        }
        if("".equals(keyRoom.getName())) {
            throw new Exception("El nombre no puede estar vacio...");
        }
        if("".equals(keyRoom.getRoom())) {
            throw new Exception("La sala no puede estar vacia...");
        }
        if(keyRoom.getCount() < 1) {
            throw new Exception("La cantidad de llaves debe ser mayor a 0...");
        }
        KeyRoom keyExists = DAOFactory.getKeyDAO().findById(keyRoom.getId());
        if (keyExists == null) {
            throw new Exception("no existe la llave...");
        }
        //MERGE
        keyExists.setName(keyRoom.getName());
        keyExists.setRoom(keyRoom.getRoom());
        keyExists.setCount(keyRoom.getCount());
        keyExists.setObservation(keyRoom.getObservation());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyDAO().update(keyExists);
        EntityManagerHelper.commit();
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (id == 0) {
            throw new Exception("El documento es obligatorio...");
        }
        KeyRoom keyExists = DAOFactory.getKeyDAO().findById(id);
        if (keyExists == null) {
            throw new Exception("no existe la llave...");
        }
        //ELIMINAR
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyDAO().delete(keyExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<KeyRoom> findAll() throws Exception {
        return DAOFactory.getKeyDAO().findAll();
    }

    @Override
    public KeyRoom findById(Integer id) throws Exception {
        if(id == 0) {
            throw new Exception("El id es obligatorio");
        }
        return DAOFactory.getKeyDAO().findById(id);
    }
    
}
