/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.simpleloginservletmysql.login.dao;

/**
 *
 * @author Santiago
 */
public class QuerysSql {
    public static final String SELECT_DATO;
        
    static {
        StringBuilder sqlSelect = new StringBuilder();
        sqlSelect.append(" SELECT COUNT(*) FROM ADMLOGIN.LOGIN WHERE USERNAME=? AND PASSWORD=? and ESTATUS=1 ");
        SELECT_DATO = sqlSelect.toString();
    }
}
