package model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Table(name = "restaurant")
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "restaurant_location")
    private String restaurantLocation;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("restaurant-category")
    private List<Category> categories;



    public void setCategories(List<Category> categories) {
        this.categories = categories;
        if (categories != null) {
            for (Category category : categories) {
                category.setRestaurant(this); // restaurant_id foreign key bağlantısı
            }
        }
    }
}
