package fr.examen.services;

import java.util.List;

import fr.examen.dtos.UserDto;
import fr.examen.dtos.UserResponseDto;
import fr.examen.entities.RoleEntity;
import fr.examen.entities.UserEntity;

public interface IAccountService {
	
	
	RoleEntity addNewRole(RoleEntity role);
	
	void addRolesToUser(UserDto user, List<RoleEntity> roles);
	
	UserResponseDto addNewUser(UserDto userDto);
    UserResponseDto getUserById(Long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);

	UserResponseDto getUserByUsername(String email);
}
