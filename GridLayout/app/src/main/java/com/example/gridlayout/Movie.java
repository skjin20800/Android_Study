package com.example.gridlayout;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Serializable {
    private Integer id;
    private String title;
    private Integer pic;
}
