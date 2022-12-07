package com.example.block7crudvalidation.teacher.infrastucture.dto;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DtoTeacherOutFull extends DtoTeacherOut {

    private Integer idPerson;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private Date createdDate;
    private String imageUrl;
    private Date terminationDate;

    public DtoTeacherOutFull(Teacher teacher) {
        super(teacher);
        setIdPerson(teacher.getPerson().getId_person());
        setUsername(teacher.getPerson().getUsername());
        setName(teacher.getPerson().getName());
        setSurname(teacher.getPerson().getSurname());
        setCompanyEmail(teacher.getPerson().getCompany_email());
        setPersonalEmail(teacher.getPerson().getPersonal_email());
        setCity(teacher.getPerson().getCity());
        setActive(teacher.getPerson().getActive());
        setCreatedDate(teacher.getPerson().getCreated_date());
        setImageUrl(teacher.getPerson().getImage_url());
        setTerminationDate(teacher.getPerson().getTermination_date());
    }
}
