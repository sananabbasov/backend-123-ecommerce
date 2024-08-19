package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.dtos.product.ProductDealDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductDetailDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductHomeDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductRelatedDto;
import az.edu.itbrains.ecommerce.models.Product;
import az.edu.itbrains.ecommerce.repositories.ProductRepository;
import az.edu.itbrains.ecommerce.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductHomeDto> getHomeProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductHomeDto> result = products.stream().limit(3).map(x-> modelMapper.map(x,ProductHomeDto.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public ProductDetailDto getProductDetail(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductDetailDto result = modelMapper.map(product, ProductDetailDto.class);
        return result;
    }

    @Override
    public List<ProductRelatedDto> getRelatedProducts(Long id) {
        Product findProduct = productRepository.findById(id).orElseThrow();
        List<Product> products = productRepository.findByCategoryId(findProduct.getCategory().getId());
        List<ProductRelatedDto> result = products.stream().map(x-> modelMapper.map(x, ProductRelatedDto.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public ProductDealDto getProductDeal() {
        Product product = productRepository.findByFeaturedTrue();
        ProductDealDto result = modelMapper.map(product, ProductDealDto.class);
        float percent = result.getDiscountPrice() * 100 / result.getPrice();
        result.setDiscountPercent((float)Math.round(percent));
        return result;
    }

    private List<Product> getAllProducts(){
        List<Product> productList = new ArrayList<>();

//        // Add products to the list (Category 1: Fruits)
//        productList.add(new Product(1L, "Apple", 12.5F, "Apples are among the most popular fruits...", 100.00F, 1L));
//        productList.add(new Product(2L, "Banana", 8.0F, "Bananas are nutritious and convenient...", 150.00F, 1L));
//        productList.add(new Product(3L, "Orange", 15.0F, "Oranges are citrus fruits known for their refreshing taste...", 120.00F, 1L));
//        productList.add(new Product(4L, "Mango", 20.0F, "Mangoes are tropical fruits prized for their sweet, juicy flesh...", 80.00F, 1L));
//        productList.add(new Product(5L, "Grape", 18.0F, "Grapes are small, round fruits that come in various colors...", 200.00F, 1L));
//        productList.add(new Product(6L, "Strawberry", 22.0F, "Strawberries are bright red, juicy berries loved for their sweet flavor...", 90.00F, 1L));
//        productList.add(new Product(7L, "Kiwi", 25.0F, "Kiwis are small, fuzzy fruits with tangy green flesh and tiny black seeds...", 70.00F, 1L));
//        productList.add(new Product(8L, "Pineapple", 30.0F, "Pineapples are tropical fruits known for their sweet and tangy flavor...", 60.00F, 1L));
//        productList.add(new Product(9L, "Pear", 16.0F, "Pears are juicy fruits with a sweet and slightly grainy texture...", 120.00F, 1L));
//        productList.add(new Product(10L, "Cherry", 28.0F, "Cherries are small, round fruits with a bright red or dark purple color...", 80.00F, 1L));
//        productList.add(new Product(11L, "Plum", 18.0F, "Plums are sweet and juicy fruits with smooth skin and a stone inside...", 100.00F, 1L));
//        productList.add(new Product(12L, "Apricot", 24.0F, "Apricots are small, golden-orange fruits known for their velvety skin...", 90.00F, 1L));
//        productList.add(new Product(13L, "Raspberry", 32.0F, "Raspberries are small, delicate berries with a bright red or black color...", 70.00F, 1L));
//        productList.add(new Product(14L, "Blueberry", 36.0F, "Blueberries are small, round berries with a deep blue-purple color...", 60.00F, 1L));
//        productList.add(new Product(15L, "Blackberry", 30.0F, "Blackberries are juicy, dark purple berries known for their sweet-tart flavor...", 80.00F, 1L));
//        productList.add(new Product(16L, "Lemon", 8.0F, "Lemons are citrus fruits known for their tart flavor and bright yellow color...", 200.00F, 1L));
//        productList.add(new Product(17L, "Lime", 6.0F, "Limes are small, green citrus fruits with a tangy flavor and aromatic zest...", 180.00F, 1L));
//        productList.add(new Product(18L, "Grapefruit", 14.0F, "Grapefruits are citrus fruits known for their tart and slightly bitter taste...", 150.00F, 1L));
//        productList.add(new Product(19L, "Cranberry", 40.0F, "Cranberries are small, tart berries often associated with Thanksgiving...", 50.00F, 1L));
//        productList.add(new Product(20L, "Fig", 26.0F, "Figs are unique fruits with a soft, chewy texture and sweet flavor...", 85.00F, 1L));
//        productList.add(new Product(21L, "Papaya", 20.0F, "Papayas are tropical fruits with a sweet, orange flesh and edible seeds...", 110.00F, 1L));
//        productList.add(new Product(22L, "Lychee", 38.0F, "Lychees are small, exotic fruits with a rough, pink-red shell and juicy white flesh...", 75.00F, 1L));
//        productList.add(new Product(23L, "Passion Fruit", 34.0F, "Passion fruits are tropical fruits with a wrinkled purple or yellow skin...", 65.00F, 1L));
//        productList.add(new Product(24L, "Guava", 32.0F, "Guavas are tropical fruits with a fragrant aroma and sweet-tart flavor...", 70.00F, 1L));
//        productList.add(new Product(25L, "Dragon Fruit", 42.0F, "Dragon fruits, also known as pitayas, are exotic fruits with vibrant pink or yellow skin...", 55.00F, 1L));
//        productList.add(new Product(26L, "Persimmon", 28.0F, "Persimmons are sweet and flavorful fruits with a smooth, orange skin and jelly-like flesh...", 85.00F, 1L));
//        productList.add(new Product(27L, "Tangerine", 12.0F, "Tangerines are small, citrus fruits with bright orange skin and a sweet, tangy flavor...", 130.00F, 1L));
//        productList.add(new Product(28L, "Kiwano", 50.0F, "Kiwano, also known as horned melon, is an exotic fruit with spiky orange skin...", 40.00F, 1L));
//        productList.add(new Product(29L, "Rambutan", 36.0F, "Rambutan is a tropical fruit with a hairy red or yellow skin and sweet, juicy flesh...", 60.00F, 1L));
//        productList.add(new Product(30L, "Jackfruit", 24.0F, "Jackfruit is a large, tropical fruit with a spiky green or yellow exterior and sweet, fibrous flesh...", 90.00F, 1L));
//
//        // Add products to the list (Category 2: Berries)
//        productList.add(new Product(31L, "Blueberry", 36.0F, "Blueberries are small, round berries with a deep blue-purple color...", 60.00F, 2L));
//        productList.add(new Product(32L, "Blackberry", 30.0F, "Blackberries are juicy, dark purple berries known for their sweet-tart flavor...", 80.00F, 2L));
//        productList.add(new Product(33L, "Raspberry", 32.0F, "Raspberries are small, delicate berries with a bright red or black color...", 70.00F, 2L));
//        productList.add(new Product(34L, "Strawberry", 22.0F, "Strawberries are bright red, juicy berries loved for their sweet flavor...", 90.00F, 2L));
//        productList.add(new Product(35L, "Cherry", 28.0F, "Cherries are small, round fruits with a bright red or dark purple color...", 80.00F, 2L));
//        productList.add(new Product(36L, "Cranberry", 40.0F, "Cranberries are small, tart berries often associated with Thanksgiving...", 50.00F, 2L));
//        productList.add(new Product(37L, "Goji Berry", 45.0F, "Goji berries are small, red berries native to Asia...", 55.00F, 2L));
//        productList.add(new Product(38L, "Elderberry", 42.0F, "Elderberries are dark purple berries known for their tart flavor...", 60.00F, 2L));
//        productList.add(new Product(39L, "Boysenberry", 38.0F, "Boysenberries are large, dark purple berries with a sweet-tart flavor...", 65.00F, 2L));
//        productList.add(new Product(40L, "Huckleberry", 36.0F, "Huckleberries are small, dark purple berries with a sweet-tart flavor...", 70.00F, 2L));
//
//        // Add products to the list (Category 3: Citrus Fruits)
//        productList.add(new Product(41L, "Lemon", 8.0F, "Lemons are citrus fruits known for their tart flavor and bright yellow color...", 200.00F, 3L));
//        productList.add(new Product(42L, "Lime", 6.0F, "Limes are small, green citrus fruits with a tangy flavor and aromatic zest...", 180.00F, 3L));
//        productList.add(new Product(43L, "Orange", 15.0F, "Oranges are citrus fruits known for their refreshing taste...", 120.00F, 3L));
//        productList.add(new Product(44L, "Grapefruit", 14.0F, "Grapefruits are citrus fruits known for their tart and slightly bitter taste...", 150.00F, 3L));
//        productList.add(new Product(45L, "Tangerine", 12.0F, "Tangerines are small, citrus fruits with bright orange skin and a sweet, tangy flavor...", 130.00F, 3L));
//
//        // Add products to the list (Category 4: Tropical Fruits)
//        productList.add(new Product(46L, "Mango", 20.0F, "Mangoes are tropical fruits prized for their sweet, juicy flesh...", 80.00F, 4L));
//        productList.add(new Product(47L, "Pineapple", 30.0F, "Pineapples are tropical fruits known for their sweet and tangy flavor...", 60.00F, 4L));
//        productList.add(new Product(48L, "Papaya", 20.0F, "Papayas are tropical fruits with a sweet, orange flesh and edible seeds...", 110.00F, 4L));
//        productList.add(new Product(49L, "Guava", 32.0F, "Guavas are tropical fruits with a fragrant aroma and sweet-tart flavor...", 70.00F, 4L));
//        productList.add(new Product(50L, "Passion Fruit", 34.0F, "Passion fruits are tropical fruits with a wrinkled purple or yellow skin...", 65.00F, 4L));
//        productList.add(new Product(51L, "Lychee", 38.0F, "Lychees are small, exotic fruits with a rough, pink-red shell and juicy white flesh...", 75.00F, 4L));
//        productList.add(new Product(52L, "Dragon Fruit", 42.0F, "Dragon fruits, also known as pitayas, are exotic fruits with vibrant pink or yellow skin...", 55.00F, 4L));
//        productList.add(new Product(53L, "Jackfruit", 24.0F, "Jackfruit is a large, tropical fruit with a spiky green or yellow exterior and sweet, fibrous flesh...", 90.00F, 4L));
//
//        // Add products to the list (Category 5: Other Fruits)
//        productList.add(new Product(54L, "Apple", 12.5F, "Apples are among the most popular fruits...", 100.00F, 5L));
//        productList.add(new Product(55L, "Banana", 8.0F, "Bananas are nutritious and convenient...", 150.00F, 5L));
//        productList.add(new Product(56L, "Pear", 16.0F, "Pears are juicy fruits with a sweet and slightly grainy texture...", 120.00F, 5L));
//        productList.add(new Product(57L, "Apricot", 24.0F, "Apricots are small, golden-orange fruits known for their velvety skin...", 90.00F, 5L));
//        productList.add(new Product(58L, "Plum", 18.0F, "Plums are sweet and juicy fruits with smooth skin and a stone inside...", 100.00F, 5L));
//        productList.add(new Product(59L, "Fig", 26.0F, "Figs are unique fruits with a soft, chewy texture and sweet flavor...", 85.00F, 5L));
//        productList.add(new Product(60L, "Persimmon", 28.0F, "Persimmons are sweet and flavorful fruits with a smooth, orange skin and jelly-like flesh...", 85.00F, 5L));


        return  productList;
    }


}
