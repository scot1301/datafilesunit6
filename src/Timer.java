import hsa.*;
public class Timer {

    static Console c;
    static int count=120;
    public static void main(String[] args) throws InterruptedException {
        c = new Console();
        char choice;
        c.print("Start timer? Y/N: ");
        choice = c.readChar();
        if(choice=='y'|| choice =='Y')timer();
        else c.close();
        
    }
    public static void timer() throws InterruptedException{
        c.println(count);
        while(true){
            count--;
            Thread.sleep(1000);
            c.println(count);
            if(count==0){
                c.println("Timer finished!");
                count=120;
                break;
            }
        }
    }
    
}
