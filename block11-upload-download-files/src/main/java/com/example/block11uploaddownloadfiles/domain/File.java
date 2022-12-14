package com.example.block11uploaddownloadfiles.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@Table
@NoArgsConstructor
public class File implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_file;

    @Column
    private String filename;

    @Column
    private Date uploadDate;

    @Column
    private String type;

    @Lob
    private byte[] data;

    public void addDate(){
        Calendar actualCalendar = Calendar.getInstance();
        Date uploadDate = actualCalendar.getTime();
        setUploadDate(uploadDate);
    }
}
