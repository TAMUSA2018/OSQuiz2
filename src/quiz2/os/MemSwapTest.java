package quiz2.os;

import java.util.Random;
import java.util.*;

public class MemSwapTest{
    /**
     * This program simulates allocating jobs in memory.
     * It can allocate jobs using:
     * - First Fit
     * - Next Fit
     * - Best Fit
     * - Worse Fit
     */
   
   //     static MemLinkedList list = new MemLinkedList();
    static MemLinkedList list1 = new MemLinkedList(150000);
        static HashMap<Integer,Job> jobs1 = new HashMap<>();
                static HashMap<Integer,Boolean> jobStatus1 = new HashMap<>(); //TRUE if is available, FALSE if its already in list
    static  MemLinkedList initialize(MemLinkedList list){
        Job j1 = new Job(0,40959);
         Segment s1 = new Segment(j1);
         list.push(s1, "ff");
        return list;
    }
     static  MemLinkedList initialize1(MemLinkedList list){
          list1 = new MemLinkedList(11000);
        Job j1 = new Job(0,4074);
         Segment s1 = new Segment(j1);
         list.push(s1, "ff");
          Job j2 = new Job(1,105);
         Segment s2 = new Segment(j2);
         list.push(s2, "ff");
          Job j3 = new Job(2,5);
         Segment s3 = new Segment(j3);
         list.push(s3, "ff");
          Job j4 = new Job(3,600);
         Segment s4 = new Segment(j4);
         list.push(s4, "ff");
          Job j5 = new Job(4,20);
         Segment s5 = new Segment(j5);
         list.push(s5, "ff");
          Job j6 = new Job(5,205);
         Segment s6 = new Segment(j6);
         list.push(s6, "ff");
          Job j7 = new Job(6,4050);
         Segment s7 = new Segment(j7);
         list.push(s7, "ff");
          Job j8 = new Job(7,230);
         Segment s8 = new Segment(j8);
         list.push(s8, "ff");
          Job j9 = new Job(8,1000);
         Segment s9 = new Segment(j9);
         list.push(s9, "ff");
        return list;
    }
    public static void main(String[] args){
        HashMap<Integer,Job> jobs = new HashMap<>();
        HashMap<Integer,Boolean> jobStatus = new HashMap<>(); //TRUE if is available, FALSE if its already in list
        MemLinkedList list = new MemLinkedList(150000); // change this for mem size
    //     int out=randInt(50,5000);
        simulateFF(list);
     //   Table2_2_alsmadi(list);
        
    }
    static void Table2_2_alsmadi(MemLinkedList list){
            list =initialize1(list);
             getJobs1(list);
             
             try{
             for(int k=0; k<list.length;k++){
                 list.deallocate(k);
             }
             }
             catch(Exception ex){
                 String test=ex.getMessage();
             }
             getJobs1(list);
   //     getJobs();
     //    getJobStatus();
        // addJob(0,1);
         Job j1 = new Job(1,10000);
         Segment s1 = new Segment(j1);
         list.push(s1, "ff");
        
         Job j2 = new Job(2,20000);
         s1 = new Segment(j2);
         list.push(s1, "ff");
         
         Job j3 = new Job(3,30000);
         s1 = new Segment(j3);
         list.push(s1, "ff");
         Job j4 = new Job(4,50000);
         s1 = new Segment(j4);
         list.push(s1, "ff");
         getJobs1(list);
        }
    public static int randInt(int min, int max) {

    // NOTE: This will (intentionally) not run as written so that folks
    // copy-pasting have to think about how to initialize their
    // Random instance.  Initialization of the Random instance is outside
    // the main scope of the question, but some decent options are to have
    // a field that is initialized once and then re-used as needed or to
    // use ThreadLocalRandom (if using at least Java 1.7).
    // 
    // In particular, do NOT do 'Random rand = new Random()' here or you
    // will get not very good / not very random results.
    Random rand=new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}
        static void simulateFF(MemLinkedList list){
            list =initialize(list);
             getJobs1(list);
   //     getJobs();
     //    getJobStatus();
        // addJob(0,1);
        
        for(int k1=1; k1<10; k1++){
            double x= Math.random();
            int out=randInt(50,5000);
             Job j1 = new Job(k1,out);
         Segment s1 = new Segment(j1);
         list.push(s1, "ff");
         if(k1%2==0){
              list.deallocate(0);
         }
        }
        
        
         
         getJobs1(list);
        }
        // initialize memory to look like example in Figure 2.6
        
