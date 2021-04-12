package gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Graficador {

    double x[], y[];

    public Graficador(double x[], double y[]) {
        this.x = x;
        this.y = y;
    }

    public ChartPanel creaGrafica(String titulo) {

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset, titulo);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 500));

        double rangeX[] = new double[2];
        double rangeY[] = new double[2];
        getMinAndMax(x, rangeX);
        getMinAndMax(y, rangeY);
        chartPanel.getChart().getXYPlot().getDomainAxis().setRange(rangeX[0], rangeX[1]);
        chartPanel.getChart().getXYPlot().getRangeAxis().setRange(rangeY[0], rangeY[1]);

        return chartPanel;
    }

    private void getMinAndMax(double arr[], double out[]) {
        out[0] = arr[0];
        out[1] = arr[0];
        for (double v : arr) {
            out[0] = Math.min(out[0], v);
            out[1] = Math.max(out[1], v);
        }
        double dist = ((out[1]+2) - out[0]) / 100;
        out[0] -= dist;
        out[1] += dist;
    }

    private XYDataset createDataset() {

        XYSeries series = new XYSeries("");
        for (int i = 0; i < x.length; i++) {
            series.add(x[i], y[i]);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset, String titulo) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                titulo,
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.BLACK);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        //Oculta la indicación de la gráfica
        chart.getLegend().visible=false;

        chart.setTitle(new TextTitle(titulo, new Font("Serif", java.awt.Font.BOLD, 18)));
        return chart;
    }
}
