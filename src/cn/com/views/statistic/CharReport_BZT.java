package cn.com.views.statistic;
import java.awt.Font;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**code

测试生成报表图形
Created by Jason 2016-7-18 上午7:14:59
*/
public class CharReport_BZT {
/**对象

提供静态方法：获取报表图形1：饼状图
@param title 标题
@param datas 数据
@param font 字体
*/
public static void createPort(String title,Map<String,Double> datas,Font font,String path){
try {
//若是不使用Font,中文将显示不出来 blog

DefaultPieDataset pds = new DefaultPieDataset();

//获取迭代器：
Set<Entry<String, Double>> set = datas.entrySet();
Iterator iterator=(Iterator) set.iterator();
Entry entry=null;
while(iterator.hasNext()){
entry=(Entry) iterator.next();
pds.setValue(entry.getKey().toString(),Double.parseDouble(entry.getValue().toString()));
}
/**

生成一个饼图的图表
分别是:显示图表的标题、须要提供对应图表的DateSet对象、是否显示图例、是否生成贴士以及是否生成URL连接
*/
JFreeChart chart = ChartFactory.createPieChart(title, pds, true, false, true);
//设置图片标题的字体
chart.getTitle().setFont(font);

//获得图块,准备设置标签的字体
PiePlot plot = (PiePlot) chart.getPlot();

//设置分裂效果,须要指定分裂出去的key
//plot.setExplodePercent("天使-彦", 0.1);

//设置标签字体
plot.setLabelFont(font);

//设置图例项目字体
chart.getLegend().setItemFont(font);

/**

设置开始角度(弧度计算)
度 0° 30° 45° 60° 90° 120° 135° 150° 180° 270° 360°
弧度 0 π/6 π/4 π/3 π/2 2π/3 3π/4 5π/6 π 3π/2 2π
*/
plot.setStartAngle(new Float(3.14f / 2f));

//设置背景图片,设置最大的背景
//Image img = ImageIO.read(new File("f:/test/1.jpg"));
//chart.setBackgroundImage(img);

//设置plot的背景图片
//img = ImageIO.read(new File("f:/test/2.jpg"));
//plot.setBackgroundImage(img);

//设置plot的前景色透明度
plot.setForegroundAlpha(0.7f);

//设置plot的背景色透明度
plot.setBackgroundAlpha(0.0f);

//设置标签生成器(默认{0})
//{0}:key {1}:value {2}:百分比 {3}:sum
plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}({1}元)/{2}"));

//将内存中的图片写到本地硬盘
ChartUtilities.saveChartAsJPEG(new File("C:/Users/lishan/Desktop/images/image1.png"), chart, 600, 300);
} catch (Exception e) {
e.printStackTrace();
}
}

//public static void main(String[] args) {
//Font font = new Font("新宋体", Font.BOLD, 15);
//Map<String, Double> map=new HashMap<String, Double>();
//map.put("成本", (double) 1000);
//map.put("利润", (double) 700);
//
//CharReport_BZT.createPort("量车定制-选定日期销售额详情", map, font);
//}

}