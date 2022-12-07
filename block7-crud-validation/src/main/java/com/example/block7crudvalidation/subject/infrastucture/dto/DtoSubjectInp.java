package com.example.block7crudvalidation.subject.infrastucture.dto;


import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
public class DtoSubjectInp implements Serializable {

    @NotEmpty(message = "El id del estudiante no puede ser nulo")
    private Integer id_student;
    private Integer id_teacher;
    private String subject;
    private String comments;
    private Date initial_date;
    private Date finish_date;

}
