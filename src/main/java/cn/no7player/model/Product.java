package cn.no7player.model;

import lombok.*;

import java.math.BigDecimal;

/**
 * Created by ethan on 2015/8/27.
 */
@Getter
@Setter
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Product {
    private String name;
    private BigDecimal price;
    private String describtion;

}
