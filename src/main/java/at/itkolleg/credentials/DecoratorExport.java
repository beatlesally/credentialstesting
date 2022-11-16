package at.itkolleg.credentials;

import java.util.List;

public abstract class DecoratorExport implements ExportCredentials{

    private ExportCredentials exportCredentials;

    public DecoratorExport(ExportCredentials ex)
    {
        this.exportCredentials = ex;
    }

    @Override
    public void export(List<Credentials> credentialsList) {
        this.exportCredentials.export(credentialsList);
    }
}
