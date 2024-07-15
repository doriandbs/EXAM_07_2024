package fr.examen.entities;

import fr.examen.enums.RoleName;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="roles")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {
	  @Id
	  @GeneratedValue(strategy= GenerationType.AUTO)
	  private Long id;
	  
	  @Enumerated(EnumType.STRING)
	  private RoleName roleName;

	  public RoleEntity(RoleName roleName) {
		  this.roleName = roleName;
	  }
}
