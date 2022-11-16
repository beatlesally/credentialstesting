package at.itkolleg.credentials;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class HashPWExportDecorator extends DecoratorExport{
    public HashPWExportDecorator(ExportCredentials ex) {
        super(ex);
    }

    @Override
    public void export(List<Credentials> credentialsList) {
        for (Credentials credentials:credentialsList) {
            credentials.setPwd(Hashing.sha256()
                    .hashString(credentials.getPwd(), StandardCharsets.UTF_8)
                    .toString());
        }
        super.export(credentialsList);
    }
}
