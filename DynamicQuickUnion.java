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
       return id[p];

    }

    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
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
    }

}