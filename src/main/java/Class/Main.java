package Class;

public class Main {
    public static void main(String[] args) {

        DataRetriever dr = new DataRetriever();

        System.out.println("=== All Categories ===");
        System.out.println(dr.getAllCategories());

        System.out.println("\n=== Pagination page=1 size=2 ===");
        System.out.println(dr.getProductList(1, 2));

        System.out.println("\n=== Filter by name 'Laptop' ===");
        System.out.println(dr.getProductsByCriteria("Laptop", null, null, null));

        System.out.println("\n=== Filter category 'Accessories' + pagination ===");
        System.out.println(dr.getProductsByCriteria(
                null, "Accessories",
                null, null,
                1, 1
        ));
    }
}
