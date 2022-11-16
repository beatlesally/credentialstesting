package at.itkolleg.credentials;

import java.util.List;

/**
 * Diese abstrakte Klasse stellt den abstrakten DecoratorExport dar. Er speichert den eigentlichen
 * Exporter als Datenfeld und ruft an diesem die export Methode auf.
 */
public abstract class DecoratorExport implements ExportCredentials{

    //Objekt, der der eigentliche Exporter ist, der dekoriert wird
    private ExportCredentials exportCredentials;

    public DecoratorExport(ExportCredentials ex)
    {
        this.exportCredentials = ex;
    }

    /**
     * Diese Methode überschreibt die export Methode des Interfaces ExportCredentials.
     * Über das Datenfeld wird die Methode aufgerufen, nachdem die Methode dekoriert wurde.
     * @param credentialsList eine Liste mit Login Credentials vom Typ Credentials
     */
    @Override
    public void export(List<Credentials> credentialsList) {
        //Export wird mit dem gewünschten Exporter (Datenfeld) nach der Dekoration durchgeführt.
        this.exportCredentials.export(credentialsList);
    }
}
