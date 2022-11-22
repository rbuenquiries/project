package com.rbu.logapp.log_audit_service.domain;

import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Getter
@Setter
public class Rbubusaudit {

    @Id
    private Long id;

    @NotNull
    @Size(max = 5000)
    private String description;
    
    @NotNull
    @Size(max = 10)
    private String problemtype;


    @CreatedDate
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    private OffsetDateTime lastUpdated;

    @Version
    private Integer version;

}
