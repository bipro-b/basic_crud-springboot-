package bipro.groups.crud_dev.service.imp;

import bipro.groups.crud_dev.dto.UserDto;
import bipro.groups.crud_dev.entity.User;
import bipro.groups.crud_dev.exception.ResourceNotFoundException;
import bipro.groups.crud_dev.mapper.UserMapper;
import bipro.groups.crud_dev.repository.UserRepository;
import bipro.groups.crud_dev.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

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

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream().map((user)-> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId,UserDto updatedUser ) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("Not found user"));

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());

        User updatedUserObj = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("This is not valid")
        );

        userRepository.deleteById(userId);
    }
}
