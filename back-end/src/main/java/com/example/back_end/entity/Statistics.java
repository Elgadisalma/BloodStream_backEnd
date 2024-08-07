package com.example.back_end.entity;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Statistics {
    private int totalDonations;
    private int frequency;
    private List<String> donationTypes;
    private List<String> badges;

    public Statistics(int totalDonations, int frequency, List<String> donationTypes, List<String> badges) {
        this.totalDonations = totalDonations;
        this.frequency = frequency;
        this.donationTypes = donationTypes;
        this.badges = badges;
    }

    // Getters and Setters
    public int getTotalDonations() {
        return totalDonations;
    }

    public void setTotalDonations(int totalDonations) {
        this.totalDonations = totalDonations;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public List<String> getDonationTypes() {
        return donationTypes;
    }

    public void setDonationTypes(List<String> donationTypes) {
        this.donationTypes = donationTypes;
    }

    public List<String> getBadges() {
        return badges;
    }

    public void setBadges(List<String> badges) {
        this.badges = badges;
    }

}
