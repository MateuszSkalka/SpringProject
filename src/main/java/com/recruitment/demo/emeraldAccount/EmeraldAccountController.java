package com.recruitment.demo.emeraldAccount;


import com.recruitment.demo.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v2")
public class EmeraldAccountController {
    @Autowired
    private EmeraldAccountRepository emeraldAccountRepository;

    @GetMapping("/emeraldaccounts")
    public List<EmeraldAccount> getAllCampaigns(){
        return emeraldAccountRepository.findAll();
    }

    @GetMapping("/emeraldaccounts/{id}")
    public ResponseEntity<EmeraldAccount> getCampaignById(@PathVariable(value = "id") Long emeraldAccountId)
            throws ResourceNotFoundException {
        EmeraldAccount emeraldAccount = emeraldAccountRepository.findById(emeraldAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + emeraldAccountId));
        return ResponseEntity.ok().body(emeraldAccount);
    }

    @PostMapping("/emeraldaccounts")
    public EmeraldAccount createEmeraldAccount(@RequestBody EmeraldAccount emeraldAccount) {
        return emeraldAccountRepository.save(emeraldAccount);
    }

    @PutMapping("/emeraldaccounts/{id}")
    public ResponseEntity<EmeraldAccount> updateEmeraldAccount(@PathVariable(value = "id") Long emeraldAccountId,
                                                   @RequestBody EmeraldAccount emeraldAccountDetails) throws ResourceNotFoundException {
        EmeraldAccount emeraldAccount = emeraldAccountRepository.findById(emeraldAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + emeraldAccountId));

        emeraldAccount.setEmeraldAccount(emeraldAccountDetails.getEmeraldAccount());


        final EmeraldAccount updatedEmeraldAccount =
                emeraldAccountRepository.save(emeraldAccount);
        return ResponseEntity.ok(updatedEmeraldAccount);
    }


    @DeleteMapping("/emeraldaccounts/{id}")
    public Map<String, Boolean> deleteEmeraldAccount(@PathVariable(value = "id") Long emeraldAccountId)
            throws ResourceNotFoundException {
        EmeraldAccount emeraldAccount = emeraldAccountRepository.findById(emeraldAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + emeraldAccountId));

        emeraldAccountRepository.delete(emeraldAccount);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
