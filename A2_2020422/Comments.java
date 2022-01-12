import java.util.*;
public class Comments {
    private String comment;
    private String id;
    private Date d;
    Comments(String com,String s,Date date){
        comment=com;
        id=s;
        d=date;
    }

    public String getcomment(){
        return this.comment;
    }

    public String getid(){
        return this.id;
    }

    public Date getd(){
        return this.d;
    }
}
