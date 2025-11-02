package com.example.revision_4.SecurityStuff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginresposeDto {
    String jwt;
    Integer Id;
}
