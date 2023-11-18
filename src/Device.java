import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Device extends Product {
    private String brand;
    private String color;
    private boolean inNew;
    private String memory;
    private Product[] products;

    public Device(String name, String description, BigDecimal price, String brand, String color, boolean inNew, String memory) {
        super(name, description, price);
        this.brand = brand;
        this.color = color;
        this.inNew = inNew;
        this.memory = memory;
    }

    public Device() {

    }

    @Override
    public void getProducts(Product[] products) {
        for (Product product : products) {
            if(product instanceof Device device){
                System.out.println(device);
            }

        }
    }
    @Override
    public Product[] addNewProduct(Product[] products) {
        this.products = products;
        Scanner scanner = new Scanner(System.in);
        this.setId(MyGenerateId.generateId());
        System.out.println("Enter device name: ");
        this.setName(scanner.nextLine());
        System.out.println("Enter device description: ");
        this.setDescription(scanner.nextLine());
        System.out.println("Enter price: ");
        this.setPrice(new Scanner(System.in).nextBigDecimal());
        System.out.println("Enter brand: ");
        this.setBrand(scanner.nextLine());
        System.out.println("Enter color: ");
        this.setColor(scanner.nextLine());
        System.out.println("Enter is new 'true' or old 'false'");
        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equals("true")) {
                this.setInNew(true);
            } else if (userInput.equals("false")) {
                this.setInNew(false);
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
            break;
        }
        System.out.println("Enter memory");
        this.setMemory(scanner.nextLine());
        this.setCreatedAt(ZonedDateTime.now());

        Product[] newProductsArray = Arrays.copyOf(products, products.length + 1);
        newProductsArray[newProductsArray.length - 1] = this;

        return newProductsArray;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isInNew() {
        return inNew;
    }

    public void setInNew(boolean inNew) {
        this.inNew = inNew;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
}
