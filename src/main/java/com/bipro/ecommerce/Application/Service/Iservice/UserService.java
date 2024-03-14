package com.bipro.ecommerce.Application.Service.Iservice;

import com.bipro.ecommerce.Application.Dto.UserDto;

public interface UserService {
    UserDto registerUser(UserDto userDto);
    UserDto loginUser(String email , String password);
}
