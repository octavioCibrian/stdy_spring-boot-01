package com.restapi.stdy_spring_boot_01.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public record User(@Id Long id, String name, String email) {

}
