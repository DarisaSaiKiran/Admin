package com.example.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String password;
	private String email;
	private boolean loggedIn=true;


	public Admin(@NotBlank String name, 
            @NotBlank String password) {
    this.name = name;
    this.password = password;
    this.loggedIn = false;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Admin))
			return false;
		Admin user = (Admin) o;
		return Objects.equals(email, user.email) && Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email, password, loggedIn);

	}
	  @Override
	    public String toString() {
	        return "User{" +
	                "id=" + id +
	                ", name='" + email + '\'' +
	                ", password='" + password + '\'' +
	                ", loggedIn=" + loggedIn +
	                '}';
}
}
