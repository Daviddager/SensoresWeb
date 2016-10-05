package com.data.Entity;

public class Sensores{
  private Integer temperatura;
  private Integer humedad;
  private char direccion;
  private float velocidad;
  private Integer radiacion;
  private Integer rayos;

  public Integer getTemperatura(){
    return this.temperatura;
  }

  public Integer getHumedad(){
    return this.humedad;
  }

  public char getDireccion(){
    return this.direccion;
  }

  public float getVelocidad(){
    return this.velocidad;
  }

  public Integer getRadiacion(){
    return this.radiacion;
  }

  public Integer getRayos(){
    return this.rayos;
  }

  public void setTemperatura( Integer temperatura ){
    this.temperatura = temperatura;
  }

  public void setHumedad( Integer humedad ){
    this.humedad = humedad;
  }

  public void setDireccion( char direccion ){
    this.direccion = direccion;
  }

  public void setVelocidad( float velocidad ){
    this.velocidad = velocidad;
  }

  public void setRadiacion( Integer radiacion ){
    this.radiacion = radiacion;
  }

  public void setRayos( Integer rayos ){
    this.rayos = rayos;
  }
  
}
