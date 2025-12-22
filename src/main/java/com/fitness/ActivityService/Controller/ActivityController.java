package com.fitness.ActivityService.Controller;


import com.fitness.ActivityService.Entity.ActivityRequest;
import com.fitness.ActivityService.Entity.ActivityResponse;
import com.fitness.ActivityService.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;


    @PostMapping()
    public ResponseEntity<ActivityResponse> addActivity(@RequestBody ActivityRequest body){
        ActivityResponse allActivity = activityService.getAllActivity(body);

        return new ResponseEntity<>(allActivity, HttpStatus.OK);
    }
}
