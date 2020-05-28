package com.lambda.web.proxy;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("movieCrw") @Lazy
public class MovieCrawler extends Proxy{
    @Autowired Inventory<HashMap<String,String>> inventory;
    @Autowired Box<String> box;

    public ArrayList<HashMap<String, String>> naverMovie(){
        inventory.clear();
        try {
            String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
            Connection.Response homepage = Jsoup.connect(url)
                    .method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Elements title = d.select("div.tit3");
            HashMap<String,String> map = null;
            for(int i=0; i<title.size(); i++){
                map = new HashMap<>();
                map.put("seq", string(i+1));
                map.put("title", title.get(i).text());
                inventory.add(map);
            }

        } catch (Exception e) {
            print("에러 발생");
        }
        print("\n*************************네이버 크롤링****************************\n");
        inventory.get().forEach(System.out::println);
        return inventory.get();
    }
}
