package com.api.ticket.grahpql.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name="user")
    @ManyToOne(fetch=FetchType.LAZY,targetEntity = Users.class,cascade = CascadeType.MERGE)
    private Users user;
    @Column(name="creation_date")
    private LocalDateTime creationDate;
    @Column(name="update_date")
    private LocalDateTime updateDate;
    private String status;
    private String description;
    private String solution;



}
