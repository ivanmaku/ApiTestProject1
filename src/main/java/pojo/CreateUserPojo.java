package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter @Setter
public class CreateUserPojo {

    private int code;
    private Object meta;
    public Map<String,Object> data;
}


