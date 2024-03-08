package bipro.groups.crud_dev.controller;

import bipro.groups.crud_dev.dto.UserDto;
import bipro.groups.crud_dev.entity.User;
import bipro.groups.crud_dev.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    // Build Add Employee rest api

  //post
    @PostMapping
    public ResponseEntity<UserDto> createUser( @RequestBody UserDto userDto){

        UserDto savesUser = userService.createUser(userDto);
        return new ResponseEntity<>(savesUser, HttpStatus.CREATED);
    }

    //get by id

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto usertDto = userService.getUserById(userId);
        return ResponseEntity.ok(usertDto);
    }

    // get all users

    @GetMapping
    public ResponseEntity<List<UserDto>>getAllUsers(){
        List<UserDto>  userDtos = userService.getAllUsers();

        return ResponseEntity.ok(userDtos);
    }


    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto updatedUser){
      UserDto userUpdated =  userService.updateUser(userId,updatedUser);

      return  ResponseEntity.ok(userUpdated);
    }



}
