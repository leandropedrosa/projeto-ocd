package br.ufg.api.ocd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Document(collection = "role")
public class Role implements GrantedAuthority {

    public Role(String name) {
        this.name = name;
    }
    public Role() {
    }

    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private String name;

    @Override
    public String getAuthority() {
        return  this.name;
    }
}
