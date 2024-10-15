package kf.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Setter
public class Payment {
    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;
}
