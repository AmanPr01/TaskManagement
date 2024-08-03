package dev.aman.taskmanagementsystem.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Attachment extends BaseModel {

    private String fileName;
    private String fileType;
}
