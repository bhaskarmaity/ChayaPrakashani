package com.example.indusnetprj.chayaprakashani.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.indusnetprj.chayaprakashani.entity.StudentDetails;

public class CustomUserDetails extends StudentDetails implements UserDetails{
	
	public CustomUserDetails(final StudentDetails users) {
        super(users);
    }
	
	private List<GrantedAuthority> authority;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(super.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());			
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
