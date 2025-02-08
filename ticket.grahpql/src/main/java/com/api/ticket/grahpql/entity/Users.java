package com.api.ticket.grahpql.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {

    @Id
    @Column(name="document_number")
    private Long documentNumber;
    @Column(name="first_name")
    private String firstName;
    @Column(name="second_name")
    private String secondName;
    @Column(name="last_Name")
    private String lastName;
    private String email;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,targetEntity = Ticket.class)
    private List<Ticket> tickets;
}
