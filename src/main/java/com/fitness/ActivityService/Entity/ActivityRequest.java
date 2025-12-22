package com.fitness.ActivityService.Entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActivityRequest {

    private String id;
    private String userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriesburnt;
    private LocalDateTime startTime;
    private Map<String, Object> additionalMetrics;
}
