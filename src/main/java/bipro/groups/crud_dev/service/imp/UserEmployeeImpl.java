package bipro.groups.crud_dev.service.imp;

import bipro.groups.crud_dev.dto.UserDto;
import bipro.groups.crud_dev.entity.User;
import bipro.groups.crud_dev.exception.ResourceNotFoundException;
import bipro.groups.crud_dev.mapper.UserMapper;
import bipro.groups.crud_dev.repository.UserRepository;
import bipro.groups.crud_dev.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserEmployeeImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserDto createUser( UserDto userDto) {
        User user =  UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return  UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(()
                        -> new ResourceNotFoundException("Employee is not found"));
        return UserMapper.mapToUserDto(user);
    }


}
