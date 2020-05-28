package com.lambda.web.music;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MusicDTO {
    private String seq, title, artist, thumbnail;
}
