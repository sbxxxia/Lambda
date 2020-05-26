package com.lambda.web.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired ScheduleRepository scheduleRepository;
}
