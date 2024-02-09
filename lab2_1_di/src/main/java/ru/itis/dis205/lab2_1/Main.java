package ru.itis.dis205.lab2_1;

public class Main {
    public static void main(String[] args) {
        //PersonService service = new PersonService();

        System.out.println(PersonService.class.getName());

        Context context = new Context();

        Application application =
                (Application)context.getObjectByName(Application.class.getName());

        application.run();
    }
}
