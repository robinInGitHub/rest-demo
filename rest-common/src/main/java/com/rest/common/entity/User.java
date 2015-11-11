package com.rest.common.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@javax.persistence.Entity
public class User implements Entity, UserDetails
{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = -8777788123761983221L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, length = 16, nullable = false)
	private String name;

	@Column(length = 80, nullable = false)
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> roles = new HashSet<String>();


	protected User()
	{
		/* Reflection instantiation */
	}


	public User(String name, String passwordHash)
	{
		this.name = name;
		this.password = passwordHash;
	}


	public Long getId()
	{
		return this.id;
	}


	public void setId(Long id)
	{
		this.id = id;
	}


	public String getName()
	{
		return this.name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public Set<String> getRoles()
	{
		return this.roles;
	}


	public void setRoles(Set<String> roles)
	{
		this.roles = roles;
	}


	public void addRole(String role)
	{
		this.roles.add(role);
	}


	public String getPassword()
	{
		return this.password;
	}


	public void setPassword(String password)
	{
		this.password = password;
	}


	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		Set<String> roles = this.getRoles();

		if (roles == null) {
			return Collections.emptyList();
		}

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}

		return authorities;
	}


	public String getUsername()
	{
		return this.name;
	}


	public boolean isAccountNonExpired()
	{
		return true;
	}


	public boolean isAccountNonLocked()
	{
		return true;
	}


	public boolean isCredentialsNonExpired()
	{
		return true;
	}


	public boolean isEnabled()
	{
		return true;
	}

}