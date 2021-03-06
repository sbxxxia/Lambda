package com.lambda.web.proxy;

import com.lambda.web.music.Music;
import com.lambda.web.music.MusicRepository;
import com.lambda.web.soccer.Player;
import com.lambda.web.soccer.PlayerDTO;
import com.lambda.web.soccer.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("uploader") @Lazy
public class FileUploader extends Proxy{
    @Autowired Inventory<String> inventory;
    @Autowired PlayerRepository playerRepository;
    @Autowired MusicRepository musicRepository;

    public void upload(){
        inventory.clear();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\bit25\\IdeaProjects\\lambdaProject\\src\\main\\resources\\static\\files\\player.csv")));
            String player = "";
            while((player = reader.readLine()) != null){
                inventory.add(player);
            }
        } catch (Exception e){
            print("파일 리딩 에러");
            e.printStackTrace();
        }
        print("------------------------------------\n");
        print(inventory.get().get(0).toString());
        String[] arr = inventory.get().get(0).toString().split(",");
        Player p = new Player();
        p.setPlayerId(arr[0]);
        p.setPlayerName(arr[1]);
        p.setEPlayerName(arr[3]);
        p.setNickname(arr[4]);
        p.setJoinYyyy(arr[5]);
        p.setPosition(arr[6]);
        p.setBackNo(arr[7]);
        p.setNation(arr[8]);
        p.setBirthDate(arr[9]);
        p.setSolar(arr[10]);
        p.setHeight(arr[11]);
        p.setWeight(arr[12]);
        print("************************\n");
        playerRepository.save(p);
    }

    public void musicUploader(ArrayList<HashMap<String, String>> list) {
    print("\n*************************");
    print(list.get(0).toString());
    Music m = new Music();
    m.setSeq(list.get(0).get("seq"));
    m.setTitle(list.get(0).get("title"));
    m.setArtist(list.get(0).get("artist"));
    m.setThumbnail(list.get(0).get("thumbnail"));
    musicRepository.save(m);
    }
}
