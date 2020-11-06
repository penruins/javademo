package com.penruins.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class PieChart {
    public static void main(String[] args) {
        //创建饼图数据集
        DefaultPieDataset dataset=new DefaultPieDataset();

        //设置数据集，饼图的数据对象只能添加两个参数
        dataset=new DefaultPieDataset();
        dataset.setValue("语文",38);
        dataset.setValue("数学",99);
        dataset.setValue("英语",60);
        //实现简单的饼图，并设置基本数据
        JFreeChart freeChart= ChartFactory.createPieChart(
                "饼图",// 图表标题
                dataset,//数据集，即要显示在图表上的数据
                true,//是否显示图例
                true,//是否显示提示
                false//是否生成URL连接
        );

        //以面板显示
        ChartPanel chartPanel=new ChartPanel(freeChart);
        chartPanel.setPreferredSize(new Dimension(560,400));
        //创建一个主窗口来显示面板
        JFrame frame=new JFrame("饼图");
        frame.setLocation(500,400);
        frame.setSize(600,500);
        frame.setContentPane(chartPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
