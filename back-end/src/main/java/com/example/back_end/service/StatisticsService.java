package com.example.back_end.service;

import com.example.back_end.entity.Don;
import com.example.back_end.respository.DonRepository;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StatisticsService {
    @Autowired
    private DonRepository donRepository;

    // Method for getting donation history
    public List<Don> getDonationHistory(Long userId) {
        return donRepository.findByUserId(userId);
    }

    // Method for getting personal statistics
    public Statistics getPersonalStatistics(Long userId) {
        List<Don> donations = donRepository.findByUserId(userId);
        int totalDonations = donations.size();
        int frequency = calculateFrequency(donations);
        List<String> donationTypes = getDonationTypes(donations);
        List<String> badges = assignBadges(totalDonations);

        return new Statistics(totalDonations, frequency, donationTypes, badges);
    }

    private int calculateFrequency(List<Don> donations) {
        // Implement logic to calculate donation frequency
        return donations.size(); // Example: total number of donations
    }

    private List<String> getDonationTypes(List<Don> donations) {
        List<String> types = new ArrayList<>();
        for (Don don : donations) {
            if (!types.contains(don.getType())) {
                types.add(don.getType());
            }
        }
        return types;
    }

    private List<String> assignBadges(int totalDonations) {
        List<String> badges = new ArrayList<>();
        if (totalDonations >= 10) {
            badges.add("Gold Donor");
        } else if (totalDonations >= 5) {
            badges.add("Silver Donor");
        } else if (totalDonations >= 1) {
            badges.add("Bronze Donor");
        }
        return badges;
    }
}
