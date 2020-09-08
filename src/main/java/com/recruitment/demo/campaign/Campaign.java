package com.recruitment.demo.campaign;

import javax.persistence.*;

@Entity
@Table(name = "campaigns")
public class Campaign {


    private long id;
    private String name;
    private String keyWord1;
    private String keyWord2;
    private String keyWord3;
    private double bidAmount;
    private double campaignFund;
    private String status;
    private String town;
    private double radius;
    private static double emeraldAccount;

    public Campaign() {
    }

    public Campaign(long id, String name, String keyWord1, String keyWord2, String keyWord3, double bidAmount, double campaignFund, String status, String town, double radius, double emeraldAccount) {
        this.id = id;
        this.name = name;
        this.keyWord1 = keyWord1;
        this.keyWord2 = keyWord2;
        this.keyWord3 = keyWord3;
        this.bidAmount = bidAmount;
        this.campaignFund = campaignFund;
        this.status = status;
        this.town = town;
        this.radius = radius;
        this.emeraldAccount = emeraldAccount;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    //@Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@Column(name = "keyword1", nullable = false)
    public String getKeyWord1() {
        return keyWord1;
    }

    public void setKeyWord1(String keyWord1) {
        this.keyWord1 = keyWord1;
    }
    //@Column(name = "keyword2", nullable = false)
    public String getKeyWord2() {
        return keyWord2;
    }

    public void setKeyWord2(String keyWord2) {
        this.keyWord2 = keyWord2;
    }

    //@Column(name = "keyword3", nullable = false)
    public String getKeyWord3() {
        return keyWord3;
    }

    public void setKeyWord3(String keyWord3) {
        this.keyWord3 = keyWord3;
    }

    //@Column(name = "bid amount", nullable = false)
    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    //@Column(name = "campaign fund", nullable = false)
    public double getCampaignFund() {
        return campaignFund;
    }

    public void setCampaignFund(double campaignFund) {
        this.campaignFund = campaignFund;
    }

    //@Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //@Column(name = "town", nullable = false)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    //@Column(name = "radius", nullable = false)
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static double getEmeraldAccount() {
        return emeraldAccount;
    }

    public static void setEmeraldAccount(double emeraldAccount) {
        Campaign.emeraldAccount = emeraldAccount;
    }
}
