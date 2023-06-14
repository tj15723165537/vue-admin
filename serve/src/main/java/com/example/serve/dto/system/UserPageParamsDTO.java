package com.example.serve.dto.system;

import com.example.serve.utils.PageQuery;
import lombok.Data;

@Data
public class UserSearchDTO extends PageQuery {

    private String account;

    private String status;

}
