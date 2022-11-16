package at.itkolleg.credentials;

import java.util.List;

/**
 * Diese abstrakte Klasse stellt den abstrakten DecoratorExport dar. Er speichert den eigentlichen
 * Exporter als Datenfeld und ruft an diesem die export Methode auf.
 */
public abstract class DecoratorExport implements ExportCredentials{

    //Exporter, der dekoriert wird
    private ExportCredentials exportCredentials;

    public DecoratorExport(ExportCredentials ex)
    {
        this.exportCredentials = ex;//setzt das Objekt, dass dekoriert werden soll


    }

    /**
     * Diese Methode überschreibt die export Methode des Interfaces ExportCredentials.
     * Über das Datenfeld wird die Methode aufgerufen, nachdem die Methode dekoriert wurde.
     * @param credentialsList eine Liste mit Login Credentials vom Typ Credentials
     */
    @Override
    public void export(List<Credentials> credentialsList) {
        //Export wird mit dem gewünschten Exporter (Datenfeld) nach der Dekoration durchgeführt.
        //Aus der Unterklasse heraus wird mit super.export die Methode aufgerufen.
        this.exportCredentials.export(credentialsList);
    }
}
