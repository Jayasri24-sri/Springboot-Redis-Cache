package com.example.cache.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order_details")
public class Order implements Serializable {
    @Id
    private String id;
    private String details;
    private int qty;
    private long price;
}
