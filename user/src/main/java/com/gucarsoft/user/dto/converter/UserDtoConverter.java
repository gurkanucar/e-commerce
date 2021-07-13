package com.gucarsoft.user.dto.converter;

import com.gucarsoft.user.dto.UserDto;
import com.gucarsoft.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public  UserDto convert(User from){
        return new UserDto(from.getMail(), from.getFirstName(),from.getSurname(),from.getMiddleName());
    }

}
