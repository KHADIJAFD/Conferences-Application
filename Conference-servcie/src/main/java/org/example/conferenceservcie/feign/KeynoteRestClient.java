package org.example.conferenceservcie.feign;

import org.example.conferenceservcie.entities.Conference;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "wallet-service")

public interface KeynoteRestClient {
    @GetMapping("/api/keynotes/{id}")
    Conference getWalletById(@PathVariable UUID id);

    @PutMapping("/api/wallets/{id}/updateBlance")
    Conference updateWalletBalance(@PathVariable("id") UUID id, @RequestParam double balance);
}
