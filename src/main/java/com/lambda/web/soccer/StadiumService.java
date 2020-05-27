package com.lambda.web.soccer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StadiumService {
    @Autowired StadiumRepository stadiumRepository;
}
