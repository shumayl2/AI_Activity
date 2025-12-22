    package com.fitness.ActivityService.Service;


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

        public ActivityResponse getAllActivity(ActivityRequest request){
            ModelMapper mapper = Mappers.getMapper(ModelMapper.class);
            Activity activity = mapper.mapActivityRequesttoActivity(request);
            String string = UUID.randomUUID().toString();
            activity.setId(string);


            Activity save = activityRepo.save(activity);

            ActivityResponse activityResponse = mapper.mapActivitytoActivityResponse(save);

            return activityResponse;


        }


    }
