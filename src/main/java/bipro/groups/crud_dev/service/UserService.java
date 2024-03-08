package bipro.groups.crud_dev.service;

import bipro.groups.crud_dev.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
}
