package bipro.groups.crud_dev.controller;

import bipro.groups.crud_dev.dto.UserDto;
import bipro.groups.crud_dev.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //get

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto usertDto = userService.getUserById(userId);
        return ResponseEntity.ok(usertDto);
    }




}
