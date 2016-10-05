package com.logic.controller;

import com.data.DAO.SensoresDAO;
import java.util.ArrayList;
import java.sql.SQLException;

public class SensoresController{

  public ArrayList consultarDatos( String finicial, String ffinal ){
    SensoresDAO sd = new SensoresDAO();
    return sd.consultarDatos( finicial, ffinal );
  }

}