         //getJobStatus();
       
         //list.bestFit(1);
         
   //     Test1();
    
    /*
    static void deleteJob(int jobNO ){
        if (list.deallocate(jobNO) == null)
                                    System.out.println("Job not in the list");
                                else {
                                    jobStatus.put(jobNO, true);
                                    System.out.println("Job is deleted");
                                }
    }
    static void addJob(int location, int Size){
        try {
                                   
                                    if(Size != 0) {
                                        if (!jobs.containsKey(location)) {
                                            jobs.put(location, new Job(location, Size));
                                            jobStatus.put(location, true);
                                        } else
                                            System.out.println("job already exist");
                                    }else{
                                        System.out.println("Length cannot be 0");}
                                } catch (Exception ex) {
                                    System.out.println("Third argument needs to be a number");
                                }
    }
   */
   // static void getJobs(){
     //    System.out.print(s1.toString()+ " ");
       //                 System.out.println("");
   // }
    static void getJobs1(MemLinkedList list){
        System.out.println("Jobs");
     //    Iterator it = list.iterator();
 
    // Iterating the list in forward direction
    System.out.println("LinkedList elements:");
    System.out.println("Job ID..."+"Job starting Point.."+"Job Size");
   // while(it.hasNext()){
  //for(int k=0; k< list.length; k++){
    //     for(Job val: jobs.values())
       
     //  Segment s1 = (Segment)it.next();
       System.out.print(list.toString()+ " ");
                        System.out.println("");
      //}
    }
 /*   static void getJobStatus(){
        System.out.println("Job status");
        System.out.println(list.toString());
    }
   */
    static void Test1(){
        HashMap<Integer,Job> jobs = new HashMap<>();
        HashMap<Integer,Boolean> jobStatus = new HashMap<>(); //TRUE if is available, FALSE if its already in list
        MemLinkedList list = new MemLinkedList(100000);
        Scanner in = new Scanner(System.in);
        String[] arr = {""};
        while(arr[0] != "exit"){
            System.out.print(">");
            arr = in.nextLine().split(" ");
            if(arr.length ==1){
                switch(arr[0]) {
                    case "jobs":
                        for(Job val: jobs.values())
                            System.out.print(val.toString()+ " ");
                        System.out.println("");
                        break;
                    case "list":
                        System.out.println(list.toString());
                        break;
                    default:
                        System.out.println("Command does not exist");
                        break;
                }
            }else if(arr.length==2 || arr.length ==3) {
                try {
                    int num = Integer.parseInt(arr[1]);
                    if(num != 0){
                        switch (arr[0]) {
                            case "de":
                                if (list.deallocate(num) == null)
                                    System.out.println("Job not in the list");
                                else {
                                    jobStatus.put(num, true);
                                }
                                break;
                            case "add":
                                try {
                                    int length = Integer.parseInt(arr[2]);
                                    if(length != 0) {
                                        if (!jobs.containsKey(num)) {
                                            jobs.put(num, new Job(num, length));
                                            jobStatus.put(num, true);
                                        } else
                                            System.out.println("job already exist");
                                    }else{
                                        System.out.println("Length cannot be 0");}
                                } catch (Exception ex) {
                                    System.out.println("Third argument needs to be a number");
                                }
                                break;
                            default:
                                Job temp = jobs.get(num);
                                if (temp == null)
                                    System.out.println("Job does not exist");
                                else if (!jobStatus.get(num)) {
                                    System.out.println("Job already in the list");
                                } else if (list.push(new Segment(jobs.get(num)), arr[0]))
                                    jobStatus.put(num, false);
                        }
                    }
                    else{
                        System.out.println("PID cannot be 0");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Second argument needs to be a number");
                }
            }
        }
    }
}