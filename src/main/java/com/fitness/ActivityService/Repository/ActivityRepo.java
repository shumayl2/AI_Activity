package com.fitness.ActivityService.Repository;

import com.fitness.ActivityService.Entity.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityRepo extends MongoRepository<Activity,String> {

}
