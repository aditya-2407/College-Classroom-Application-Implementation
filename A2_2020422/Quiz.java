class Quiz {
    private String q;
    private String answer;
    private String status;
    private String gb;
    Quiz(String ques){
        q=ques;
    }
    Quiz(String ques,String ans,String st,String g){
        q=ques;
        answer=ans;
        status=st;
        gb=g;
    }  
    public String getq(){
        return this.q;
    }
    public String getanswer(){
        return this.answer;
    }
    public String getstatus(){
        return this.status;
    }
    public void setstatus(String m){
        this.status=m;
    }
    public String getgb(){
        return this.gb;
    }
    public void setgb(String s){
        this.gb=s;
    }
}
