import java.util.Scanner;

public class Number_Of_Count {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the total no of monkeys : ");
        int n=s.nextInt();
        System.out.println("Enter the no of eatable bananas by single monkey : ");
        int k=s.nextInt();
        System.out.println("Enter the no of eatable peanuts by single monkey : ");
        int j=s.nextInt();
        System.out.println("Total no of bananas : ");
        int m=s.nextInt();
        System.out.println("Total no of peanuts : ");
        int p=s.nextInt();
        int total=m/k;
        total+=p/j;
        int remb=m%k;
        int remp=p%k;
        while(remb>0&&remp>0){
            if((remb+remp)>=k+j)total++;
            else break;
            remb-=k;
            remp-=j;
        }
        if(j>p&&k>m){
            System.out.println("Invalid ");
            return;
        }
        System.out.print("Total monkeys stay in the tree are "+(n-total));
    }
}
