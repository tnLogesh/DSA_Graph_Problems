///*Question 2 :
//
//The Indian Railway Network is planning to lay down new train tracks between cities to form a minimum cost railway network that connects all the cities directly or indirectly, avoiding any circular connections (i.e., loops).
//
//You are given a list of cities, and the cost to build a train track between each pair of cities.
//
//As a railway planner, your job is to select the train tracks to be laid down so that:
//
//All cities are connected (directly or indirectly)
//
//The total cost is minimum
//
//No circular paths (i.e., no cycle) should be formed
//
//Use Kruskal's Algorithm to find the Minimum Spanning Tree (MST) and print the selected tracks and total cost.
//
//Test Case 01 :
//
//Cities = [A, B, C, D]
//Tracks and Costs:
//A-B = 1
//A-C = 3
//B-C = 2
//B-D = 4
//C-D = 5
//
//Selected Tracks in MST:
//
//A-B (1)
//B-C (2)
//B-D (4)
//
//Total Minimum Cost = 7
//
//Test Case 02 :
//
//Cities = [P, Q, R, S, T]
//
//
//Tracks and Costs:
//
//P-Q = 6
//P-R = 1
//Q-R = 5
//Q-S = 3
//R-S = 5
//S-T = 2
//R-T = 4
//
//Selected Tracks in MST:
//
//P-R (1)
//S-T (2)
//Q-S (3)
//R-T (4)
//
//Total Minimum Cost = 10
//*/
import java.util.*;
public class Indian_Railway {
    static class Edges{
        int w,p,v;
        Edges(int p,int v,int w){
            this.v=v;
            this.p=p;
            this.w=w;
        }
    }
    public static void main(String[] args) {
        int V=5;
        List<List<int[]>>l=new ArrayList<>();
        for(int i=0;i<V;i++){
            l.add(new ArrayList<>());
        }
        l.get(0).add(new int[]{1,2});
        l.get(1).add(new int[]{0,2});
        l.get(0).add(new int[]{2,3});
        l.get(2).add(new int[]{0,3});
        l.get(1).add(new int[]{2,1});
        l.get(2).add(new int[]{1,1});
        l.get(1).add(new int[]{3,4});
        l.get(3).add(new int[]{1,4});
        l.get(2).add(new int[]{3,5});
        l.get(3).add(new int[]{2,5});
        l.get(2).add(new int[]{4,6});
        l.get(4).add(new int[]{2,6});
        l.get(3).add(new int[]{4,7});
        l.get(4).add(new int[]{3,7});
        prims(l);
    }
    static void prims(List<List<int[]>>l){
        boolean[]visited=new boolean[l.size()];
        Queue<Edges>q=new PriorityQueue<>(Comparator.comparingInt(a->a.w));
        q.add(new Edges(0,-1,0));
        System.out.println("Edges of MST");
        int minPath=0;
        while(!q.isEmpty()){
            //System.out.println("null");
            Edges cur=q.poll();
            if(visited[cur.p]==true)continue;
            visited[cur.p]=true;
            if(cur.v!=-1){
                System.out.println((char)(cur.v+65)+" -> "+(char)(cur.p+65)+" - "+cur.w);
                minPath+=cur.w;
            }
            for(int[] i:l.get(cur.p)){
                if(!visited[i[0]]){
                    q.offer(new Edges(i[0],cur.p,i[1]));
                }
            }
        }
        System.out.println(minPath);
    }
}
