package com.gucarsoft.user.controller;

import com.gucarsoft.user.dto.CreateUserRequest;
import com.gucarsoft.user.dto.UpdateUserRequest;
import com.gucarsoft.user.dto.UserDto;
import com.gucarsoft.user.model.User;
import com.gucarsoft.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest userRequest){
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest updateUserRequest){
        return ResponseEntity.ok(userService.updateUser(id,updateUserRequest));
    }

  /*  @PatchMapping("/{id}")
    public  ResponseEntity<Void> deactiveUser(@PathVariable Long id){
        userService.deactiveUser(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
*/

}
