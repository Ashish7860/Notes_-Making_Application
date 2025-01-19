package com.nagarro.Note_Maker_Backend.entity;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Data;
import lombok.ToString;

	@Data // used for lomboke
	@ToString
	@MappedSuperclass
	@EntityListeners(AuditingEntityListener.class)
	public class Audit {


}	