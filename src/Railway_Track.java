import java.util.*;
public class Railway_Track {
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
