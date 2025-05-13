package com.tns.onlineshopping.applications;
import com.tns.onlineshopping.entities.Order;
import com.tns.onlineshopping.entities.Admin;
import com.tns.onlineshopping.entities.Customer;
import com.tns.onlineshopping.entities.Product;
import com.tns.onlineshopping.entities.ProductQuantityPair;
import com.tns.onlineshopping.services.AdminService;
import com.tns.onlineshopping.services.CustomerServices;
import com.tns.onlineshopping.services.OrderServices;
import com.tns.onlineshopping.services.ProductServices;
import java.util.Scanner;

public class OnlineShopping {

    private static ProductServices productServices = new ProductServices();
    private static CustomerServices customerServices = new CustomerServices();
    private static OrderServices orderServices = new OrderServices();
    private static AdminService adminService = new AdminService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    int adminChoice;
                    do {
                        System.out.println("\nAdmin Menu:");
                        System.out.println("1. Add Product");
                        System.out.println("2. Remove Product");
                        System.out.println("3. View Products");
                        System.out.println("4. Create Admin");
                        System.out.println("5. View Admins");
                        System.out.println("6. Update Order Status");
                        System.out.println("7. View Orders");
                        System.out.println("8. Return");
                        System.out.print("Choose an option: ");
                        adminChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (adminChoice) {
                            case 1:
                                addProduct(scanner);
                                break;
                            case 2:
                                removeProduct(scanner);
                                break;
                            case 3:
                                viewProducts();
                                break;
                            case 4:
                                createAdmin(scanner);
                                break;
                            case 5:
                                viewAdmins();
                                break;
                            case 6:
                                updateOrderStatus(scanner);
                                break;
                            case 7:
                                viewOrders(scanner);
                                break;
                            case 8:
                                System.out.println("Exiting Admin Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice! Please try again.");
                        }
                    } while (adminChoice != 8);
                    break;

                case 2: //Customer Module
                    int customerChoice;
                    do {
                        System.out.println("\nCustomer Menu:");
                        System.out.println("1. Create Customer");
                        System.out.println("2. View Customers");
                        System.out.println("3. Place Order");
                        System.out.println("4. View Orders");
                        System.out.println("5. View Products");
                        System.out.println("6. Return");
                        System.out.print("Choose an option: ");
                        customerChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (customerChoice) {
                            case 1:
                                createCustomer(scanner);
                                break;
                            case 2:
                                viewCustomers();
                                break;
                            case 3:
                                placeOrder(scanner);
                                break;
                            case 4:
                                viewOrders(scanner);
                                break;
                            case 5:
                                viewProducts();
                                break;
                            case 6:
                                System.out.println("Exiting Customer Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice! Please try again.");
                        }
                    } while (customerChoice != 6);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Stock Quantity: ");
        int stockQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = new Product(productId, name, price, stockQuantity);
        productServices.addProduct(product);
        System.out.println("Product added successfully!");
    }

    private static void removeProduct(Scanner scanner) {
        System.out.print("Enter Product ID to remove: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        productServices.removeProduct(productId);
        System.out.println("Product removed successfully!");
    }

    private static void viewProducts() {
        System.out.println("Products:");
        for (Product product : productServices.getProducts()) {
            System.out.println(product);
        }
    }

    private static void createAdmin(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Admin admin = new Admin(userId, username, email);
        adminService.addAdmin(admin);
        System.out.println("Admin created successfully!");
    }

    private static void viewAdmins() {
        System.out.println("Admins:");
        for (Admin admin : adminService.getAdmins()) {
            System.out.println("User ID: " + admin.getUserId() + ", Username: " + admin.getUsername() + ", Email: " + admin.getEmail());
        }
    }

    private static void updateOrderStatus(Scanner scanner) {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new Status (Completed/Delivered/Cancelled): ");
        String status = scanner.nextLine();
        orderServices.updateOrderStatus(orderId, status);
    }

    private static void createCustomer(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(userId, username, email, address);
        customerServices.addCustomer(customer);
        System.out.println("Customer created successfully!");
    }

    private static void viewCustomers() {
        System.out.println("Customers:");
        for (Customer customer : customerServices.getCustomers()) {
            System.out.println("User ID: " + customer.getUserId() + ", Username: " + customer.getUsername() + ", Email: " + customer.getEmail() + ", Address: " + customer.getAddress());
        }
    }

    private static void placeOrder(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Customer customer = customerServices.getCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        Order order = new Order(customerServices.getCustomer().size() + 1, customer);

        while (true) {
            System.out.print("Enter Product ID to add to order (or -1 to complete): ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (productId == -1) {
                break;
            }

            Product product = productServices.getProductById(productId);
            if (product == null) {
                System.out.println("Product not found!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            order.addProduct(new ProductQuantityPair(product, quantity));
        }

        orderServices.placeOrder(order);
        customer.addOrder(order);
        System.out.println("Order placed successfully!");
    }

    private static void viewOrders(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Customer customer = customerServices.getCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        System.out.println("Orders for Customer ID " + customerId + ":");
        for (Order order : customer.getOrders()) {
            System.out.println("Order ID: " + order.getOrderId() + ", Status: " + order.getStatus());
            for (ProductQuantityPair pair : order.getProducts()) {
                System.out.println("  Product: " + pair.getProduct().getName() + ", Quantity: " + pair.getQuantity());
            }
        }
    }
}