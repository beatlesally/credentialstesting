package at.itkolleg.credentials;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Credentials> credentialsList = new ArrayList<>();
        credentialsList.add(new Credentials("www.gmx.at","123zuesss", "a.iller"));
        credentialsList.add(new Credentials("www.hotmail.com","asdfjköljk", "corban.nerum"));
        credentialsList.add(new Credentials("www.xyz.net","9fas8dfu9ee", "bobba.fett"));
        //with Decorator
        ExportCredentials exportHashPW =  new HashPWExportDecorator(new CsvExporter());
        exportHashPW.export(credentialsList);
        System.out.println("------------------------");
        //without Decorator
        ExportCredentials exportCSV =  new CsvExporter();
        exportCSV.export(credentialsList);
        System.out.println("------------------------");

        //add more entries
        credentialsList.add(new Credentials("www.gmail.at","36lskdlej", "a.sally"));
        credentialsList.add(new Credentials("www.enterprice.com","69asdjfsh", "corban.nerum"));

        //with Decorator
        ExportCredentials exportHashPW2 =  new HashPWExportDecorator(new CsvExporter());
        exportHashPW.export(credentialsList);
        System.out.println("------------------------");
        //without Decorator
        ExportCredentials exportCSV1 =  new CsvExporter();
        exportCSV.export(credentialsList);

    }
}
