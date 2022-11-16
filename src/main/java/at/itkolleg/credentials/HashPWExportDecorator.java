package at.itkolleg.credentials;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse erbt von DecoratorExport und stellt einen konkreten DecoratorExport dar, der das Password in einen
 * Hash-Wert umwandelt. Nach der Dekorierung wird dann die export Methode der Mutterklasse aufgerufen.
 */
public class HashPWExportDecorator extends DecoratorExport{
    public HashPWExportDecorator(ExportCredentials ex) {
        super(ex);
    }

    /**
     * Diese Methode dekoriert den Export, um das Password als Hash auszugeben.
     * Hierbei wird die mitgegebene Arraylist nochmals separat abgespeichert und dort das Passwort zu einem Hashwert
     * verändert. Diese veränderte Liste wird dann mit dem super.export Aufruf an die Mutterklasse weitergegeben, die
     * den gewünschten Export vornimmt, der im Datenfeld hinterlegt ist (in unserem Beispiel CSVExport).
     * @param credentialsList eine Liste mit Login Credentials vom Typ Credentials
     */
    @Override
    public void export(List<Credentials> credentialsList) {
        //Erstellen einer zweiten Arraylist
        //Sonst werden der Wert für das Passwort überschrieben und somit nicht dekoriert!
        List<Credentials> hashPWCredentials = new ArrayList<>();
        for (Credentials item:
             credentialsList) {
            //es muss ein neues Credentials-Objekt erzeugt werden, weil sonst die Referenz auf die "alte" Arraylist zeigt
            //und das PW vom Objekt verändert wird
            hashPWCredentials.add(new Credentials(item.getHost(),item.getPwd(), item.getUser()));
        }

        //PW aus der Liste holen, einen HashWert daraus generieren und PW als Hash speichern
        for (Credentials credentials: hashPWCredentials) {
            credentials.setPwd(Hashing.sha256()
                    .hashString(credentials.getPwd(), StandardCharsets.UTF_8)
                    .toString());
        }

        //export wird von der Mutterklasse mit der modifizierten Arraylist vorgenommen
        super.export(hashPWCredentials);
    }
}
