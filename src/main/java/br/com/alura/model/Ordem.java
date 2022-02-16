package br.com.alura.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;
    private Double preco;
    private String tipo;
    private Date data;
    private String status;
    @Column(name = "user_id")
    private Integer userId;
}
