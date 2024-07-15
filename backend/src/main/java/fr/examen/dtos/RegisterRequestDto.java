package fr.examen.dtos;

import lombok.Data;


@Data
public class RegisterRequestDto {
	private String firstname;
	private String lastname;
	private String password;
	private String email;
}
