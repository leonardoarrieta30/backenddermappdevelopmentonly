package com.DermApp.Backend.diagnostic.domain.model.entity;

import com.DermApp.Backend.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "chats")
public class Chat extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transmitter;
    private String receiver;


    @Size(max = 400)
    private String message;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dermatologist_id", referencedColumnName = "id")
    private Dermatologist dermatologist;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;


}
