package br.com.alura.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.*;
import lombok.Data;


import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@UserDefinition
public class Usuario extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    @Username
    private String username;
    @Password
    private String password;
    @Roles
    private String role;

    @JsonbTransient
    public String getPassword() {
        return password;
    }
    @JsonbTransient
    public Integer getId() {return id;}

    public static void incluir(Usuario usuario){
        usuario.password = BcryptUtil.bcryptHash(usuario.password);
        usuario.role = validarUsername(usuario.username);
        usuario.persist();
    }

    public static String validarUsername(String userName){
        if(userName.equals("alura")) {
            return "admin";
        }
        return "user";
    }
}
