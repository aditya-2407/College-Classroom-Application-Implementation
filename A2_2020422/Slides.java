import java.util.*;
class Slides {
    private String tos;
    private int nos;
    private ArrayList<String> con;
    private Date date;
    private String instr;

    Slides(String topic,int num,ArrayList<String> content,Date d,String in){   //contructor
        tos=topic;
        nos=num;
        con=content;
        date=d;
        instr=in;
    } 
    public String gettos(){
        return this.tos;
    }
    public int getnos(){
        return this.nos;
    }
    public ArrayList<String> getcon(){
        return this.con;
    }
    public Date getdate(){
        return this.date;
    }
    public String getinstr(){
        return this.instr;
    }
        
}
