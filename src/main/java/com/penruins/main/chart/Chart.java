package com.penruins.main.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class Chart {
    public static void main(String[] args) {
        DefaultCategoryDataset dataset = null;
        dataset = new DefaultCategoryDataset();
        dataset.addValue(98,"语文","最高分");
        dataset.addValue(89,"语文","平均分");
        dataset.addValue(60,"语文","最低分");
        dataset.addValue(99,"数学","最高分");
        dataset.addValue(90,"数学","平均分");
        dataset.addValue(70,"数学","最低分");
        dataset.addValue(80,"英语","最高分");
        dataset.addValue(75,"英语","平均分");
        dataset.addValue(33,"英语","最低分");

        JFreeChart freeChart = ChartFactory.createBarChart(
                "学生信息",
                "学科",
                "成绩",
                dataset,
                PlotOrientation.VERTICAL,
                true,//是否显示图例
                false,//是否显示提示
                false//是否生成URL连接
        );
        ChartPanel chartPanel = new ChartPanel(freeChart);
        chartPanel.setPreferredSize(new Dimension(560,400));

        JFrame frame = new JFrame("条形图");
        frame.setLocation(500,400);
        frame.setSize(600,500);

        frame.setContentPane(chartPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }
}
