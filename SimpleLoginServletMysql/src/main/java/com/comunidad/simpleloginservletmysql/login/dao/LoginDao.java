/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.simpleloginservletmysql.login.dao;

import com.comunidad.simpleloginservletmysql.jdbc.CerrarSentencias;
import com.comunidad.simpleloginservletmysql.jdbc.ConexionBD;
import com.comunidad.simpleloginservletmysql.login.dao.vo.LoginVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Santiago
 */
public class LoginDao extends CerrarSentencias {

    public int buscar(LoginVo loginVo) throws Exception {
        Connection conexion = ConexionBD.getInstance().getConection();
        int index = 1;
        PreparedStatement stm = null;
        int retorno = 0;
        try {
            stm = conexion.prepareStatement(QuerysSql.SELECT_DATO);
            stm.setString(index++, loginVo.getUsername());
            stm.setString(index++, loginVo.getPassword());
            boolean isResult = stm.execute();
            do {
                try (ResultSet rs = stm.getResultSet()) {
                    while (rs.next()) {
                        retorno = rs.getInt(1);
                    }
                    isResult = stm.getMoreResults();
                }
            } while (isResult);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            ConexionBD.getInstance().closeConnection(conexion);
        }
        return retorno;
    }
}
