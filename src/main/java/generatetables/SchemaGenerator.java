package generatetables;

import java.io.File;
import java.util.EnumSet;

import myEntities.Umowy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

public class SchemaGenerator {

    public static final String SCRIPT_FILE = "exportScript.sql";

    private static SchemaExport getSchemaExport() {

        SchemaExport export = new SchemaExport();
        File outputFile = new File(SCRIPT_FILE);
        String outputFilePath = outputFile.getAbsolutePath();

        System.out.println("Export file: " + outputFilePath);

        export.setDelimiter(";");
        export.setOutputFile(outputFilePath);

        export.setHaltOnError(false);

        return export;
    }

    public static void dropDataBase(SchemaExport export, Metadata metadata) {

        EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);

        export.drop(targetTypes, metadata);
    }

    public static void createDataBase(SchemaExport export, Metadata metadata) {


        EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);

        SchemaExport.Action action = SchemaExport.Action.CREATE;

        export.execute(targetTypes, action, metadata);

        System.out.println("Export OK");

    }

    public static void main(String[] args) {

        String configFileName = "hibernate.cfg.xml";

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
                .configure(configFileName).build();

        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        SchemaExport export = getSchemaExport();

        System.out.println("Drop Database...");
        dropDataBase(export, metadata);

        System.out.println("Create Database...");
        createDataBase(export, metadata);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Umowy.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new table object...");
            Umowy request1 = new Umowy("KUCYK", 2222, "22/2011", "02.02.2012", "03.04.2014",
                    100.00, "NET", "MONTH", 2, "true");
            Umowy request2 = new Umowy("ŁÓDKA", 2343, "21/2012", "10.03.2012", "03.03.2014",
                    555.00, "NET", "MONTH", 2, "true");
            Umowy request3 = new Umowy("KAPISZON", 1232, "34/2010", "04.06.2011", "05.06.2014",
                    453.33, "NET", "MONTH", 2, "true");
            Umowy request4 = new Umowy("KOTEK", 3131, "22/2015", "21.01.2015", "01.01.2016",
                    123.31, "BRU", "YEAR", 2, "false");
            Umowy request5 = new Umowy("DEMON", 1222, "303/2017", "15.03.2017", "2017-20-22",
                    122.11, "NET", "MONTH", 2, "true");
            Umowy request6 = new Umowy("ZÓŁWIK", 5511, "212/2017", "23.01.1917", "25.12.2017",
                    122.12, "NET", "MONTH", 2, "true");
            Umowy request7 = new Umowy("KOJOTEK", 3322, "311/2017", "12.01.2017", "31.12.2017",
                    444.00, "NET", "MONTH", 2, "true");


            session.beginTransaction();

            System.out.println("Saving the object...");
            session.save(request1);
            session.save(request2);
            session.save(request3);
            session.save(request4);
            session.save(request5);
            session.save(request6);
            session.save(request7);

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

}