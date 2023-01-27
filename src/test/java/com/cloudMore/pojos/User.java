package com.cloudMore.pojos;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class User {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    public static User getInstance(){
        if (user == null){
            Faker faker = new Faker();
            user = User.builder().id(faker.number().randomDigitNotZero()).username(faker.name().username()).firstName(faker.name().firstName()).
                    lastName(faker.name().lastName()).email(faker.internet().emailAddress()).password(faker.internet().password()).
                    phone(faker.numerify("###########")).userStatus(0).build();
        }
        return user;
    }
    private static User user;

}

