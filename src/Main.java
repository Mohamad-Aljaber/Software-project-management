enum TaskType {
    TASK,
    BUG
}
enum TaskStatus {
    New,
    InProgress,
    InQA,
    Done,
    Approve
}
public class Main {

    public static void main(String[] args) throws Exception {
        Project p=new Project("IUSR.SYS");
        System.out.println( p.getNameProject());
        Manager manager=new Manager("Mohamad");
        Programmer prog1=new Programmer("Reem");
        Programmer prog2=new Programmer("Ahmad");
        Programmer prog3=new Programmer("Ali");
        Tester tester1=new Tester("Nour");
        Tester tester2=new Tester("Omar");
        Task task1=new Task("Create a new user interface",TaskType.TASK,TaskStatus.New);
        Task task2=new Task("Develop a new feature",TaskType.BUG,TaskStatus.New);
        Task task3=new Task("Fix a bug",TaskType.BUG,TaskStatus.New);
        Task task4=new Task("Optimize application performance",TaskType.TASK,TaskStatus.New);
        Task task5=new Task("Improve application security",TaskType.TASK,TaskStatus.New);
        Task task6=new Task("Create website",TaskType.BUG,TaskStatus.New);
//        ********************************************
        p.addManager(manager);
        p.addProgrammer(prog1);
        p.addProgrammer(prog2);
        p.addProgrammer(prog3);
        p.addTester(tester1);
        p.addTester(tester2);
        p.addTask(task1);
        p.addTask(task2);
        p.addTask(task3);
        p.addTask(task4);
        p.addTask(task5);
        p.addTask(task6);

//        *********** تعيين مبرمجي*******************
        System.out.println("\n--------------------------------");
        p.assignProgrammer(task1,prog1);
        p.assignProgrammer(task2,prog2);
        p.assignProgrammer(task3,prog3);
        System.out.println("--------------------------------\n");

//        *************** طباعة ملعومات المشروع******************
        p.PrintDetailsProject();
        System.out.println("--------------------------------");
        p.PrintNameManger();
        System.out.println("--------------------------------");
        p.PrintNameProgrammer();
        System.out.println("--------------------------------");
        p.PrintNameTester();
        System.out.println("--------------------------------\n");
//        ****************** حذف ******************
        p.removeManger();
        p.removeProgrammer(prog1);
        p.removeTester(tester2);
//        *****************الطباعة بعد التعديل********************
        p.PrintDetailsProject();
        System.out.println("------------------*******--------------");
        p.PrintNameManger();
        p.PrintNameProgrammer();
        System.out.println("--------------------------------");
        p.PrintNameTester();
        System.out.println("--------------------------------");
        p.PrintALLTasks();
        System.out.println("--------------------------------");
        p.addProgrammer(prog1);
        p.addTester(tester2);
        p.addManager(manager);

//        *************    5    ********************
        System.out.println("*****************************************************");
        prog1.reviewTasks(p);
        prog1.assignTaskToSelf(task4,"3:16");
        prog3.assignTaskToSelf(task6,"72:35");

//        *************   6   *********************

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//        p.PrintNewTasks();
        prog1.FinshTask(task1,"3:46");
        System.out.println(task1.getStatut());
        System.out.println(task1.getALLTimeTask());
        prog2.FinshTask(task2,"24:45");
//        prog1.FinshTask(task3,"78:05");   هنا تظهر رسالة خطأ في حال المبرمج اخبرنا انه انتهى من مهمة ليست له
//        **********       ************************
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        p.PrintInQATasks();
        tester1.takeTaskeFromProgrammer(task2,true);
        tester2.takeTaskeFromProgrammer(task1,true);
//        p.PrintALLTasks();
//        **********       ************************
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        p.PrintDoneTasks();
        System.out.println("--------------------------------");
        manager.reviewTasks(task1);
        p.PrintALLTasks();
        System.out.println("/*/*/*/*/*/*/*//**/*");
//        System.out.println(p.searchTaskByName("Create website"));
        System.out.println(p.searchTaskByProgrammer(prog2));

    }
}