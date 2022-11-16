package at.itkolleg.credentials;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HashPWExportDecorator extends DecoratorExport{
    public HashPWExportDecorator(ExportCredentials ex) {
        super(ex);
    }

    @Override
    public void export(List<Credentials> credentialsList) {

        //Erstellen einer zweiten Arraylist
        //Sonst werden der Wert für das Passwort überschrieben und somit nicht dekoriert!
        List<Credentials> hashPWCredentials = new ArrayList<>();
        for (Credentials item:
             credentialsList) {
            //es muss ein neues Credentials
            hashPWCredentials.add(new Credentials(item.getHost(),item.getPwd(), item.getUser()));
        }

        for (Credentials credentials: hashPWCredentials) {
            credentials.setPwd(Hashing.sha256()
                    .hashString(credentials.getPwd(), StandardCharsets.UTF_8)
                    .toString());
        }
        super.export(hashPWCredentials);
    }
}
