package fr.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.examen.entities.RoleEntity;
import fr.examen.enums.RoleName;

public interface IRoleJpaRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findByRoleName(RoleName roleName);
}
