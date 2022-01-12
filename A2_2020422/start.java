import java.util.*;
class start {

    
    Scanner sc=new Scanner(System.in);
    private ArrayList<Instructor> ins_obj=new ArrayList<Instructor>();
    private ArrayList<Student> stu_obj=new ArrayList<Student>();
    private ArrayList<Assignments> an=new ArrayList<Assignments>();
    private ArrayList<Quiz> qu=new ArrayList<Quiz>();
    private ArrayList<Comments> comm=new ArrayList<Comments>();

    public ArrayList<Instructor> getins_obj(){
        return this.ins_obj;
    }

    public ArrayList<Student> getstu_obj(){
        return this.stu_obj;
    }

    public ArrayList<Assignments> getan(){
        return this.an;
    }

    public ArrayList<Quiz> getqu(){
        return this.qu;
    }

    public ArrayList<Comments> getcomm(){
        return this.comm;
    }

    int print_menu(String str){ //printing instructor's menu
        System.out.println("INSTRUCTOR MENU\n1. Add class material\n2. Add assessments\n3. View lecture materials\n4. View assessments\n5. Grade assessments\n6. Close assessment\n7. View comments\n8. Add comments\n9. Logout");
        int choice=sc.nextInt();
        return choice;
    }
    int print_menu(){  //printing strudent's menu
        System.out.println("STUDENT MENU\n1. View lecture materials\n2. View assessments\n3. Submit assessment\n4. View grades\n5. View comments\n6. Add comments\n7. Logout");
        int choice=sc.nextInt();
        return choice;
    }
    
    void top_menu(){
        ins_obj.add(new Instructor("I0"));
        ins_obj.add(new Instructor("I1"));
        stu_obj.add(new Student("S0"));
        stu_obj.add(new Student("S1"));
        stu_obj.add(new Student("S2"));

        while(1>0){ //inf loop till user chooses exit
            
            System.out.println("Welcome to Backpack\n1. Enter as instructor\n2. Enter as student\n3. Exit"); //printing login options
            int n;
            n=sc.nextInt();
            if(n==3){
                System.out.println("-------------------------------------------------------------------------------------------------");
                break;
            }
            else if(n==1){
                sub_menu("Instructor");
            }
            else if(n==2){
                sub_menu();
            }
        }
    }

    void sub_menu(){  //choosing student's ID
        System.out.println("Students:");
        for(int i=0;i<stu_obj.size();i++){
            System.out.println(i+" - "+stu_obj.get(i).getdi());
        }
        System.out.print("Choose id: ");
        int id=sc.nextInt();
        while(1>0){
            System.out.println("Welcome "+stu_obj.get(id).getdi());
            int ch=print_menu();
            if(ch==1){
                for(int i=0;i<ins_obj.size();i++){
                    ins_obj.get(i).view_lecture_slides();
                }
                System.out.println();
                for(int j=0;j<ins_obj.size();j++){
                    ins_obj.get(j).view_lecture_videos();
                }
            }
            else if(ch==2){
                for(int i=0;i<ins_obj.size();i++){
                    ins_obj.get(i).view_assessments();
                }
            }
            else if(ch==3){
                stu_obj.get(id).submit_assessment();
            }
            else if(ch==4){
                System.out.println("Graded submissions");
                for(int i=0;i<stu_obj.get(id).getsubmit_assignments_obj().size();i++){
                    if(stu_obj.get(id).getsubmit_assignments_obj().get(i).getstatus().equals("graded")){
                        System.out.println("Submission: "+stu_obj.get(id).getsubmit_assignments_obj().get(i).getans());
                        System.out.println("Marks scored: "+stu_obj.get(id).getsubmit_assignments_obj().get(i).getmm());
                        System.out.println("Graded by: "+stu_obj.get(id).getsubmit_assignments_obj().get(i).getgb());
                    }
                }
                for(int i=0;i<stu_obj.get(id).getsubmit_quiz_obj().size();i++){
                    if(stu_obj.get(id).getsubmit_quiz_obj().get(i).getstatus().equals("graded")){
                        System.out.println("Submission: "+stu_obj.get(id).getsubmit_quiz_obj().get(i).getanswer());
                        System.out.println("Marks scored: 1");
                        System.out.println("Graded by: "+stu_obj.get(id).getsubmit_quiz_obj().get(i).getgb());
                    }
                }
                System.out.println("Ungraded submissions");
                for(int i=0;i<stu_obj.get(id).getsubmit_assignments_obj().size();i++){
                    if(stu_obj.get(id).getsubmit_assignments_obj().get(i).getstatus().equals("not graded")){
                        System.out.println("Submission: "+stu_obj.get(id).getsubmit_assignments_obj().get(i).getans());
                    }
                }
                for(int i=0;i<stu_obj.get(id).getsubmit_quiz_obj().size();i++){
                    if(stu_obj.get(id).getsubmit_quiz_obj().get(i).getstatus().equals("not graded")){
                        System.out.println("Submission: "+stu_obj.get(id).getsubmit_quiz_obj().get(i).getanswer());
                    }
                }
                System.out.println("-----------------");

            }
            else if(ch==5){
                for(int i=0;i<comm.size();i++){
                    System.out.println(comm.get(i).getcomment()+" - "+comm.get(i).getid());
                    System.out.println(comm.get(i).getd());
                }
            }
            else if(ch==6){
                stu_obj.get(id).add_comments(comm,stu_obj.get(id).getdi());
            }
            if(ch==7){
                return;
            }
        }
    }
    
