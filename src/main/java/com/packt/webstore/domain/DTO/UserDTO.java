package com.packt.webstore.domain.DTO;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.packt.webstore.validator.Username;
public class UserDTO {
	
		@Email
		@NotBlank(message="{notNull.user.username.validation}")
		@Username
		private String username;
		@NotBlank(message="{notNull.user.password.validation}")
		@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", message="{pattern.user.password.validation}")
		private String password;
		@NotBlank(message="{notNull.user.confirmPassword.validation}")
		private String confirmPassword;
	
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		
}
