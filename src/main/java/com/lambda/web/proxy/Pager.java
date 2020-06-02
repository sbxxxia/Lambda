package com.lambda.web.proxy;

import com.lambda.web.mappers.MovieMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Pager {
    @Autowired MovieMapper movieMapper;

    private int rowCount, startRow, endRow,
                pageCount, pageSize, startPage, endPage, nowPage,
                blockCount, blockSize, preBlock, nextBlock, nowBlock;
    private boolean existPrev, existNext;
    private String searchWord;

    public void paging(){
        rowCount = movieMapper.count();
        startRow = nowPage * pageSize;
        endRow = (nowPage != (pageCount-1)) ? startRow + (pageSize-1) : rowCount-1;
        pageCount = (rowCount % pageSize != 0) ? rowCount / pageSize + 1 : rowCount / pageSize;
        //pageSize = 5;
        startPage = nowBlock * blockSize;
        endPage = (nowBlock != (blockCount-1)) ? startPage + (blockSize-1) : pageCount-1;
        //nowPage = 1;
        blockCount = (pageCount % blockSize != 0) ? pageCount / blockSize +1 : pageCount / blockSize;
        //blockSize = 5;
        preBlock = startPage - blockSize;
        nextBlock = startPage + blockSize;
        nowBlock = nowPage / blockSize;
        System.out.println("nowBlock :: "+nowBlock);
        existPrev = nowBlock != 0;
        System.out.println("existPrev :: "+existPrev);
        existNext = (nowBlock + 1) != blockCount;
        System.out.println("existNext :: "+existNext);
    }
}
