package greedy.standard_greedy_algorithm.q3;

public class Job {
    char id;
    int deadline;
    int profit;

    Job(char id,int deadline,int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }
}
