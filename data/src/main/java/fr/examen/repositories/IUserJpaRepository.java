package fr.examen.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.examen.entities.UserEntity;

public interface IUserJpaRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByEmail(String email);
}
