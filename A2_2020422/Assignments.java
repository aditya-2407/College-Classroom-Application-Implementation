class Assignments {
    
    private String problem;
    private int mm;
    private String status="not graded";
    private String ans;
    private String gb;
    Assignments(String prob_stat,int max){
        problem=prob_stat;
        mm=max;
    }
    Assignments(String prob_stat,int max,String st,String answer,String g){
        problem=prob_stat;
        mm=max;
        status=st;
        ans=answer;
        gb=g;
    }
    public String getproblem(){
        return this.problem;
    }
    public int getmm(){
        return this.mm;
    }
    public String getstatus(){
        return this.status;
    }
    public void setstatus(String s){
        this.status=s;
    }
    public String getans(){
        return this.ans;
    }
    public String getgb(){
        return this.gb;
    }
    public String setgb(String s){
        this.gb=s;
        return this.gb;
    }
}
