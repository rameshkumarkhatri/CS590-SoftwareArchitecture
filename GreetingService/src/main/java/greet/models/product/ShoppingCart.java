package greet.models.product;

import java.util.List;
import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ShoppingCart {
	
	@Id
	ObjectId id;
	
	List<OrderLine> orderDetail = new ArrayList<>();
}
