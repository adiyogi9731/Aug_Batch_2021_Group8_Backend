package com.tbp.crud.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {
    private int req_id;
    private int emp_id;
    private String furniture;
    private String it_equip;
    private Date delivery_date;
    private String email;
}
