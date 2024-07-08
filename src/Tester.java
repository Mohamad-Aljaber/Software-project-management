public class Tester {
    private String name;
    public Tester(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name + " ( Tester )";
    }
    public void  takeTaskeFromProgrammer(Task task, boolean trueTask) throws Exception {
        if ( task.getStatut()==TaskStatus.InQA) {
            task.setTester(this);
            if (trueTask ){
                task.setStatut(TaskStatus.Done);
            }else{
                task.setStatut(TaskStatus.Done);
                task.setType(TaskType.BUG);

            }
        }
    }
}
