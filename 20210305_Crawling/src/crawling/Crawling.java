package crawling;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//ũ�Ѹ��̶�? �ʿ��� ������ HTML���� �ʿ��� �κ�(�Ӽ�, id, class, name)�� �������� ��
public class Crawling {
	static String url2;
	public static void main(String[] args) {
		String url ="https://search.naver.com/search.naver?sm=tab_hty.top&where=view&query=";
		Scanner sc=new Scanner(System.in);
		System.out.print("�˻�� �Է��ϼ��� : ");
		String keyword=sc.next(); //���� �� ��� ù�ܾ ��, ���� �ʿ�
		String url2=null;
		Document doc = null;
		try {
			String query = URLEncoder.encode(keyword,"UTF-8"); //�ѱ� �˻� ���ڵ�
			url2=url+query+"&sm=tab_viw.all&nso=&mode=normal&main_q=&st_coll=&topic_r_cat=";
			doc = Jsoup.connect(url2).get();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		int i=0;
		Elements element = doc.select("li.bx._svp_item");
		for(Element el : element.select("a.api_txt_lines.total_tit")) { //��α� �� ���� ���
			System.out.println(el.text()); 
			i++;
			if(i==10) break; //10���� ���
		}
		
	}
}
