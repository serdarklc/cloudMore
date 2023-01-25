package com.cloudMore.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class UserCreationsPojo {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;
}
