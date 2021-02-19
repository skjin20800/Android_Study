package com.example.kakotext;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private Integer pic;
    private String username;
    private String chatting;
    private String lastTime;

}
