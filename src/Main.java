import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[0];
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;
        System.out.println("""
                           
                          Welcome to the "Online Store".
                      (добро пожаловать в "Online Store".)
                          Use numbers for further actions.
                    (используйте цифры для дальнейших действий)
                             """);
        OuterLoop:
        while (true){
            System.out.println("""
                    1. Register
                    2. Get all users
                    3. Login
                    3. Exit
                    choice commands:
                   """);
            switch (scanner.nextLine().toLowerCase()){
                case "1", "register" -> {
                    User register = User.register(new User());
                    users = User.addUserToArray(users, register);
                    System.out.println("Successfully saved user!");
                }
                case "2" ->{
                    System.out.println(Arrays.toString(users));
                }
                case "3" ->{
                    User loginUser = User.login(users);
                    currentUser = loginUser;


                    InnerLoop:
                    while (true){
                        System.out.println("""
                                0. Logout
                                1. Add Product
                                2. Get All Products
                                3. Get All Book
                                4. Get All Device
                                5. Delete Product by Id
                                6. Delete Product by Ids
                                  """);
                        switch (scanner.nextLine().toLowerCase()){
                            case "0" -> {
                                break InnerLoop;
                            }
                            case "1" -> {
                                System.out.println("Book or Device");
                                switch (scanner.nextLine().toLowerCase()){
                                    case "book" -> {
                                        Book product = new Book();
                                        if (currentUser != null) {
                                            Product[] products = product.addNewProduct(currentUser.getProducts());
                                            currentUser.setProducts(products);
                                            System.out.println("Book added");
                                        }
                                    }
                                    case "device" ->{
                                        Device product = new Device();
                                        if(currentUser != null){
                                            Product[] products = product.addNewProduct(currentUser.getProducts());
                                            currentUser.setProducts(products);
                                            System.out.println("Davice added");
                                        }


                                    }
                                }
                            }
                            case "2" ->{
                              if(currentUser != null) Product.getAllProducts(currentUser.getProducts());
                            }
                            case "3" ->{
                                new Book().getProducts(currentUser.getProducts());
                            }
                            case "4" ->{
                                new Device().getProducts(currentUser.getProducts());
                            }
                            case "5" ->{
                                System.out.println("Enter id: ");
                                Product[] products = Product.deleteProduct(currentUser.getProducts(), scanner.nextLong());
                                currentUser.setProducts(products);
                                System.out.println("Success deleted");
                            }
                            case "6" ->{
                                System.out.println("Enter ids: ");
                                int length = scanner.nextInt();
                                long[] ids = new long[length];
                                for (int i = 0; i < length; i++) {

                                    ids[i] = scanner.nextLong();
                                }
                                Product[] newProducts = Product.deleteProduct(currentUser.getProducts(), ids);
                                currentUser.setProducts(newProducts);
                                System.out.println("Success deleted");

                            }


                        }

                    }
                }
                case "4" ->{
                    break OuterLoop;
                }
            }
        }
    }
}