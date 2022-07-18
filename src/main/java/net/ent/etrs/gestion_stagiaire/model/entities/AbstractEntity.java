package net.ent.etrs.gestion_stagiaire.model.entities;


import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class AbstractEntity /*extends AbstractAuditable<User, Long>*/ implements Serializable {
    // annotation lombok
    @Getter
    // annotations JPA
    protected Long id;

//    @Column(name = "UUID")
//    protected String uuid = UUID.randomUUID().toString();

    private String createdByUser;

    private String modifiedByUser;

    private LocalDate createdDate;

    private LocalDate modifiedDate;


}
