package fr.examen;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.examen.dtos.UserDto;
import fr.examen.entities.RoleEntity;
import fr.examen.entities.UserEntity;
import fr.examen.enums.RoleName;
import fr.examen.repositories.IRoleJpaRepository;
import fr.examen.repositories.IUserJpaRepository;
import fr.examen.services.IAccountService;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner start(IAccountService accountService, IUserJpaRepository userRepository,
			IRoleJpaRepository roleRepository) {
		return args -> {
			RoleEntity admin = new RoleEntity(RoleName.ADMIN);
			RoleEntity user = new RoleEntity(RoleName.USER);

			accountService.addNewRole(user);
			accountService.addNewRole(admin);

			UserDto userTemp = new UserDto(null, "Dorian", "Dubois", "dodo@gmail.com", "0000", null);
			accountService.addNewUser(userTemp);

			ArrayList<RoleEntity> roles = new ArrayList<>();
			roles.add(user);
			roles.add(admin);
			accountService.addRolesToUser(userTemp, roles);
		};
	}

}