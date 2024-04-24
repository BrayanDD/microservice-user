package com.example.user.adapters.driven.jpa.mysql.entity;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rol")
public class RoleEntity {

    @Id
    private Long id;
    private String name;
   
}
