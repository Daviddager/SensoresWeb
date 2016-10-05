package com.data.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.data.DAO.DatabaseHelper;
import java.util.ArrayList;

public class SensoresDAO{
  private ArrayList<Integer> temp;
  private ArrayList<Integer> hum;
  private ArrayList<String> dir;
  private ArrayList<Float> vel;
  private ArrayList<Integer> rad;
  private ArrayList<Integer> ray;

  public SensoresDAO(){
    temp = new ArrayList<Integer>();
    hum = new ArrayList<Integer>();
    dir = new ArrayList<String>();
    vel = new ArrayList<Float>();
    rad = new ArrayList<Integer>();
    ray = new ArrayList<Integer>();
  }

  public ArrayList consultarDatos( String finicial, String ffinal ){
    try{
      Connection conn = new DatabaseHelper().getConnection();
      ArrayList<ArrayList> res = new ArrayList<ArrayList>();
      if( conn != null ){
        System.out.println( "Connected" );
        //SELECT * FROM data WHERE datetime BETWEEN '2009-10-20 00:00:00' AND '2009-10-20 23:59:59'
        String query = "SELECT * FROM datos WHERE fecha BETWEEN '" + finicial + " 00:00:00' AND '" + ffinal + " 00:00:00' ORDER BY fecha";
        Statement statement = conn.createStatement( );
        ResultSet result = statement.executeQuery(query);
        while( result.next() ){
          temp.add( Integer.parseInt( result.getString("temperatura") ) );
          hum.add( Integer.parseInt( result.getString("humedad") ) );
          dir.add( result.getString("direccion") );
          vel.add( Float.parseFloat( result.getString("velocidad") ) );
          rad.add( Integer.parseInt( result.getString("radiacion") ) );
          ray.add( Integer.parseInt( result.getString("rayos") ) );
        }

        conn.close();

        res.add( temp );
        res.add( hum );
        res.add( dir );
        res.add( vel );
        res.add( rad );
        res.add( ray );

        return res;
      }
    }catch( SQLException ex ){
      ex.printStackTrace();
    }
    return null;
  }

  public ArrayList consultar( ){
    try{
      Connection conn = new DatabaseHelper().getConnection();
      ArrayList<ArrayList> res = new ArrayList<ArrayList>();
      if( conn != null ){
        System.out.println( "Connected" );
        String query = "SELECT * FROM datos ORDER BY fecha";
        Statement statement = conn.createStatement( );
        ResultSet result = statement.executeQuery(query);
        while( result.next() ){
          temp.add( Integer.parseInt( result.getString("temperatura") ) );
          hum.add( Integer.parseInt( result.getString("humedad") ) );
          dir.add( result.getString("direccion") );
          vel.add( Float.parseFloat( result.getString("velocidad") ) );
          rad.add( Integer.parseInt( result.getString("radiacion") ) );
          ray.add( Integer.parseInt( result.getString("rayos") ) );
        }

        res.add( temp );
        res.add( hum );
        res.add( dir );
        res.add( vel );
        res.add( rad );
        res.add( ray );

        return res;
      }
    }catch( SQLException ex ){
      ex.printStackTrace();
    }
    return null;
  }

}
