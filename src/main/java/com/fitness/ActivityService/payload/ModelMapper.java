package com.fitness.ActivityService.payload;


import com.fitness.ActivityService.Entity.Activity;
import com.fitness.ActivityService.Entity.ActivityRequest;
import com.fitness.ActivityService.Entity.ActivityResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    ActivityResponse mapActivitytoActivityResponse(Activity activity);

    Activity mapActivityRequesttoActivity(ActivityRequest request);
}
