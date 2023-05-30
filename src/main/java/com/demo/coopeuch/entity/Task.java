package com.demo.coopeuch.entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
public class Task {

    @NotBlank(message = "ID de la tarea")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La descripción es obligatoria")
    @Schema(description = "Descripción.")
    private String description;

    @NotBlank(message = "La fecha de creación es obligatoria")
    @Schema(description = "Fecha de creación.")
    private Date creationDate;

    @NotBlank(message = "Estado de la tarea")
    @Schema(description = "Estado de la tarea.")
    private boolean active;

    @PrePersist
    protected void setCreationDate() {
        this.creationDate = new Date();
    }
}

