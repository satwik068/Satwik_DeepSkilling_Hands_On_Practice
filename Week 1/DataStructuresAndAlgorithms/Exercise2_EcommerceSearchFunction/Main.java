public class Main {
    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mobile", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Book", "Education")
        };

        int searchId = 104;

        Product linearResult = SearchEngine.linearSearch(products, searchId);

        if (linearResult != null) {
            System.out.println("Linear Search Result:");
            System.out.println("Product ID: " + linearResult.getProductId());
            System.out.println("Product Name: " + linearResult.getProductName());
            System.out.println("Category: " + linearResult.getCategory());
        } else {
            System.out.println("Product not found using Linear Search");
        }

        Product binaryResult = SearchEngine.binarySearch(products, searchId);

        if (binaryResult != null) {
            System.out.println("\nBinary Search Result:");
            System.out.println("Product ID: " + binaryResult.getProductId());
            System.out.println("Product Name: " + binaryResult.getProductName());
            System.out.println("Category: " + binaryResult.getCategory());
        } else {
            System.out.println("Product not found using Binary Search");
        }
    }
}