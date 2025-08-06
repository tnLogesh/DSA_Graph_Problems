import java.util.*;
//class Node{
//
////    void addEdges(char s,char e){
////        m.get(s).add(e);
////        m.get(e).add(s);
public class Network_cables {
    static  Map<Character,List<Character>>m=new HashMap<>();
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        //int v=s.nextInt();
        while(true){
            char ch1=s.next().charAt(0);
            if(ch1=='0'){
                break;
            }
            char ch2=s.next().charAt(0);
            if(!m.containsKey(ch1)){
                m.put(ch1,new ArrayList<>());
                m.get(ch1).add(ch2);
            }
            else{
                m.get(ch1).add(ch2);
            }
            if(!m.containsKey(ch2)){
                m.put(ch2,new ArrayList<>());
                m.get(ch2).add(ch1);
            }
            else{
                m.get(ch2).add(ch1);
            }
            //g.addEdges(ch1,ch2);
        }
        char start=s.next().charAt(0);
        bfs(start);
    }
    static void bfs(char start){
        Queue<Character>q=new LinkedList<>();
        Map<Character,Boolean>mp=new HashMap<>();
        for(Map.Entry<Character,List<Character>>l:m.entrySet()){
            mp.put(l.getKey(),false);
        }
        mp.put(start,true);
        q.add(start);
        while(!q.isEmpty()){
            char ch=q.poll();
            System.out.print(ch+" ");
            mp.put(ch,true);
            for(Character l:m.get(ch)){
                if(mp.get(l)==false){
                    q.add(l);
                    mp.put(l,true);
                }
            }
        }
    }
}
