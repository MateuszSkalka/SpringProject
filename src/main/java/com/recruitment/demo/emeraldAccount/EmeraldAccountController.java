package com.recruitment.demo.emeraldAccount;


import com.recruitment.demo.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v2")
public class EmeraldAccountController {
    @Autowired
    private EmeraldAccountManager emeraldAccountManager;

    @GetMapping("/emeraldaccounts")
    public Iterable<EmeraldAccount> getAllCampaigns(){
        return emeraldAccountManager.findAll();
    }

    @GetMapping("/emeraldaccounts/{id}")
    public ResponseEntity<EmeraldAccount> getCampaignById(@PathVariable(value = "id") Long emeraldAccountId)
            throws ResourceNotFoundException {
        EmeraldAccount emeraldAccount = emeraldAccountManager.findById(emeraldAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + emeraldAccountId));
        return ResponseEntity.ok().body(emeraldAccount);
    }

    @PostMapping("/emeraldaccounts")
    public EmeraldAccount createEmeraldAccount(@RequestBody EmeraldAccount emeraldAccount) {
        return emeraldAccountManager.save(emeraldAccount);
    }

    @PutMapping("/emeraldaccounts/{id}")
    public ResponseEntity<EmeraldAccount> updateEmeraldAccount(@PathVariable(value = "id") Long emeraldAccountId,
                                                   @RequestBody EmeraldAccount emeraldAccountDetails) throws ResourceNotFoundException {
        EmeraldAccount emeraldAccount = emeraldAccountManager.findById(emeraldAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + emeraldAccountId));

        emeraldAccount.setEmeraldAccount(emeraldAccountDetails.getEmeraldAccount());


        final EmeraldAccount updatedEmeraldAccount =
                emeraldAccountManager.save(emeraldAccount);
        return ResponseEntity.ok(updatedEmeraldAccount);
    }


    @DeleteMapping("/emeraldaccounts/{id}")
    public void deleteEmeraldAccount(@PathVariable(value = "id") Long emeraldAccountId)
            throws ResourceNotFoundException {
        EmeraldAccount emeraldAccount = emeraldAccountManager.findById(emeraldAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + emeraldAccountId));

        emeraldAccountManager.deleteById(emeraldAccountId);

    }
}
