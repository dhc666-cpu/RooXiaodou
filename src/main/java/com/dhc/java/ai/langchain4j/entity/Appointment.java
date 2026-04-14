package com.dhc.java.ai.langchain4j.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @TableId(type = IdType.AUTO)
    @NotNull private Long id;
    @NotNull private String username;
    @NotNull private String idCard;
    @NotNull private String department;
    @NotNull private String date;
    @NotNull private String time;
    private String doctorName;
}
