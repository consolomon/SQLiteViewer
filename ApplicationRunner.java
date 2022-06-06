package viewer;


public class ApplicationRunner {
    public static void main(String[] args) {

        new SQLiteViewer();



        /*SQLiteViewer viewer = new SQLiteViewer();

        String url = "jdbc:sqlite:sample2.db";
        DBConnection dbConnection = new DBConnection(url);

        String columnDef = "unit_id text, section_id integer, shelf_id integer, part_id integer";

        //dbConnection.addTable("stack_1", columnDef);
        //dbConnection.addTable("stack_3", columnDef);

        //dbConnection.addValues("stack_3", new String[]{"'BL240', 5, 3, 2"});

        //dbConnection.addValues("stack_5", new String[]{"'BL350', 3, 4, 1"});


        String tables = dbConnection.getTables();
        System.out.println(tables);
        Stack <String> values = dbConnection.getAllValues("stack_3");
        System.out.println(values);


         */


    }

}
