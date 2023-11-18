import java.util.Arrays;
import java.util.Scanner;

public class User extends Product {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Product[] products = new Product[0];

    public User() {
    }

    @Override
    public Product[] addNewProduct(Product[] products) {
        return new Product[0];
    }

    @Override
    public void getProducts(Product[] products) {

    }

    public User(String firstName, String lastName, String email, String password, Product[] products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.products = products;
    }

    public static User[] addUserToArray(User[] users, User registerUser) {
        User[] newArray = Arrays.copyOf(users, users.length + 1);
        newArray[newArray.length - 1] = registerUser;
        return newArray;
    }

    public static User login(User[] users) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Succes login! ");
                return user;
            } else {
                System.err.println("Invalid login and password!");

            }
        }
        return login(users);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public static User register(User newUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name: ");
        newUser.setFirstName(scanner.nextLine());
        System.out.println("Enter last name: ");
        newUser.setLastName(scanner.nextLine());
        while (true){
            System.out.println("Enter email: ");
            String email = scanner.nextLine();
            if (email.endsWith("@gmail.com")){
                newUser.setEmail(email);
                break;
            }else System.err.println("Логин должен содержать '@gmail.com'. Повторите попытку");
        }
        while (true){
            System.out.println("Enter password: ");
            String pass = scanner.nextLine();
            if (pass.length() >= 4){
                newUser.setPassword(pass);
                break;
            }else System.err.println("Password должен состоит не менее 4 элемента:");

        }
        return newUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
