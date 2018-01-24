package quiz2.os;


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
        Job j1 = new Job(0,107520);
         Segment s1 = new Segment(j1);
         list.push(s1, "ff");
        return list;
    }
    public static void main(String[] args){
        HashMap<Integer,Job> jobs = new HashMap<>();
        HashMap<Integer,Boolean> jobStatus = new HashMap<>(); //TRUE if is available, FALSE if its already in list
        MemLinkedList list = new MemLinkedList(150000); // change this for mem size
        
        simulateFig2_6(list);
        
    }
        static void simulateFig2_6(MemLinkedList list){
            list =initialize(list);
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