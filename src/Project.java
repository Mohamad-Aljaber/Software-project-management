public class Project {
    private String name;
    private Manager manager;
    private DynamicArray<Programmer> programmers;
    private DynamicArray<Tester> testers;
    private DynamicArray<Task> tasks;
    private StackArray<Task> sTask;
    public Project(String name){
        this.name=name;
        programmers=new DynamicArray<>();
        testers= new DynamicArray<>();
        tasks=new DynamicArray<>();
        sTask=new StackArray<>();

    }
    public String getNameProject() {
        return name;
    }
//    *********************** أضافة  ****************************
    public void addManager(Manager manager){
        this.manager=manager;
    }
    public  void addProgrammer(Programmer programmer){
        this.programmers.insertNew(programmer);
    }
    public  void addTester(Tester tester){
        testers.insertNew(tester);

    }
    public void addTask(Task newTask) {
        tasks.insertNew(newTask);
        sTask.puch(newTask);
    }
//    *********************** حذف مسؤولين ****************************
    public void removeManger(){
       this.manager=null;
    }
    public  void removeProgrammer(Programmer programmer) throws Exception {
       programmers.removeItem(programmer);
    }
    public  void removeTester(Tester tester) throws Exception {
        testers.removeItem(tester);
    }
    public void removeTask(Task task) throws Exception {
        tasks.removeItem(task);
        sTask.pop();
    }
//    ************************ تعديل ********************************
public void updateTask(Task task, String newName, TaskType newType) {
    task .setName(newName);
    task.setType(newType);

}
//    *******************************  طباعة *************************
    public void PrintNameProgrammer() throws Exception{
        for (int i=0;i<programmers.size;i++){
            System.out.println(programmers.Get(i));
        }

    }
    public void PrintNameManger() throws Exception{
        if (manager !=null)
            System.out.println(manager);

}
    public void PrintNameTester() throws Exception {
        for (int i = 0; i < testers.size; i++) {
            System.out.println(testers.Get(i));
        }
    }
    public  void PrintNewTasks() throws Exception{
        for (int i = 0; i < tasks.size; i++)  {
            if ( tasks.Get(i).getStatut()==TaskStatus.New) {
                System.out.println(tasks.Get(i));
            }
        }
    }
    public  void PrintInQATasks() throws Exception{
        for (int i = 0; i < tasks.size; i++)  {
            if ( tasks.Get(i).getStatut()==TaskStatus.InQA) {
                System.out.println(tasks.Get(i));
            }
        }
    }
    public  void PrintDoneTasks() throws Exception{
        for (int i = 0; i < tasks.size; i++)  {
            if ( tasks.Get(i).getStatut()==TaskStatus.Done) {
                System.out.println(tasks.Get(i));
            }
        }
    }
    public  void PrintALLTasks() throws Exception{
        for (int i = 0; i < tasks.size; i++)  {
            System.out.println(tasks.Get(i));
        }
    }
    public void PrintDetailsProject() {
        System.out.println( "Project: " + name +
                "\nprogrammers: " + programmers.size +
                "\nTester: "+testers.size+
                "\nTasks: " + tasks.size);
    }
//    **********************  تعين مبرمج من قبل مدير المشروع****************************
public void assignProgrammer(Task task, Programmer programmer) throws Exception {
    task.setProgrammer(programmer);
    System.out.println("Task \"" + task.getName() + "\" has been assigned to " + programmer.getName());
}
    public DynamicArray<Task> getTasks() {
        return tasks;
    }
    public Task searchTaskByName(String taskName)throws Exception {

        for (int i = 0; i < tasks.size; i++) {
            if (tasks.Get(i).getName()==taskName)
                return tasks.Get(i);
        }
        return null;
    }
    public Task searchTaskByProgrammer(Programmer programmer)throws Exception {

        for (int i = 0; i < tasks.size; i++) {
            if (tasks.Get(i).getProgrammer()==programmer)
                return tasks.Get(i);
        }
        return null;
    }
//
}
