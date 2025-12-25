//    package com.fitness.ActivityService.Service;
//
//
//    import com.fitness.ActivityService.Configuration.WebClientConfig;
//    import com.fitness.ActivityService.Entity.Activity;
//    import com.fitness.ActivityService.Entity.ActivityRequest;
//    import com.fitness.ActivityService.Entity.ActivityResponse;
//    import com.fitness.ActivityService.Repository.ActivityRepo;
//    import com.fitness.ActivityService.payload.ModelMapper;
//    import lombok.RequiredArgsConstructor;
//    import org.mapstruct.factory.Mappers;
//    import org.springframework.beans.factory.annotation.Autowired;
//    import org.springframework.beans.factory.annotation.Value;
//    import org.springframework.kafka.core.KafkaTemplate;
//    import org.springframework.stereotype.Service;
//
//    import java.util.UUID;
//
//    @Service
//    @RequiredArgsConstructor
//    public class ActivityService  {
//
//        @Autowired
//        private ActivityRepo activityRepo;
//
//        @Autowired
//        private UservalidationService uservalidationService;
//
//        private KafkaTemplate<String,Activity> kafkaTemplate;
//
//        @Value("${kafka.topic.name}")
//        private String topicname;
//
//        public ActivityResponse getAllActivity(ActivityRequest request){
//            ModelMapper mapper = Mappers.getMapper(ModelMapper.class);
//            Boolean uservalidation = uservalidationService.Uservalidation(request.getUserId());
//            if(!uservalidation){
//                throw new RuntimeException("Invalid user");
//            }
//            Activity activity = mapper.mapActivityRequesttoActivity(request);
////            String string = UUID.randomUUID().toString();
////            activity.setId(string);
//
//
//            Activity save = activityRepo.save(activity);
//            try {
//                kafkaTemplate.send(topicname,save.getUserId(),save);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//
//            ActivityResponse activityResponse = mapper.mapActivitytoActivityResponse(save);
//
//            return activityResponse;
//
//
//        }
//
//
//    }
package com.fitness.ActivityService.Service;


import com.fitness.ActivityService.Configuration.WebClientConfig;
import com.fitness.ActivityService.Entity.Activity;
import com.fitness.ActivityService.Entity.ActivityRequest;
import com.fitness.ActivityService.Entity.ActivityResponse;
import com.fitness.ActivityService.Repository.ActivityRepo;
import com.fitness.ActivityService.payload.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ActivityService  {

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private UservalidationService uservalidationService;

    public ActivityResponse getAllActivity(ActivityRequest request){
        ModelMapper mapper = Mappers.getMapper(ModelMapper.class);
        Boolean uservalidation = uservalidationService.Uservalidation(request.getUserId());
        if(!uservalidation){
            throw new RuntimeException("Invalid user");
        }
        Activity activity = mapper.mapActivityRequesttoActivity(request);
//            String string = UUID.randomUUID().toString();
//            activity.setId(string);


        Activity save = activityRepo.save(activity);

        ActivityResponse activityResponse = mapper.mapActivitytoActivityResponse(save);

        return activityResponse;


    }


}