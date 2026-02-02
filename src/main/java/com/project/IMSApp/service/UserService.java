
package com.project.IMSApp.service;

import com.project.IMSApp.dto.RegisterRequest;
import com.project.IMSApp.dto.UserDto;

public interface UserService {
    UserDto register(RegisterRequest request);
    UserDto getUserById(Long id);
	UserDto getUserById(long id);
}
