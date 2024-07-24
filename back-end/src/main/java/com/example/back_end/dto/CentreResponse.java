package com.example.back_end.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CentreResponse {
    private String name;
    private String adress;
    private String city;
    private String owner;
}
