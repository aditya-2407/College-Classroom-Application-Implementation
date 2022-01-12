import java.util.*;

class Student extends Instructor implements Common{
    private ArrayList<Assignments> assignments_obj=new ArrayList<Assignments>();
    private ArrayList<Quiz> quiz_obj=new ArrayList<Quiz>();
    private ArrayList<Assignments> submit_assignments_obj=new ArrayList<Assignments>();
    private ArrayList<Quiz> submit_quiz_obj=new ArrayList<Quiz>();
    private String di;

    public ArrayList<Assignments> getassignments_obj(){
        return this.assignments_obj;
    }

    public ArrayList<Quiz> getquiz_obj(){
        return this.quiz_obj;
    }

    public ArrayList<Assignments> getsubmit_assignments_obj(){
        return this.submit_assignments_obj;
    }

    public ArrayList<Quiz> getsubmit_quiz_obj(){
        return this.submit_quiz_obj;
    }

    public String getdi(){
        return this.di;
    }

    Student(String identity) {
        super();
        di=identity;
    }   
    void submit_assessment(){
        if(assignments_obj.size()+quiz_obj.size()==0){
            System.out.println("No pending assessments");
        }
        else{
            System.out.println("Pending assessments");
            int k=0;
            for(int i=0;i<assignments_obj.size();i++){
                System.out.println("ID: "+k+" Assignment: "+assignments_obj.get(i).getproblem()+" Max Marks: "+assignments_obj.get(i).getmm());
                k++;
            }
            for(int i=0;i<quiz_obj.size();i++){
                System.out.println("ID: "+k+" Question: "+quiz_obj.get(i).getq());
                k++;
            }
            System.out.print("Enter ID of assessment: ");
            int id=sc.nextInt();
            sc.nextLine();
            int flag=0;
            if(id>assignments_obj.size()-1){
                flag=id-assignments_obj.size();
            }
            if(id<=assignments_obj.size()-1){
                System.out.print("Enter filename of assignment: ");
                String str=sc.nextLine();
                if(!str.substring(str.length()-4).equals(".zip")){
                    System.out.println("Invalid file format. Try submitting again.");
                    return;
                }
                else{
                    submit_assignments_obj.add(new Assignments(assignments_obj.get(id).getproblem(), assignments_obj.get(id).getmm(),"not graded",str,"not yet"));
                    assignments_obj.remove(id);
                }
            }
            else{
                System.out.print(quiz_obj.get(flag).getq());
                String str=sc.nextLine();
                submit_quiz_obj.add(new Quiz(quiz_obj.get(flag).getq(),str,"not graded","not yet"));
                quiz_obj.remove(flag);
            }
        }
    }
    @Override
    public void view_lecture_slides(){
        Instructor obj=new Instructor();
        for(int i=0;i<getslides_obj().size();i++){
            System.out.print("Title: "+getslides_obj().get(i).gettos()+"\n");
            for(int j=0;j<getslides_obj().get(i).getcon().size();j++){
                System.out.println("Slide "+(j+1)+": "+getslides_obj().get(i).getcon().get(j));
            }
            System.out.println("Number of slides: "+getslides_obj().get(i).getnos());
            System.out.println("Date of upload: "+getslides_obj().get(i).getdate());
            System.out.println("Uploaded by: "+getslides_obj().get(i).getinstr());

        }
    }
    @Override
    public void add_comments(ArrayList<Comments> comm,String id){
        System.out.print("Enter comment: ");
        String com=sc.nextLine();
        comm.add(new Comments(com,id,new Date()));
    }
    
}