package bipro.groups.crud_dev.service;

import bipro.groups.crud_dev.dto.UserDto;
import bipro.groups.crud_dev.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto updateUser);

    public void deleteUser(Long userId);

}
