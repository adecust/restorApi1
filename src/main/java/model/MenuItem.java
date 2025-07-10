package model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "menu_item")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer code;

    private String name;
    private String description;
    private String category;

    private double price;

    @Column(name = "is_available")
    private boolean isAvailable;

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
