/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.simpleloginservletmysql.login.service;

import com.comunidad.simpleloginservletmysql.login.dao.LoginDao;
import com.comunidad.simpleloginservletmysql.login.dao.vo.LoginVo;

/**
 *
 * @author Santiago
 */
public class LoginService {
    private LoginDao loginDao = new LoginDao();

    public int buscar(LoginVo loginVo) throws Exception {
        return loginDao.buscar(loginVo);
    }
}
