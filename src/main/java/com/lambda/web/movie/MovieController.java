package com.lambda.web.movie;

import com.lambda.web.mappers.MovieMapper;
import com.lambda.web.movie.MovieDTO;
import com.lambda.web.proxy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovieController {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;

    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord){
        if(searchWord.equals("null")){
            pxy.print("검색어가 없음");
            pager.setSearchWord("");
        } else {
            pxy.print("검색어가 "+searchWord);
            pager.setSearchWord(searchWord);
        }
        pxy.print("넘어온 페이지 번호: "+pageNumber);
        pager.setNowPage(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        Function<Pager,List<MovieDTO>> f = p -> {
            return
                    movieMapper
                            .selectMovies(p)
                            .stream()
                            .sorted()
                            .collect(Collectors.toList());
        };
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

    @GetMapping("/{searchWord}")
    public MovieDTO detail(@PathVariable String searchWord){
        return movieMapper.selectMovie(searchWord);
    }
}
