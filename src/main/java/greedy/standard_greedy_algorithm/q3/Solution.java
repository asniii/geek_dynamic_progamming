package greedy.standard_greedy_algorithm.q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *
 * Job Sequencing Problem
 * Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline.
 * It is also given that every job takes single unit of time, so the minimum possible deadline for any job is 1.
 * How to maximize total profit if only one job can be scheduled at a time.
 *
 */
public class Solution {


    public static void main(String args[]){
        Job[] jobs = {new Job('a',2,100),new Job('b',1,19),new Job('c',2,27),
                new Job('d',1,25), new Job('e',3,15)};
        printJobScheduling(jobs);

    }

    static void printJobScheduling(Job[] jobs){
        int max_deadline = 0;

        for(Job job:jobs){
            if(job.deadline > max_deadline){
                max_deadline = job.deadline;
            }
        }

        Arrays.sort(jobs,(e1,e2)->{
            return e2.profit-e1.profit;
        });

        List<Job> jobList = new ArrayList<>(Arrays.asList(jobs));

        char result[] = new char[max_deadline+1] ;

        for(int i = 0;i<result.length;i++){
            result[i] = '.';
        }

        Job tempJob =null;
        for(int i = max_deadline;i>0;i--){
            for(Job job: jobList){
                if(job.deadline>=i){
                    result[i] = job.id;
                    tempJob = job;
                    break;
                }
            }
            if(tempJob!=null) {
                jobList.remove(tempJob);
            }
            tempJob = null;
        }

        for(int i = result.length-1 ;i>0;i--){
            if(result[i]!='.'){
                System.out.print(result[i] + " , ");
            }
        }


    }
}
