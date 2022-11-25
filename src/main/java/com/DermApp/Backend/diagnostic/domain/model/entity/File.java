package com.DermApp.Backend.diagnostic.domain.model.entity;

import com.DermApp.Backend.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "files")
public class File extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(max = 400)
    private String urlToImage;

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER, mappedBy = "file")
//    //a file can be in many patients
//    private Set<Patient> patients = new HashSet<>();


}
