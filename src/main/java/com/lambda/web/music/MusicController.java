package com.lambda.web.music;

import com.lambda.web.mappers.MusicMapper;
import com.lambda.web.proxy.Box;
import com.lambda.web.proxy.IFunction;
import com.lambda.web.proxy.Pager;
import com.lambda.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/musics")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MusicController {
    @Autowired Proxy pxy;
    @Autowired Pager pager;
    @Autowired MusicMapper musicMapper;
    @Autowired Box<Object> box;

    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> list(@PathVariable("searchWord") String searchWord,
                         @PathVariable("pageNumber") String pageNumber){
        if(searchWord.equals("")){
            pxy.print("검색어가 없음");
        } else {
            pxy.print("검색어가 "+searchWord);
        }
        pager.setNowPage(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        IFunction<Pager, List<MusicDTO>> f = p -> musicMapper.selectMusics(p);
        List<MusicDTO> list = f.apply(pager);
        pxy.print("*****************");
        for(MusicDTO m : list){
            pxy.print(m.toString());
        }
        box.clear();
        box.put("pager", pager);
        box.put("list", list);
        return box.get();
    }
}
