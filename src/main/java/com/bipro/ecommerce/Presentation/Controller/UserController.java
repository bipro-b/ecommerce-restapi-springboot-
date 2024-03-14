package com.bipro.ecommerce.Presentation.Controller;


import com.bipro.ecommerce.Application.Dto.UserDto;
import com.bipro.ecommerce.Application.Exception.EtAuthException;
import com.bipro.ecommerce.Application.Exception.ResourceNotFoundException;
import com.bipro.ecommerce.Application.Service.Iservice.UserService;
import com.bipro.ecommerce.Domain.Entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){

        UserDto saveUser = userService.registerUser(userDto);
        return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto userDto){

        try {
            UserDto loggedUser = userService.loginUser(userDto.getEmail(),userDto.getPassword());
            String successMessage = "Successfully logged in!";
            return new ResponseEntity<>(loggedUser,HttpStatus.OK);

        } catch(ResourceNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (EtAuthException e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }


}
