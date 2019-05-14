import java.util.Scanner;

public class tongji {
    public static void countString(String str,char s) {
        int count = 0;
        while(str.indexOf(s) >= 0) {
            str = str.substring(str.indexOf(s)+1,str.length());
            count++;
        }
        System.out.println("此字符串有" + count + "个" + s);
    }
    public static void main(String[] args){
        System.out.println("请输入字符：");
        Scanner sc = new Scanner(System.in);
        String read = sc.nextLine();
        for(int i = 0; i < read.length(); i++){
            countString(read,read.charAt(i));
            read = read.replace(read.charAt(i) + "","" );
            i--;
        }
    }
}