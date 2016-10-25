package com.presentation.bean;

import com.logic.controller.SensoresController;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import java.sql.ResultSet;
import java.sql.SQLException;

@ManagedBean( name = "datos" )
public class ChartView implements Serializable{

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
    public void downloadFile() throws IOException {
      FacesContext fc = FacesContext.getCurrentInstance();
      HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
      String filename = "testing.txt";
      response.reset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
      response.setContentType( "plain" ); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ServletContext#getMimeType() for auto-detection based on filename.
      //response.setContentLength(contentLength); // Set it with the file size. This header is optional. It will work if it's omitted, but the download progress will be unknown.
      response.setHeader("Content-Disposition", "attachment; filename=testing.txt"); // The Save As popup magic is done here. You can give it any file name you want, this only won't work in MSIE, it will use current request URL as file name instead.

      OutputStream output = response.getOutputStream();
      // Now you can write the InputStream of the file to the above OutputStream the usual way.
      // ...
      SensoresController sc = new SensoresController();
      DateFormat myFormat = new SimpleDateFormat( "yyyy-MM-dd" );
      System.out.println( myFormat.format( finicial ) );
      try{
      ResultSet result = sc.getData( myFormat.format( finicial ), myFormat.format( ffinal ) );
      Writer w = new OutputStreamWriter( output, "UTF-8" );
      while( result.next() ){
        w.write( Integer.toString(result.getInt("temperatura")) + "," );
      }
      w.close();
      fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
      }catch( SQLException ex ){
        ex.printStackTrace();
      }
    }
    
    private void createModels() {
        temperaturaLine = initTemperaturaModel();
        temperaturaLine.setLegendPosition("e");
        temperaturaLine.setTitle("Temperatura");
        Axis yAxis = temperaturaLine.getAxis(AxisType.Y);
        yAxis.setMin( setlowerBoundInt( tempArray ) );
        yAxis.setMax( setHigherBoundInt( tempArray ) );

        humedadLine = initHumedadModel();
        humedadLine.setLegendPosition("e");
        humedadLine.setTitle("Humedad");
        yAxis = humedadLine.getAxis(AxisType.Y);
        yAxis.setMin( setlowerBoundInt( humArray ) );
        yAxis.setMax( setHigherBoundInt( humArray ) );

        direccionLine = initDireccionModel();
        direccionLine.setLegendPosition("e");
        direccionLine.setTitle("Direccion");

        velocidadLine = initVelocidadModel();
        velocidadLine.setLegendPosition("e");
        velocidadLine.setTitle("Velocidad");
        yAxis = velocidadLine.getAxis(AxisType.Y);
        yAxis.setMin( setlowerBoundFloat( velArray ) );
        yAxis.setMax( setHigherBoundFloat( velArray ) );

        radiacionLine = initRadiacionModel();
        radiacionLine.setLegendPosition("e");
        radiacionLine.setTitle("Radiacion");
        yAxis = radiacionLine.getAxis(AxisType.Y);
        yAxis.setMin( setlowerBoundInt( radArray ) );
        yAxis.setMax( setHigherBoundInt( radArray ) );

        rayosLine = initRayosModel();
        rayosLine.setLegendPosition("e");
        rayosLine.setTitle("Rayos");
        yAxis = rayosLine.getAxis(AxisType.Y);
        yAxis.setMin( setlowerBoundInt( rayArray ) );
        yAxis.setMax( setHigherBoundInt( rayArray ) );
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

    private int setlowerBoundInt( ArrayList<Integer> array ){
      int minVal = array.get(0);
      for( int i = 1; i < array.size(); i++ ){
        if( minVal > array.get(i) ) minVal = array.get(i);
      }
      return minVal - 1;
    }

    private int setHigherBoundInt( ArrayList<Integer> array ){
      int maxVal = array.get(0);
      for( int i = 1; i < array.size(); i++ ){
        if( maxVal < array.get(i) ) {
          maxVal = array.get(i);
        }
      }
      return (maxVal + 1);
    }

    private int setlowerBoundFloat( ArrayList<Float> array ){
      int minVal = array.get(0).intValue();
      for( int i = 1; i < array.size(); i++ ){
        if( minVal > array.get(i).intValue() ) minVal = array.get(i).intValue();
      }
      return minVal - 1;
    }

    private int setHigherBoundFloat( ArrayList<Float> array ){
      int maxVal = array.get(0).intValue();
      for( int i = 1; i < array.size(); i++ ){
        if( maxVal < array.get(i).intValue() ) maxVal = array.get(i).intValue();
      }
      return (maxVal + 1);
    }
}
