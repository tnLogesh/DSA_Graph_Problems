/** You are working as a data security analyst in a cyber-surveillance unit.
Your system receives encoded messages from agents in the field.
These messages contain a hidden code word that follows a specific rule
The hidden code word is the longest substring of the message that:
Starts and ends with the same letter (case-insensitive).
Contains at least one vowel (a, e, i, o, u).
Does not contain any digit.
If there are multiple substrings with the same length, choose the lexicographically smallest one.
If no such substring exists, return "NO CODE".
Test case 01
message = "abxbae"
Output: abxba
Test case 02
message = "xy123z"
Output: NO CODE
Test case 03 :
message = "momentsareawesome"
Output: momentsareawesom */

import java.util.Scanner;
public class Decode {
    static boolean validString(String str){
        int n=str.length();
        int c=0;
        int v=0;
        if(str.charAt(0)==str.charAt(n-1)){
            for(int i=0;i<n;i++){
                char ch=str.charAt(i);
                if(ch>='0'&&ch<='9'){
                    c++;
                }
                else if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                    v++;
                }
            }
            if(v>0&&c==0)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        int n=str.length();
        String abc="";
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                String st=str.substring(i,j);
                if(validString(st)){
                    if(abc.length()<st.length())abc=st;
                }
            }
        }
        System.out.println(abc);
    }
}
