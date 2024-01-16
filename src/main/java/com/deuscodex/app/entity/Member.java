package com.deuscodex.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "Member")
public class Member {

    @Id
    Long memberId;

    @NotNull
    String name;

    @NotNull
    String username;

    @NotNull
    String password;

    @Column(unique = true)
    @NotNull
    String email;

    String phoneNumber;

}
