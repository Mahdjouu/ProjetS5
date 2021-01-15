package Mapping;

import javax.swing.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import java.sql.*;

import static java.sql.DriverManager.*;


public class Graphique {
    private int idC;
    private Connection connection;
    private DateFormat dateDebut;
    private DateFormat dateFin;

    public Graphique ( int idC, Connection connection, DateFormat debut, DateFormat fin ) {
        this.idC = idC;
        this.connection = connection;
        this.dateDebut = debut;
        this.dateFin = fin;
    }

    public JFreeChart create( int idC) throws SQLException {

        String chartTitle = " Capteur " + idC;
        String xAxisLabel = "Date/Time";
        String yAxisLabel = "Valeur";
        XYDataset dataset = createDataset();
        boolean showLegend = true;
        boolean createURL = false;
        boolean createTooltip = false;
        
        JFreeChart chart = ChartFactory.createTimeSeriesChart(chartTitle,
        xAxisLabel, yAxisLabel, dataset,
        showLegend, createTooltip, createURL);
         

        XYPlot plot = chart.getXYPlot();
        int width = 640;
        int height = 480;
         
         
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("dd-MMM-yyyy HH:mm"));
        
        return chart;
    }

    public XYDataset createDataset() throws SQLException {
    	TimeSeriesCollection mydata = new TimeSeriesCollection();
    	TimeSeries series11 = new TimeSeries("Data 1");
    	try {
    	//This query helps to fetch the data from the database.
            
            Statement statement = this.connection.createStatement( );

            ResultSet y = statement.executeQuery("SELECT `valeur` FROM `donnee`" );
            ResultSet x = statement.executeQuery("SELECT `dateTime` FROM `donnee`" );
            ResultSet table = statement.executeQuery("SELECT `*` FROM `donnee`" );

    	    while (table.next()) {
    	        Timestamp time = table.getTimestamp("dateTime");
    	        Double value = table.getDouble("valeur");
    	        series11.addOrUpdate(new Millisecond(time), value);
    	        System.out.println("The date" + time);
    	    }
    	}
    	catch (Exception e) {
    	    e.printStackTrace();
    	}
    	TimeSeriesCollection dataset = new TimeSeriesCollection();
    	dataset.addSeries(series11);
    	
        this.connection.close();
    	return dataset;
    	}


    /*
    ____________________________
              GETTERS
    ____________________________
    */

    public int getIdC () {
        return idC;
    }

}
