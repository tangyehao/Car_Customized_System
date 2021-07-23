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

�������ɱ���ͼ��
Created by Jason 2016-7-18 ����7:14:59
*/
public class CharReport_BZT {
/**����

�ṩ��̬��������ȡ����ͼ��1����״ͼ
@param title ����
@param datas ����
@param font ����
*/
public static void createPort(String title,Map<String,Double> datas,Font font,String path){
try {
//���ǲ�ʹ��Font,���Ľ���ʾ������ blog

DefaultPieDataset pds = new DefaultPieDataset();

//��ȡ��������
Set<Entry<String, Double>> set = datas.entrySet();
Iterator iterator=(Iterator) set.iterator();
Entry entry=null;
while(iterator.hasNext()){
entry=(Entry) iterator.next();
pds.setValue(entry.getKey().toString(),Double.parseDouble(entry.getValue().toString()));
}
/**

����һ����ͼ��ͼ��
�ֱ���:��ʾͼ��ı��⡢��Ҫ�ṩ��Ӧͼ���DateSet�����Ƿ���ʾͼ�����Ƿ�������ʿ�Լ��Ƿ�����URL����
*/
JFreeChart chart = ChartFactory.createPieChart(title, pds, true, false, true);
//����ͼƬ���������
chart.getTitle().setFont(font);

//���ͼ��,׼�����ñ�ǩ������
PiePlot plot = (PiePlot) chart.getPlot();

//���÷���Ч��,��Ҫָ�����ѳ�ȥ��key
//plot.setExplodePercent("��ʹ-��", 0.1);

//���ñ�ǩ����
plot.setLabelFont(font);

//����ͼ����Ŀ����
chart.getLegend().setItemFont(font);

/**

���ÿ�ʼ�Ƕ�(���ȼ���)
�� 0�� 30�� 45�� 60�� 90�� 120�� 135�� 150�� 180�� 270�� 360��
���� 0 ��/6 ��/4 ��/3 ��/2 2��/3 3��/4 5��/6 �� 3��/2 2��
*/
plot.setStartAngle(new Float(3.14f / 2f));

//���ñ���ͼƬ,�������ı���
//Image img = ImageIO.read(new File("f:/test/1.jpg"));
//chart.setBackgroundImage(img);

//����plot�ı���ͼƬ
//img = ImageIO.read(new File("f:/test/2.jpg"));
//plot.setBackgroundImage(img);

//����plot��ǰ��ɫ͸����
plot.setForegroundAlpha(0.7f);

//����plot�ı���ɫ͸����
plot.setBackgroundAlpha(0.0f);

//���ñ�ǩ������(Ĭ��{0})
//{0}:key {1}:value {2}:�ٷֱ� {3}:sum
plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}({1}Ԫ)/{2}"));

//���ڴ��е�ͼƬд������Ӳ��
ChartUtilities.saveChartAsJPEG(new File("C:/Users/lishan/Desktop/images/image1.png"), chart, 600, 300);
} catch (Exception e) {
e.printStackTrace();
}
}

//public static void main(String[] args) {
//Font font = new Font("������", Font.BOLD, 15);
//Map<String, Double> map=new HashMap<String, Double>();
//map.put("�ɱ�", (double) 1000);
//map.put("����", (double) 700);
//
//CharReport_BZT.createPort("��������-ѡ���������۶�����", map, font);
//}

}