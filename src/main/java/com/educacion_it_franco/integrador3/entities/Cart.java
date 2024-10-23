package com.educacion_it_franco.integrador3.entities;
import com.educacion_it_franco.integrador3.entities.CartItem;
import com.educacion_it_franco.integrador3.entities.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    public List<CartItem> items = new ArrayList<>();

    double total;
}
