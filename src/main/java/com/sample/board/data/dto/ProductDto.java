package com.sample.board.data.dto;

import com.sample.board.data.entity.Product;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {

  //@Size(min = 8, max = 8) // abcdefg
  @NotNull
  private String productId;

  @NotNull
  @Id
  private String productName;

  @NotNull
  @Min(value = 500)
  @Max(value = 3000000)
  private int productPrice;

  @NotNull
  @Min(value = 0)
  @Max(value = 9999)
  private int productStock;

  public Product toEntity(){
    return Product.builder()
        .id(productId)
        .name(productName)
        .price(productPrice)
        .stock(productStock)
        .build();
  }

}
