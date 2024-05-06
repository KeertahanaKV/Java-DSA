mport java.util.*;

class ArrayListExample {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("User Input to ArrayList");
        System.out.println("How many numbers do you want to add: ");
        int n = sc.nextInt();
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        System.out.println("ArrayList: " + list);
        System.out.println("1. Add a Number\n2. Remove a Number\n3. Get an element\n4. Replace an element\n5. Check if element is present\n6. Sort the ArrayList\n7. Exit");
        while (true) {
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the element:");
                    int a = sc.nextInt();
                    list.add(a);
                    System.out.println("Updated ArrayList: " + list);
                    break;
                case 2:
                    System.out.println("Enter the index of element to remove:");
                    int index = sc.nextInt();
                    if (index >= 0 && index < list.size()) {
                        list.remove(index);
                        System.out.println("Updated ArrayList: " + list);
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 3:
                    System.out.print("Enter the index of element:");
                    index = sc.nextInt();
                    if (index >= 0 && index < list.size()) {
                        System.out.println("Element at index " + index + ": " + list.get(index));
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Enter index of element to replace:");
                        int d = sc.nextInt();
                        System.out.print("Enter new element:");
                        int e = sc.nextInt();
                        list.set(d, e);
                        System.out.println("Updated ArrayList: " + list);
                    } catch (Exception e) {
                        System.out.println("Invalid Index");
                    }
                    break;
                case 5:
                    System.out.println("Enter the element:");
                    int f = sc.nextInt();
                    System.out.println("ArrayList contains " + f + ": " + list.contains(f));
                    break;
                case 6:
                    Collections.sort(list);
                    System.out.println("Sorted ArrayList: " + list);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
