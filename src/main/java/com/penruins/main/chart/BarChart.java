package com.penruins.main.chart;

import lombok.SneakyThrows;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class BarChart {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultCategoryDataset dataset = null;
        dataset = new DefaultCategoryDataset();
        dataset.addValue(15,"数量","2010");
        dataset.addValue(30,"数量","2011");
        dataset.addValue(45,"数量","2012");
        dataset.addValue(100,"数量","2013");
        dataset.addValue(150,"数量","2014");
        dataset.addValue(120,"数量","2015");
        dataset.addValue(170,"数量","2016");
        dataset.addValue(400,"数量","2017");
        dataset.addValue(600,"数量","2018");
        dataset.addValue(500,"数量","2019");

        JFreeChart freeChart= ChartFactory.createLineChart(
                "数据折线图",// 图表标题
                "年份",// 水平轴的显示标签
                "数量",//垂直轴的显示标签
                dataset,//数据集，即要显示在图表上的数据
                PlotOrientation.VERTICAL,//图表方向：水平，垂直
                true,//是否显示图例
                false,//是否显示提示
                false//是否生成URL连接
        );

        //以面板显示
        ChartPanel chartPanel=new ChartPanel(freeChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560,400));

        //创建一个主窗口来显示面板
        JFrame frame=new JFrame("条形图");
        frame.setLocation(500,400);
        frame.setSize(600,500);

        //将主窗口的内容面板设置为图表面板
        frame.setContentPane(chartPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //生成图像
        OutputStream os = new FileOutputStream("pic.jpg");
        ChartUtilities.writeChartAsJPEG(os,freeChart,500,500);
    }
}
