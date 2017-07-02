package com.foodtruck.platform.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by narumi12 on 2017. 7. 2..
 */
@Data
@Entity
public class FoodTruckSchedule implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scheduleNo;

    @Column(nullable = false)
    private Integer foodTruckNo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDt;

    @Column
    private String status;
}
