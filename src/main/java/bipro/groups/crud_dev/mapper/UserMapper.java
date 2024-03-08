package bipro.groups.crud_dev.mapper;

import bipro.groups.crud_dev.dto.UserDto;
import bipro.groups.crud_dev.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
               user.getId(),
               user.getFirstName(),
               user.getLastName(),
               user.getEmail()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }
}
