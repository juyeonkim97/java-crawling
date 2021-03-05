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

//크롤링이란? 필요한 정보를 HTML에서 필요한 부분(속성, id, class, name)을 가져오는 것
public class Crawling {
	static String url2;
	public static void main(String[] args) {
		String url ="https://search.naver.com/search.naver?sm=tab_hty.top&where=view&query=";
		Scanner sc=new Scanner(System.in);
		System.out.print("검색어를 입력하세요 : ");
		String keyword=sc.next(); //띄어쓰기 할 경우 첫단어만 됨, 수정 필요
		String url2=null;
		Document doc = null;
		try {
			String query = URLEncoder.encode(keyword,"UTF-8"); //한글 검색 인코딩
			url2=url+query+"&sm=tab_viw.all&nso=&mode=normal&main_q=&st_coll=&topic_r_cat=";
			doc = Jsoup.connect(url2).get();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		int i=0;
		Elements element = doc.select("li.bx._svp_item");
		for(Element el : element.select("a.api_txt_lines.total_tit")) { //블로그 글 제목만 출력
			System.out.println(el.text()); 
			i++;
			if(i==10) break; //10개만 출력
		}
		
	}
}
