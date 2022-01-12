import java.util.*;

interface Ins_int{
    void add_class_material(String id);
    void add_assessments(ArrayList<Student> stu_obj,ArrayList<Assignments> an,ArrayList<Quiz> qu);
}

interface Common{
    void add_comments(ArrayList<Comments> comm,String id);
    void view_lecture_slides();
    void view_lecture_videos();
    int view_assessments();
}

class Instructor implements Common,Ins_int{
    private ArrayList<Slides> slides_obj=new ArrayList<Slides>();
    private ArrayList<Lectures> lec_obj=new ArrayList<Lectures>();
    private ArrayList<Assignments> ass_obj=new ArrayList<Assignments>();
    private ArrayList<Quiz> q_obj=new ArrayList<Quiz>();
    private ArrayList<Comments> com_obj=new ArrayList<Comments>();
    Scanner sc=new Scanner(System.in);
    private String ids;
    Instructor(String str){
        ids=str;
    }
    Instructor(){}

    public ArrayList<Slides> getslides_obj(){
        return this.slides_obj;
    }

    public ArrayList<Lectures> getlec_obj(){
        return this.lec_obj;
    }

    public ArrayList<Assignments> getass_obj(){
        return this.ass_obj;
    }

    public ArrayList<Quiz> getq_obj(){
        return this.q_obj;
    }

    public ArrayList<Comments> getcom_obj(){
        return this.com_obj;
    }

    public String getids(){
        return this.ids;
    }
    @Override
    public void add_class_material(String id){
        System.out.println("1. Add Lecture Slide");
        System.out.println("2. Add Lecture Video");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1){
            String tos;
            System.out.print("Enter topic of Slides: ");
            tos=sc.nextLine();
            System.out.print("Enter number of slides: ");
            int nos=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter content of slides: ");
            ArrayList<String> content=new ArrayList<String>();
            for(int i=0;i<nos;i++){
                System.out.print("Content of slide "+(i+1)+": ");
                String str=sc.nextLine();
                content.add(str);
            }
            slides_obj.add(new Slides(tos,nos,content,new Date(),id));
        }
        else if(choice==2){
            System.out.print("Enter topic of video: ");
            String str=sc.nextLine();
            System.out.print("Enter filename of video: ");
            String file=sc.nextLine();
            if(!file.substring(file.length()-4).equals(".mp4")){
                System.out.println("Invalid file format. Please upload with .mp4 extension");
                return;
            }
            lec_obj.add(new Lectures(str,file,new Date(),id));
        }
    }
    @Override
    public void add_assessments(ArrayList<Student> stu_obj,ArrayList<Assignments> an,ArrayList<Quiz> qu){
        System.out.println("1. Add Assignment");
        System.out.println("2. Add Quiz");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1){
            System.out.print("Enter problem statement: ");
            String prob=sc.nextLine();
            System.out.print("Enter max marks: ");
            int mm=sc.nextInt();
            ass_obj.add(new Assignments(prob, mm));
            an.add(new Assignments(prob,mm));
            for(int i=0;i<stu_obj.size();i++){
                stu_obj.get(i).getassignments_obj().add(new Assignments(prob, mm));
            }
        }
        else if(choice==2){
            System.out.print("Enter quiz question: ");
            String ques=sc.nextLine();
            q_obj.add(new Quiz(ques));
            qu.add(new Quiz(ques));
            for(int i=0;i<stu_obj.size();i++){
                stu_obj.get(i).getquiz_obj().add(new Quiz(ques));
            }
        }
    } 
    @Override
    public void add_comments(ArrayList<Comments> comm,String id){
        System.out.print("Enter comment: ");
        String com=sc.nextLine();
        comm.add(new Comments(com,id,new Date()));
    }
    @Override
    public void view_lecture_slides(){
        for(int i=0;i<slides_obj.size();i++){
            System.out.print("Title: "+slides_obj.get(i).gettos()+"\n");
            for(int j=0;j<slides_obj.get(i).getcon().size();j++){
                System.out.println("Slide "+(j+1)+": "+slides_obj.get(i).getcon().get(j));
            }
            System.out.println("Number of slides: "+slides_obj.get(i).getnos());
            System.out.println("Date of upload: "+slides_obj.get(i).getdate());
            System.out.println("Uploaded by: "+slides_obj.get(i).getinstr());

        }
    }
    @Override
    public void view_lecture_videos(){
        for(int p=0;p<lec_obj.size();p++){
            System.out.println("Title of video: "+lec_obj.get(p).gettopic());
            System.out.println("Video file: "+lec_obj.get(p).getfile());
            System.out.println("Date of upload: "+lec_obj.get(p).getdate());
            System.out.println("Uploaded by: "+lec_obj.get(p).getinst());
        }
    }
    @Override
    public int view_assessments(){
        int k=0;
        for(int i=0;i<ass_obj.size();i++){
            System.out.println("ID: "+k+" Assignment: "+ass_obj.get(i).getproblem()+" Max Marks: "+ass_obj.get(i).getmm());
            System.out.println("----------------");
            k++;
        }
        for(int j=0;j<q_obj.size();j++){
            System.out.println("ID: "+k+" Question: "+q_obj.get(j).getq());
            k++;
            System.out.println("----------------");
        }
        return k;
    }
}
