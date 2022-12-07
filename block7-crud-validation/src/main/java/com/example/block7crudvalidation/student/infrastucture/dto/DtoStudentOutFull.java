package com.example.block7crudvalidation.student.infrastucture.dto;

import com.example.block7crudvalidation.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DtoStudentOutFull extends DtoStudentOut{

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

    public DtoStudentOutFull(Student student) {
        super(student);
        setIdPerson(student.getPerson().getId_person());
        setUsername(student.getPerson().getUsername());
        setName(student.getPerson().getName());
        setSurname(student.getPerson().getSurname());
        setCompanyEmail(student.getPerson().getCompany_email());
        setPersonalEmail(student.getPerson().getPersonal_email());
        setCity(student.getPerson().getCity());
        setActive(student.getPerson().getActive());
        setCreatedDate(student.getPerson().getCreated_date());
        setImageUrl(student.getPerson().getImage_url());
        setTerminationDate(student.getPerson().getTermination_date());
    }
}
