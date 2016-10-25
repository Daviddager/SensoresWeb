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
  /*
  private ArrayList<Integer> lat;
  private ArrayList<Float> gLat;
  private ArrayList<String> oLat;
  private ArrayList<Integer> lon;
  private ArrayList<Float> gLon;
  private ArrayList<String> oLon;
  private ArrayList<Float> alt;
  private ArrayList<Float> asim;
  */
  public SensoresDAO(){
    temp = new ArrayList<Integer>();
    hum = new ArrayList<Integer>();
    dir = new ArrayList<String>();
    vel = new ArrayList<Float>();
    rad = new ArrayList<Integer>();
    ray = new ArrayList<Integer>();
    /*
    lat = new ArrayList<Integer>();
    gLat = new ArrayList<Float>();
    oLat = new ArrayList<String>();
    lon = new ArrayList<Integer>();
    gLon = new ArrayList<Float>();
    oLon = new ArrayList<String>();
    alt = new ArrayList<Float>();
    asim = new ArrayList<Float>();
    */
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
          /*
          lat.add( Integer.parseInt( result.getString("latitud") ) );
          gLat.add( Integer.parseInt( result.getString("grados_lat") ) );
          oLat.add( Integer.parseInt( result.getString("orientacion_lat") ) );
          lon.add( Integer.parseInt( result.getString("longitud") ) );
          gLon.add( Integer.parseInt( result.getString("gradLon") ) );
          oLon.add( Integer.parseInt( result.getString("orientacion_lon") ) );
          alt.add( Integer.parseInt( result.getString("altitud") ) );
          asim.add( Integer.parseInt( result.getString("asimuth") ) );
          */
        }

        conn.close();

        res.add( temp );
        res.add( hum );
        res.add( dir );
        res.add( vel );
        res.add( rad );
        res.add( ray );
        /*
        res.add( lat );
        res.add( gLat );
        res.add( oLat );
        res.add( lon );
        res.add( gLon );
        res.add( oLon );
        res.add( alt );
        res.add( asim );
        */

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
          /*
          lat.add( Integer.parseInt( result.getString("latitud") ) );
          gLat.add( Integer.parseInt( result.getString("grados_lat") ) );
          oLat.add( Integer.parseInt( result.getString("orientacion_lat") ) );
          lon.add( Integer.parseInt( result.getString("longitud") ) );
          gLon.add( Integer.parseInt( result.getString("gradLon") ) );
          oLon.add( Integer.parseInt( result.getString("orientacion_lon") ) );
          alt.add( Integer.parseInt( result.getString("altitud") ) );
          asim.add( Integer.parseInt( result.getString("asimuth") ) );
          */
        }

        res.add( temp );
        res.add( hum );
        res.add( dir );
        res.add( vel );
        res.add( rad );
        res.add( ray );
        /*
        res.add( lat );
        res.add( gLat );
        res.add( oLat );
        res.add( lon );
        res.add( gLon );
        res.add( oLon );
        res.add( alt );
        res.add( asim );
        */

        return res;
      }
    }catch( SQLException ex ){
      ex.printStackTrace();
    }
    return null;
  }

  public ResultSet getData( String finicial, String ffinal ){
    try{
      Connection conn = new DatabaseHelper().getConnection();
      ArrayList<String> res = new ArrayList<String>();
      if( conn != null ){
        System.out.println( "Connected" );

        //SELECT * FROM data WHERE datetime BETWEEN '2009-10-20 00:00:00' AND '2009-10-20 23:59:59'
        String query = "SELECT * FROM datos WHERE fecha BETWEEN '" + finicial + " 00:00:00' AND '" + ffinal + " 00:00:00' ORDER BY fecha";
        Statement statement = conn.createStatement( );
        return statement.executeQuery(query);
      }
    }catch( SQLException ex ){
      ex.printStackTrace();
    }
    return null;
  }

}
