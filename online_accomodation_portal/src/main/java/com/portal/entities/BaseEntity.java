package com.portal.entities;

import javax.persistence.GeneratedValue;


import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;


@MappedSuperclass 
@Getter
@Setter
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	public Long getId()
	{
		return id ;
	}
	
}


