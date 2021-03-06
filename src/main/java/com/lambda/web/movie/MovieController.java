package com.lambda.web.movie;

import com.lambda.web.mappers.MovieMapper;
import com.lambda.web.movie.MovieDTO;
import com.lambda.web.proxy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovieController {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;

    @GetMapping("/list/{pageNumber}/{searchWord}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord){
        if(searchWord.equals("")){
            pxy.print("검색어가 없음");
        } else {
            pxy.print("검색어가 "+searchWord);
        }
        pager.paging();
        pager.setNowPage(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        IFunction<Pager,List<MovieDTO>> f = p -> movieMapper.selectMovies(p);
        List<MovieDTO> l = f.apply(pager);
        pxy.print("**************");
        for(MovieDTO m : l){
            pxy.print(m.toString());
        }
        box.clear();
        box.put("pager", pager);
        box.put("list", l);
        return box.get();
    }
}
