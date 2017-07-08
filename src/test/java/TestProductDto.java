import com.web.dto.ProductDto;
import com.web.entity.Product;

import java.util.List;

/**
 * Created by Mew on 2017/7/8.
 */
public class TestProductDto {
    public static void main(String[] args) {
        ProductDto productDto = new ProductDto();
        List<Product> productList = productDto.getProductList();
        for (Product product : productList
                ) {
            System.out.println(product.getIsBuy() + ":" + product.getIsSell() + ":" + product.getTitle()+" "+ product.getPic());
        }
    }
}
