package com.asu.project.hospital.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.asu.project.hospital.entity.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class HospitalUserDetails implements UserDetails {
	
	private User user;
	private String username;
	private String password;
	private List<GrantedAuthority> authorityList;

	public HospitalUserDetails(User user) {
		this.username = user.getUserName();
		this.password = user.getPassword();
		this.authorityList = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorityList;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !user.isAccountLocked();
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
