package com.example.contents;


import com.example.contents.dto.UserDto;
import com.example.contents.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
// repository를 임시로 만들어서 -> Mock
public class UserServiceTests {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    // UserDto(id==null)를 입력받아 UserDto(id!=null)를 반환
    @Test
    @DisplayName("UserDto로 createUser")
    public void testCreateUser() {
        // given
        // 1. UserRepository가 전달받을 UserEntity 정의
        String username = "panghun";
        UserEntity userEntityIn = new UserEntity();
        userEntityIn.setUsername(username);

        // 2. UserRepository가 반환할 UserEntity 정의
        Long userId = 1L;
        UserEntity userEntityOut = new UserEntity();
        userEntityOut.setId(userId);
        userEntityOut.setUsername(username);

        // 3. UserRepository.save()의 기능을 따라하도록 설정
        when(userRepository.save(userEntityIn))
                .thenReturn(userEntityOut);
        when(userRepository.existsByUsername(username))
                .thenReturn(false);

        // when
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        UserDto result = userService.createUser(userDto);

        // then
        assertEquals(userId, result.getId());
        assertEquals(username, result.getUsername());
    }
}
