package com.fitness.ActivityService.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
@Service
@RequiredArgsConstructor
public class UservalidationService {

    private final WebClient webClientRequest;

    public Boolean Uservalidation(String userid){
        try {
            Boolean result = webClientRequest.get()
                    .uri("/user/validate/{userId}", userid)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();

            System.out.println("User validation SUCCESS for " + userid + ": " + result);
            return result != null && result;
        } catch (Exception e) {  // Sab catch kar
            System.err.println("User validation FAILED for userId: " + userid);
            e.printStackTrace();  // Console mein exact error dikhega
            return false;
        }
    }
}