package com.fitness.ActivityService.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class UservalidationService {

    private final WebClient webClient;

    public Boolean Uservalidation(String userid){
        try {
            return webClient.get()
                    .uri("/user/validate/{userid}",userid)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        }catch (Exception e){

        }
        return false;

    }

}
