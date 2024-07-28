/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.exception;

/**
 *
 * @author usuario
 */
public class UserNotOwnerException extends RuntimeException {
    public UserNotOwnerException() {
        super();
    }
    //"{validation.id_propietario.notvalid}"
}
