public class DynamicQuickUnion{


    public static int find(int p){
       int id[]  = new int[p];
       for (int i = 0; i < p; i++){
           id[i] = i;
       }
       return id[p];

    }

    public static boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public static void union(int p, int q){}

    public static void main(String[] args){}

}