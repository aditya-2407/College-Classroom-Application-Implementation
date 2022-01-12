import java.util.*;
class Lectures {
    private String topic;
    private String  file;
    private Date date;
    private String inst;
    Lectures(String top,String f,java.util.Date date2,String in){
        topic=top;
        file=f;
        date=date2;
        inst=in;
    }
    public String gettopic(){
        return this.topic;
    }
    public String getfile(){
        return this.file;
    }
    public Date getdate(){
        return this.date;
    }
    public String getinst(){
        return this.inst;
    }
}
