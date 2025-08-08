import java.util.*;

/**A warehouse stores products in multiple bins arranged in a single row. Each bin contains a certain number of items.
The warehouse receives daily order requests, and for each order, workers have to pick consecutive bins so that the total number
of items picked exactly matches the order quantity.

However, due to restrictions:

Workers cannot pick from more than K bins for a single order.

Workers must choose bins in their current order (no reordering allowed).

If multiple sets of bins satisfy the order, choose the one with the smallest starting bin index.

Your task is to find the start and end index of the bins from which the workers should pick items for each order.
If it is not possible to fulfill the order under these constraints, return -1 -1.

Test case 01

bins = [5, 2, 7, 3, 1, 5, 2]
orderQuantity = 8
K = 3
Output: 5 7


Test case 02

bins = [1, 2, 3, 4, 5]
orderQuantity = 9
K = 2
Output: 4 5

Test Case 03:

bins = [4, 4, 4, 4]
orderQuantity = 8
K = 2
Output: 1 2 **/

//pattern used : Sliding Window

public class Warehouse {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter no of bins : ");
        int n=s.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        System.out.println("Enter the order quantity : ");
        int oq=s.nextInt();
        System.out.println("Enter the bin size : ");
        int k=s.nextInt();
        for(int i=0;i<=n-k;i++){
            int sum=0;
            for(int j=i;j<k+i;j++){
                sum+=arr[j];
            }
            if(sum==oq){
                System.out.print((i+1)+" "+(k+i));
                return;
            }
        }
        System.out.println("-1 -1");
    }
}
