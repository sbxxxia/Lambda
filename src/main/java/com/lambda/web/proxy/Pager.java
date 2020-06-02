package com.lambda.web.proxy;

import com.lambda.web.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    }

    public void setMovieMapper(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public void setBlockCount(int blockCount) {
        this.blockCount = blockCount;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public void setPreBlock(int preBlock) {
        this.preBlock = preBlock;
    }

    public void setNextBlock(int nextBlock) {
        this.nextBlock = nextBlock;
    }

    public void setNowBlock(int nowBlock) {
        this.nowBlock = nowBlock;
    }

    public MovieMapper getMovieMapper() {
        return movieMapper;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getNowPage() {
        return nowPage;
    }

    public int getBlockCount() {
        return blockCount;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public int getPreBlock() {
        return preBlock;
    }

    public int getNextBlock() {
        return nextBlock;
    }

    public int getNowBlock() {
        return nowBlock;
    }
}
