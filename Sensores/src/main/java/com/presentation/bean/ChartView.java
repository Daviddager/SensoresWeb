package com.presentation.bean;

import com.logic.controller.SensoresController;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.CategoryAxis;


@ManagedBean( name = "datos" )
public class ChartView implements Serializable {

    private Integer temperatura;
    private Integer humedad;
    private String direccion;
    private float velocidad;
    private Integer radiacion;
    private Integer rayos;
    private String finicial;
    private String ffinal;

    private LineChartModel temperaturaLine;
    private LineChartModel humedadLine;
    private LineChartModel direccionLine;
    private LineChartModel velocidadLine;
    private LineChartModel radiacionLine;
    private LineChartModel rayosLine;


    public ChartView(){
      temperatura = 0;
      humedad = 0;
      direccion = "0";
      velocidad = 0.0f;
      radiacion = 0;
      rayos = 0;
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

    public String getFinicial(){
      return this.finicial;
    }

    public String getFfinal(){
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

    public void setFinicial( String finicial ){
      this.finicial = finicial;
    }

    public void setFfinal( String ffinal ){
      this.ffinal = ffinal;
    }

    @PostConstruct
    public void init() {
        createLineModels();
    }

    public LineChartModel getTemperaturaLine() {
        return temperaturaLine;
    }

    public LineChartModel getHumedadLine() {
        return humedadLine;
    }

    public LineChartModel getDireccionLine() {
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
    //
    // public LineChartModel getLineModel2() {
    //     return lineModel2;
    // }

    public void graficar(){

    }

    private void createLineModels() {
        temperaturaLine = initTemperaturaModel();
        temperaturaLine.setLegendPosition("e");
        temperaturaLine.setTitle("Temperatura");
        Axis yAxis = temperaturaLine.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

        humedadLine = initHumedadModel();
        humedadLine.setLegendPosition("e");
        humedadLine.setTitle("Humedad");
        Axis yAxis = humedadLine.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

        temperaturaLine = initTemperatureModel();
        temperaturaLine.setLegendPosition("e");
        temperaturaLine.setTitle("Temperatura");
        Axis yAxis = temperaturaLine.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

        temperaturaLine = initTemperatureModel();
        temperaturaLine.setLegendPosition("e");
        temperaturaLine.setTitle("Temperatura");
        Axis yAxis = temperaturaLine.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

        temperaturaLine = initTemperatureModel();
        temperaturaLine.setLegendPosition("e");
        temperaturaLine.setTitle("Temperatura");
        Axis yAxis = temperaturaLine.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

        temperaturaLine = initTemperatureModel();
        temperaturaLine.setLegendPosition("e");
        temperaturaLine.setTitle("Temperatura");
        Axis yAxis = temperaturaLine.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

        // lineModel2 = initCategoryModel();
        // lineModel2.setTitle("Category Chart");
        // lineModel2.setLegendPosition("e");
        // lineModel2.setShowPointLabels(true);
        // lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Years"));
        // yAxis = lineModel2.getAxis(AxisType.Y);
        // yAxis.setLabel("Births");
        // yAxis.setMin(0);
        // yAxis.setMax(200);
    }

    private LineChartModel initTemperatureModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Temperatura");

        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);

        model.addSeries(series1);

        return model;
    }

    // private LineChartModel initCategoryModel() {
    //     LineChartModel model = new LineChartModel();
    //
    //     ChartSeries boys = new ChartSeries();
    //     boys.setLabel("Boys");
    //     boys.set("2004", 120);
    //     boys.set("2005", 100);
    //     boys.set("2006", 44);
    //     boys.set("2007", 150);
    //     boys.set("2008", 25);
    //
    //     ChartSeries girls = new ChartSeries();
    //     girls.setLabel("Girls");
    //     girls.set("2004", 52);
    //     girls.set("2005", 60);
    //     girls.set("2006", 110);
    //     girls.set("2007", 90);
    //     girls.set("2008", 120);
    //
    //     model.addSeries(boys);
    //     model.addSeries(girls);
    //
    //     return model;
    // }

}
