package fr.examen.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.examen.dtos.AccountResponseDto;
import fr.examen.dtos.LoginRequestDto;
import fr.examen.dtos.RegisterRequestDto;
import fr.examen.dtos.UserResponseDto;
import fr.examen.services.AuthenticationService;
import fr.examen.services.IAccountService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/account")
@RequiredArgsConstructor
public class AccountController {
	private final AuthenticationService authenticationService;
	private final IAccountService accountService;
	
	@GetMapping("/profile")
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ResponseEntity<UserResponseDto> profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserResponseDto userProfile = accountService.getUserByUsername(email);
        return ResponseEntity.ok(userProfile);
    }
	
	@PostMapping("/register")
	public ResponseEntity<AccountResponseDto> register(@RequestBody RegisterRequestDto request) {
		return authenticationService.register(request);
	}
	
	@PostMapping("/login")
	public ResponseEntity<AccountResponseDto> login(@RequestBody LoginRequestDto request) {
		return authenticationService.login(request);
	}
	
	
	
	
}