    void sub_menu(String s){    //choosing instructor's id
        System.out.println("Instructors:");
        for(int i=0;i<ins_obj.size();i++){
            System.out.println(i+" - "+ins_obj.get(i).getids());
        }
        System.out.print("Choose id: ");
        int id=sc.nextInt();
        while(1>0){
            System.out.println("Welcome "+ins_obj.get(id).getids());
            int ch=print_menu("Instructor");
            if(ch==1){
                ins_obj.get(id).add_class_material(ins_obj.get(id).getids());
            }
            else if(ch==2){
                ins_obj.get(id).add_assessments(stu_obj,an,qu);
            }
            else if(ch==3){
                for(int i=0;i<ins_obj.size();i++){
                    ins_obj.get(i).view_lecture_slides();
                }
                System.out.println();
                for(int j=0;j<ins_obj.size();j++){
                    ins_obj.get(j).view_lecture_videos();
                }
            }
            else if(ch==4){
                for(int i=0;i<ins_obj.size();i++){
                    ins_obj.get(i).view_assessments();
                }
            }
            else if(ch==5){
                System.out.println("List of assessments");
                int k=0;
                for(int i=0;i<an.size();i++){
                    System.out.println("ID: "+k+" Assignment: "+an.get(i).getproblem()+" Max Marks: "+an.get(i).getmm());
                    System.out.println("----------------");
                    k++;
                }
                for(int j=0;j<qu.size();j++){
                    System.out.println("ID: "+k+" Question: "+qu.get(j).getq());
                    System.out.println("----------------");
                    k++;
                }
                System.out.print("Enter ID of assessment to view submissions: ");
                int d=sc.nextInt();
                int flag=0;
                if(d>an.size()-1){
                    flag=d-an.size();
                }
                if(d<=an.size()-1){
                    HashMap<String,Student> map=new HashMap<>();
                    for(int i=0;i<stu_obj.size();i++){
                        for(int j=0;j<stu_obj.get(i).getsubmit_assignments_obj().size();j++){
                            if(stu_obj.get(i).getsubmit_assignments_obj().size()==0){
                                continue;
                            }
                            if(stu_obj.get(i).getsubmit_assignments_obj().get(j).getproblem().equals(an.get(d).getproblem())&&stu_obj.get(i).getsubmit_assignments_obj().get(j).getstatus().equals("not graded")){
                                map.put(String.valueOf(i),stu_obj.get(i));
                                System.out.println(i+". "+stu_obj.get(i).getdi());
                            }
                        }
                    }
                    int sub=sc.nextInt();
                    String id_sub=String.valueOf(sub);
                    for(int m=0;m<map.get(id_sub).getsubmit_assignments_obj().size();m++){
                        if(map.get(id_sub).getsubmit_assignments_obj().size()==0){
                            break;
                        }
                        if(map.get(id_sub).getsubmit_assignments_obj().get(m).getproblem().equals(an.get(d).getproblem())){
                            System.out.println("Submission: "+map.get(id_sub).getsubmit_assignments_obj().get(m).getans());
                            map.get(id_sub).getsubmit_assignments_obj().get(m).setgb(ins_obj.get(id).getids());
                            map.get(id_sub).getsubmit_assignments_obj().get(m).setstatus("graded");
                            System.out.println("-------------------------------");
                            System.out.println("Max Marks: "+map.get(id_sub).getsubmit_assignments_obj().get(m).getmm());
                            System.out.println("Marks scored: "+map.get(id_sub).getsubmit_assignments_obj().get(m).getmm());

                        }
                    }
                }
                else{
                    HashMap<String,Student> map=new HashMap<>();
                    for(int i=0;i<stu_obj.size();i++){
                        for(int j=0;j<stu_obj.get(i).getsubmit_quiz_obj().size();j++){
                            if(stu_obj.get(i).getsubmit_quiz_obj().size()==0){
                                continue;
                            }
                            if(stu_obj.get(i).getsubmit_quiz_obj().get(j).getq().equals(qu.get(d).getq())&&stu_obj.get(i).getsubmit_quiz_obj().get(j).getstatus().equals("not graded")){
                                map.put(String.valueOf(i),stu_obj.get(i));
                                System.out.println(i+". "+stu_obj.get(i).getdi());
                            }
                        }
                    }
                    int sub=sc.nextInt();
                    String id_sub=String.valueOf(sub);
                    for(int m=0;m<map.get(id_sub).getsubmit_quiz_obj().size();m++){
                        if(map.get(id_sub).getsubmit_quiz_obj().size()==0){
                            break;
                        }
                        if(map.get(id_sub).getsubmit_quiz_obj().get(m).getq().equals(qu.get(d).getq())){
                            System.out.println("Submission: "+map.get(id_sub).getsubmit_quiz_obj().get(m).getanswer());
                            map.get(id_sub).getsubmit_quiz_obj().get(m).setgb(ins_obj.get(id).getids());
                            map.get(id_sub).getsubmit_quiz_obj().get(m).setstatus("graded");
                            System.out.println("-------------------------------");
                            System.out.println("Max Marks: 1");
                            System.out.println("Marks scored: 1");
                        }
                    }

                }
                
            }
            else if(ch==6){
                System.out.println("List of Open Assignments: ");
                int k=0;
                for(int i=0;i<an.size();i++){
                    System.out.println("ID: "+k+" Assignment: "+an.get(i).getproblem()+" Max Marks: "+an.get(i).getmm());
                    System.out.println("----------------");
                    k++;
                }
                for(int j=0;j<qu.size();j++){
                    System.out.println("ID: "+k+" Question: "+qu.get(j).getq());
                    System.out.println("----------------");
                    k++;
                }
                System.out.print("Enter ID of assignment to close: ");
                int d=sc.nextInt();
                int flag=0;
                if(d>an.size()-1){
                    flag=d-an.size();
                }
                if(d<=an.size()-1){
                    for(int i=0;i<stu_obj.size();i++){
                        for(int j=0;j<stu_obj.get(i).getassignments_obj().size();j++){
                            if(stu_obj.get(i).getassignments_obj().get(j).getproblem().equals(an.get(d).getproblem())){
                                stu_obj.get(i).getassignments_obj().remove(j);
                            }
                        }
                    }
                    an.remove(d);
                }
                else{
                    for(int i=0;i<stu_obj.size();i++){
                        for(int j=0;j<stu_obj.get(i).getquiz_obj().size();j++){
                            if(stu_obj.get(i).getquiz_obj().get(j).getq().equals(qu.get(flag).getq())){
                                stu_obj.get(i).getquiz_obj().remove(j);
                            }
                        }
                    }
                    qu.remove(flag);
                }

            }
            else if(ch==7){
                for(int i=0;i<comm.size();i++){
                    System.out.println(comm.get(i).getcomment()+" - "+comm.get(i).getid());
                    System.out.println(comm.get(i).getd());
                }
            }
            else if(ch==8){
                ins_obj.get(id).add_comments(comm,ins_obj.get(id).getids());
            }
            if(ch==9){
                return;
            }
        }
    }
    
    public static void main(String args[]){
        start ob=new start();
        ob.top_menu();
    }
}
