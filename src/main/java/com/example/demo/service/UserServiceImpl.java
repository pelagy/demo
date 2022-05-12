package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {
private final UserRepository userRepository;
private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username)
                .orElseThrow();
    }

    public Optional<UserDto> findByName(String userName){
        return userRepository.findByUserName(userName)
                .map(userMapper::toUserDto);
    }

    public void save(UserDto userDto){
        User user = userMapper.toUser(userDto);
        userRepository.save(user);
    }

    public List<UserDto> getAllUserName() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        return userMapper.toUserDto(userRepository.save(user));
    }
}
