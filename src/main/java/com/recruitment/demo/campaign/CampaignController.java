package com.recruitment.demo.campaign;


import com.recruitment.demo.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1")
public class CampaignController {
    @Autowired
    private CampaignRepository campaignRepository;

    @GetMapping("/campaigns")
    public List<Campaign> getAllCampaigns(){
        return campaignRepository.findAll();
    }

    @GetMapping("/campaigns/{id}")
    public ResponseEntity<Campaign> getCampaignById(@PathVariable(value = "id") Long campaignId)
            throws ResourceNotFoundException {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + campaignId));
        return ResponseEntity.ok().body(campaign);
    }

    @PostMapping("/campaigns")
    public Campaign createCampaign(@RequestBody Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    @PutMapping("/campaigns/{id}")
    public ResponseEntity<Campaign> updateCampaign(@PathVariable(value = "id") Long campaignId,
                                                    @RequestBody Campaign campaignDetails) throws ResourceNotFoundException {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + campaignId));

        campaign.setName(campaignDetails.getName());
        campaign.setKeyWord1(campaignDetails.getKeyWord1());
        campaign.setKeyWord2(campaignDetails.getKeyWord2());
        campaign.setKeyWord3(campaignDetails.getKeyWord3());
        campaign.setBidAmount(campaignDetails.getBidAmount());
        campaign.setCampaignFund(campaignDetails.getCampaignFund());
        campaign.setStatus(campaignDetails.getStatus());
        campaign.setTown(campaignDetails.getTown());
        campaign.setRadius(campaignDetails.getRadius());


        final Campaign updatedCampaign =
                campaignRepository.save(campaign);
        return ResponseEntity.ok(updatedCampaign);
    }


    @DeleteMapping("/campaigns/{id}")
    public Map<String, Boolean> deleteCampaign(@PathVariable(value = "id") Long campaignId)
            throws ResourceNotFoundException {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + campaignId));

        campaignRepository.delete(campaign);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}


