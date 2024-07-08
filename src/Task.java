public class Task {
    private String name;
    private TaskType type;
    private  TaskStatus statut;
    private Programmer Programmer;
    private String Time;
    private String ExpiryTime;
    private  Tester tester;
    private  Manager manger;
    public Task(String name, TaskType type,TaskStatus statut) {
        this.name = name;
        this.type = type;
        this.statut=statut;
        this.Time="0:0";
        this.ExpiryTime="0,0";
    }
    public String getName(){
        return name;
    }
    public TaskType getType(){
        return type;
    }
    public TaskStatus getStatut(){
        return statut;
    }
    public TaskStatus setStatut(TaskStatus newStatus){
        statut=newStatus;
        return statut;
    }

    public String setTime(String newTime){
        Time=newTime;
        return Time;
    }
    public String getTime(){
        return Time;
    }
    public String setALLTimeTask(String newTime){
        ExpiryTime=newTime;
        return ExpiryTime;
    }
    public String getALLTimeTask(){
        return ExpiryTime;
    }
    public String setName(String newName){
        name=newName;
        return name;
    }
    public TaskType setType(TaskType newType){
        type=newType;
        return type;
    }
    public void setProgrammer(Programmer Programmer) {
        this.Programmer = Programmer;
        this.statut = TaskStatus.InProgress; // Change status to Assigned when a programmer is assigned
    }

    public Programmer getProgrammer() {
        return Programmer;
    }
    public  void setTester(Tester tester){
        this.tester=tester;
    }
    public  Tester getTester(){
        return  tester;
    }
    public Manager setManger(Manager manger){
        this.manger=manger;
        return manger;
    }
    public Manager getManger(){
        return manger;
    }
    @Override
    public String toString() {
        return "Task{\n" +
                "name='" + name  + "( "+type+")" + "\n" +
                "status='" + statut +
                "\nProgrammer=" + (Programmer != null ? Programmer.getName() : "None") +
                "   ,Time : "+Time+
                "      FinshTime : "+ExpiryTime+
                "\nTester : "+(tester != null ? tester.getName() : "None\n")+
                '}';
    }
}
