package com.penruins.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class Cahrt3D {
    public static void main(String[] args) {
        DefaultCategoryDataset dataset = null;

        //设置数据集
        dataset=new DefaultCategoryDataset();
        //第一个参数是第三个参数的值，即“最高分”，第二个参数表示目录轴的分类，第三个参数表示的x轴显示标签
        dataset.addValue(98,"语文","最高分");
        dataset.addValue(89,"语文","平均分");
        dataset.addValue(60,"语文","最低分");
        dataset.addValue(99,"数学","最高分");
        dataset.addValue(90,"数学","平均分");
        dataset.addValue(70,"数学","最低分");
        dataset.addValue(80,"英语","最高分");
        dataset.addValue(75,"英语","平均分");
        dataset.addValue(33,"英语","最低分");
        // 创建简单的条形图
        JFreeChart freeChart= ChartFactory.createBarChart3D(
                "学生信息",// 图表标题
                "学科",// 水平轴的显示标签
                "成绩",//垂直轴的显示标签
                dataset,//数据集，即要显示在图表上的数据
                PlotOrientation.VERTICAL,//图表方向：水平，垂直
                true,//是否显示图例
                false,//是否显示提示
                false//是否生成URL连接
        );
        //以面板显示，创建一个图表面板
        ChartPanel chartPanel=new ChartPanel(freeChart);
        //设置大小
        chartPanel.setPreferredSize(new java.awt.Dimension(560,400));
        //创建一个主窗口来显示面板
        JFrame frame=new JFrame("条形图");
        frame.setLocation(500,400);
        frame.setSize(600,500);
        //将图表面板设置为主窗口的内容面板
        frame.setContentPane(chartPanel);
        //显示主窗口
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
