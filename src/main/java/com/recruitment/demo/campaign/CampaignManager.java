package com.recruitment.demo.campaign;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CampaignManager {
    private CampaignRepository campaignRepository;

    @Autowired
    public CampaignManager(CampaignRepository campaignRepository){
        this.campaignRepository = campaignRepository;
    }

    public Optional<Campaign> findById(long id){
        return campaignRepository.findById(id);
    }

    public Iterable<Campaign> findAll(){
        return campaignRepository.findAll();
    }

    public Campaign save(Campaign campaign){
        return campaignRepository.save(campaign);
    }

    public void deleteById(long id){
        campaignRepository.deleteById(id);
    }







}
