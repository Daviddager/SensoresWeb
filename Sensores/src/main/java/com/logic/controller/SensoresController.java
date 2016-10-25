package com.logic.controller;

import com.data.DAO.SensoresDAO;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;

public class SensoresController{

  public ArrayList<ArrayList> consultarDatos( String finicial, String ffinal ){
    SensoresDAO sd = new SensoresDAO();
    return sd.consultarDatos( finicial, ffinal );
  }

  public ArrayList<ArrayList> consultar( ){
    SensoresDAO sd = new SensoresDAO();
    return sd.consultar( );
  }

  public ResultSet getData( String finicial, String ffinal ){
    SensoresDAO sd = new SensoresDAO();
    return sd.getData( finicial, ffinal );
  }
}
