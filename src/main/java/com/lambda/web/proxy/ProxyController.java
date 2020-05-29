package com.lambda.web.proxy;
import com.lambda.web.music.Music;
import com.lambda.web.music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProxyController{
    @Autowired Box<Object> box;
    @Autowired Crawler crawler;
    @Autowired Proxy pxy;
    @Autowired FileUploader uploader;
    @Autowired MusicRepository musicRepository;
    @Autowired MovieCrawler movieCrawler;

    @PostMapping("/bugsmusic")
    public HashMap<String,Object> bugsmusic(@RequestBody String searchWord){
        pxy.print("넘어온 키워드: "+searchWord);
        box.clear();
        if(musicRepository.count() == 0) crawler.bugsMusic();
        List<Music> list = musicRepository.findAll();
        box.put("list", list);
        box.put("count", list.size());
        return box.get();
    }

    @GetMapping("/soccer/{searchWord}")
    public HashMap<String,Object> soccer(@PathVariable String searchWord){
        pxy.print("검색 키워드: "+searchWord);
        uploader.upload();
        return null;
    }

    @GetMapping("movie/{searchWord}")
    public void naverMovie(@PathVariable String searchWord){
        pxy.print("키워드: "+searchWord);
        box.clear();
        crawler.naverMovie();
    }

}