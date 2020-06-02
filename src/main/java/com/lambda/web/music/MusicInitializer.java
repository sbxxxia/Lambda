package com.lambda.web.music;
import com.lambda.web.mappers.MusicMapper;
import com.lambda.web.proxy.Crawler;
import com.lambda.web.proxy.ISupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MusicInitializer implements ApplicationRunner {
    @Autowired MusicMapper musicMapper;
    @Autowired Crawler crawler;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        ISupplier<Integer> s =  musicMapper::count;
        if(s.get() == 0) crawler.naverMovie();
    }
}
