package com.presentation.bean;

import com.logic.controller.SensoresController;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.CategoryAxis;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean( name = "datos" )
public class ChartView implements Serializable {

    private Integer temperatura;
    private Integer humedad;
    private String direccion;
    private float velocidad;
    private Integer radiacion;
    private Integer rayos;
    private Date finicial;
    private Date ffinal;

    private ArrayList<Integer> tempArray;
    private ArrayList<Integer> humArray;
    private ArrayList<String> dirArray;
    private ArrayList<Float> velArray;
    private ArrayList<Integer> radArray;
    private ArrayList<Integer> rayArray;

    private LineChartModel temperaturaLine;
    private LineChartModel humedadLine;
    private PieChartModel direccionLine;
    private LineChartModel velocidadLine;
    private LineChartModel radiacionLine;
    private LineChartModel rayosLine;


    public ChartView(){

      ArrayList<ArrayList> result = new ArrayList<ArrayList>();
      SensoresController sc = new SensoresController();

      tempArray = new ArrayList<Integer>();
      humArray = new ArrayList<Integer>();
      dirArray = new ArrayList<String>();
      velArray = new ArrayList<Float>();
      radArray = new ArrayList<Integer>();
      rayArray = new ArrayList<Integer>();

      result = sc.consultar( );
      //System.out.println( result.size() );
      tempArray = result.get(0);
      humArray = result.get(1);
      dirArray = result.get(2);
      velArray = result.get(3);
      radArray = result.get(4);
      rayArray = result.get(5);

      temperatura = tempArray.get( tempArray.size() - 1 );
      humedad = humArray.get( humArray.size() - 1 );
      direccion = dirArray.get( dirArray.size() - 1 );
      velocidad = velArray.get( velArray.size() - 1 );
      radiacion = radArray.get( radArray.size() - 1 );
      rayos = rayArray.get( rayArray.size() - 1 );

    }

    public Integer getTemperatura(){
      return this.temperatura;
    }

    public Integer getHumedad(){
      return this.humedad;
    }

    public String getDireccion(){
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

    public Date getFinicial(){
      return this.finicial;
    }

    public Date getFfinal(){
      return this.ffinal;
    }

    public void setTemperatura( Integer temperatura ){
      this.temperatura = temperatura;
    }

    public void setHumedad( Integer humedad ){
      this.humedad = humedad;
    }

    public void setDireccion( String direccion ){
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

    public void setFinicial( Date finicial ){
      this.finicial = finicial;
    }

    public void setFfinal( Date ffinal ){
      this.ffinal = ffinal;
    }

    @PostConstruct
    public void init() {
        createModels();
    }

    public LineChartModel getTemperaturaLine() {
        return temperaturaLine;
    }

    public LineChartModel getHumedadLine() {
        return humedadLine;
    }

    public PieChartModel getDireccionLine() {
        return direccionLine;
    }

    public LineChartModel getVelocidadLine() {
        return velocidadLine;
    }

    public LineChartModel getRadiacionLine() {
        return radiacionLine;
    }

    public LineChartModel getRayosLine() {
        return rayosLine;
    }

    public void graficar(){
      ArrayList<ArrayList> result = new ArrayList<ArrayList>();
      SensoresController sc = new SensoresController();
      DateFormat myFormat = new SimpleDateFormat( "yyyy-MM-dd" );
      System.out.println( myFormat.format( finicial ) );
      result = sc.consultarDatos( myFormat.format( finicial ), myFormat.format( ffinal ) );
      tempArray = result.get(0);
      humArray = result.get(1);
      dirArray = result.get(2);
      velArray = result.get(3);
      radArray = result.get(4);
      rayArray = result.get(5);
      createModels();
    }

    private void createModels() {
        temperaturaLine = initTemperaturaModel();
        temperaturaLine.setLegendPosition("e");
        temperaturaLine.setTitle("Temperatura");
        Axis yAxis = temperaturaLine.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

        humedadLine = initHumedadModel();
        humedadLine.setLegendPosition("e");
        humedadLine.setTitle("Humedad");
        yAxis = humedadLine.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

        direccionLine = initDireccionModel();
        direccionLine.setLegendPosition("e");
        direccionLine.setTitle("Direccion");

        velocidadLine = initVelocidadModel();
        velocidadLine.setLegendPosition("e");
        velocidadLine.setTitle("Velocidad");
        yAxis = velocidadLine.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

        radiacionLine = initRadiacionModel();
        radiacionLine.setLegendPosition("e");
        radiacionLine.setTitle("Radiacion");
        yAxis = radiacionLine.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

        rayosLine = initRayosModel();
        rayosLine.setLegendPosition("e");
        rayosLine.setTitle("Rayos");
        yAxis = rayosLine.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    private LineChartModel initTemperaturaModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Temperatura");
        for( int i = 0; i < tempArray.size(); i++ ){
          series1.set( i, tempArray.get( i ) );
        }

        model.addSeries(series1);

        return model;
    }

    private LineChartModel initHumedadModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Humedad");

        for( int i = 0; i < humArray.size(); i++ ){
          series1.set( i, humArray.get( i ) );
        }

        model.addSeries(series1);

        return model;
    }

    private PieChartModel initDireccionModel() {
        PieChartModel model = new PieChartModel();
        int n = 0, s = 0, w = 0, e = 0;
        for( int i = 0; i < dirArray.size(); i++ ){
          String val = dirArray.get( i );
          if( val.equals( "N" )  ){
            n += 1;
          }
          if( val.equals( "S" ) ){
            s += 1;
          }
          if( val.equals( "W" ) ){
            w += 1;
          }
          if( val.equals( "E" )){
            e += 1;
          }
        }
        model.set( "N", n );
        model.set( "S", s );
        model.set( "W", w );
        model.set( "E", e );

        return model;
    }

    private LineChartModel initVelocidadModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Velocidad");

        for( int i = 0; i < velArray.size(); i++ ){
          series1.set( i, velArray.get( i ) );
        }

        model.addSeries(series1);

        return model;
    }

    private LineChartModel initRadiacionModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Radiacion");

        for( int i = 0; i < radArray.size(); i++ ){
          series1.set( i, radArray.get( i ) );
        }

        model.addSeries(series1);

        return model;
    }

    private LineChartModel initRayosModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Rayos");

        for( int i = 0; i < rayArray.size(); i++ ){
          series1.set( i, rayArray.get( i ) );
        }

        model.addSeries(series1);

        return model;
    }
}
