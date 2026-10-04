import java.util.Scanner;

public class WeightedQuickUnion{

    int id[];

    public WeightedQuickUnion(int n){
        id = new int[n]; //set the size of the array
        for (int i = 0; i < n; i++){
            id[i] = i; //populate the array with index values equal to passed value size
        }
    }

    public int find(int p){
        if (p < 0 || p >= id.length){ //outside of bounds check
            throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (id.length - 1));
        }
        while (p != id[p]){ //recrusively find the root of the element
            p = id[p];
        }
       return id[p]; // return the root of the element
    }

    public boolean connected(int p, int q){ //find both roots
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP < 0 || rootP >= id.length){ // outside of bounds check
            throw new IllegalArgumentException("Index " + rootP + " is not between 0 and " + (id.length - 1));
        }
        if (rootP != rootQ){ // if the roots are not equal, return false
            return false;
        }

        return rootP == rootQ; //else return true if the roots are equal
    }

    public void union(int p, int q){
        if (connected(p, q) == true){ //if already connected; return true
            return;
        }
        if (connected(p, q) == false){
            int rootP = find(p);
            int rootQ = find(q);
            id[rootP] = rootQ; //set the root of p to the root of q


        }

    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        WeightedQuickUnion wq = new WeightedQuickUnion(input.nextInt());
     

        System.out.println("What operation do you want to use? (union or connected or find)");
        System.out.println("type exit to exit the program");

        String operation = "";

        while (!operation.equals("exit")){
            operation = input.next();
            if (operation.equals("union")){
                System.out.println("Enter the first number");
                int p = input.nextInt();
                System.out.println("Enter the second number");
                int q = input.nextInt();
                wq.union(p, q);
            }

            if (operation.equals("connected")){
                System.out.println("Enter the first number");
                int p = input.nextInt();
                System.out.println("Enter the second number");
                int q = input.nextInt();
                System.out.println(wq.connected(p, q));
            }

            if (operation.equals("find")){
                System.out.println("Enter the number");
                int p = input.nextInt();
                System.out.println(wq.find(p));
            }

            if (operation.equals("exit")){
                input.close();
                System.exit(0);

        }        
    
    }
    
}
}