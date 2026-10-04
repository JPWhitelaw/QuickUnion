import java.util.Scanner;

public class DynamicQuickUnion{

    int id[];

    public DynamicQuickUnion(int n){
        id = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    public int find(int p){
        if (p < 0 || p >= id.length){
            throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (id.length - 1));
        }
       return id[p];

    }

    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP < 0 || rootP >= id.length){
            throw new IllegalArgumentException("Index " + rootP + " is not between 0 and " + (id.length - 1));
        }
        if (rootP != rootQ){
            return false;
        }

        return rootP == rootQ;
    }

    public void union(int p, int q){
        if (connected(p, q) == true){
            return;
        }
        if (connected(p, q) == false){
            int rootP = find(p);
            int rootQ = find(q);
            id[rootP] = rootQ;

        }

    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        DynamicQuickUnion dq = new DynamicQuickUnion(input.nextInt());
        input.close();

        System.out.println("What operation do you want to use? (union or connected or find)");
        
    }

}