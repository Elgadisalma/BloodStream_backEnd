package com.example.back_end.controller;

import com.example.back_end.entity.Don;
import com.example.back_end.service.StatisticsService;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    // Endpoint for getting donation history
    @GetMapping("/history/{userId}")
    public List<Don> getDonationHistory(@PathVariable Long userId) {
        return statisticsService.getDonationHistory(userId);
    }

    // Endpoint for getting personal statistics
    @GetMapping("/personal/{userId}")
    public Statistics getPersonalStatistics(@PathVariable Long userId) {
        return statisticsService.getPersonalStatistics(userId);
    }
}
