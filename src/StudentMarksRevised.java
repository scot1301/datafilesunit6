import hsa.*;
import java.util.StringTokenizer;
import processing.core.PApplet;

public class StudentMarksRevised {

    public static Console c;
    public static PApplet pa;
    public static String data[] = new String[20];
    public static String names[] = new String[20];
    static int marks[][] = new int[20][20];
    public static int choice;
    public static void main(String args[])
    {
        c = new Console();
        pa = new PApplet();
        data = pa.loadStrings("StuMarRev.txt");
        for(int x =0; x<20; x++){
             StringTokenizer st = new StringTokenizer(data[x],",");
             names[x] = st.nextToken();
             for(int y =0; y<4; y++){
                 marks[x][y] = Integer.parseInt(st.nextToken().trim());
             }
        }
        setup();
        
        
    }
    public static void setup(){
        while(true){
            drawMenu();
            choice = c.readInt();
            if(choice==0)break;
            else if(choice >20)c.println("Invalid choice");
            else{
                choice--;
                c.println("The average for " + names[choice] + " is " + getAvg(choice));
            }
            pause();
            
        }
        System.exit(0);
    }
    public static void drawMenu(){
        c.println("Enter a student to see their average: ");
        for(int x=0; x<20; x++){
            c.println((x+1) + ": " + names[x]);
        }
        c.print("\nEnter your choice, 1-20 or 0 to exit: ");
    }
    public static float getAvg(int choice){
        float total=0;
        for(int x=0; x<=3;x++){
            total+=marks[choice][x];
        }
        return total/20;
    }
    public static void pause(){
        c.println("\nPress any key to continue.");
        c.getChar();
        c.clear();
    }
}
