package com.bipro.ecommerce.Application.Service.ImplemetationService;

import com.bipro.ecommerce.Application.Dto.UserDto;
import com.bipro.ecommerce.Application.Exception.EtAuthException;
import com.bipro.ecommerce.Application.Exception.ResourceNotFoundException;
import com.bipro.ecommerce.Application.Mapper.UserMapper;
import com.bipro.ecommerce.Application.Service.Iservice.UserService;
import com.bipro.ecommerce.Domain.Entity.User;
import com.bipro.ecommerce.Infrastructure.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    // dependency injection
    private UserRepository userRepository;
    @Override
    public UserDto registerUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        User saveUser = userRepository.save(user);
        return UserMapper.mapToUserDto(saveUser);
    }

    @Override
    public UserDto loginUser(String email, String password) {


        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new ResourceNotFoundException("User not found");
        }
        // Validate password

        // Validate password
        if (!user.get().getPassword().equals(password)) {
            throw new EtAuthException("Invalid credentials");
        }
        return UserMapper.mapToUserDto(user.get());

    }


}
