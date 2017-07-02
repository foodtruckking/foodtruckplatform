package com.foodtruck.platform.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by narumi12 on 2017. 7. 2..
 */
@Data
@Slf4j
@Entity
public class FoodTruckInfo implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer no;

    @Column
    private String  fdkName;

    @Column
    private String  fdkProfile;

    @Column
    private String  addr;

    @Column
    private String  xLocation;

    @Column
    private String  yLocation;

    @Column
    private String  openTime;

    @Column
    private String  endTime;

    @Column
    private String  breakTime;

    @Column
    private String  holidays;

    @Column
    private String  profilePicUrl;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @Temporal(TemporalType.TIMESTAMP)
    private Date    lastFeedUpdateDt;

}
