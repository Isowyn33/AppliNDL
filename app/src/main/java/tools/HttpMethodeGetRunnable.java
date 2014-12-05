package tools;

import java.io.InputStream;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import android.util.Log;
/**
 * <p>
 * Classe qui permet de récupérer un inputStream relatif à un certain WebService
 * </p>
 * @author Matthias & Junior
 *
 */
public class HttpMethodeGetRunnable implements Runnable {
    /** Adresse ou est localisé le service web à appelé */
    private String adresse;
    /** Contient l'inputStream à renvoyer lors de l'appel de la méthode getInputStream() */
    private InputStream inputStream;
    /** Code de retour de la requête HTTP */
    private int returnCodeHttp;

    /**
     * Méthode qui renvoie un objet InputStream à traiter pour récupérer les infos envoyées par la requête http
     *
     * @param adresse String. Contient l'adresse du service web sous forme de chaine de caractère
     */
    public synchronized InputStream getInputStream(String adresse) {
        this.adresse = adresse;
        // On lance la méthode run() qui s'occupe de tout le traitement
        run();

        return inputStream;
    }

    @Override
    public void run() {
        //Initialisation du client HTTP qui va être utilisé pour executer la requête
        DefaultHttpClient httpClient;
        HttpParams httpParameters = new BasicHttpParams();

        //Permet de visualiser les requêtes http grace à l'outil fiddler installé sur le pc à l'ip indiquée
        //HttpHost proxy = new HttpHost("192.168.56.1", 8888);
        //httpParameters.setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

        httpClient = new DefaultHttpClient(httpParameters);
        try {
            URI uri = new URI(adresse);
            //Création de la requête, ici de type GET
            HttpGet myRequest = new HttpGet(uri);

            //L'exécution de la requête GET me renvoie une réponse de type HtppResponse
            //Je récupère le contenu de cette réponse en format InputStream
            HttpResponse res = httpClient.execute(myRequest);
            inputStream = res.getEntity().getContent();

            returnCodeHttp = res.getStatusLine().getStatusCode();
            if(res.getStatusLine().getStatusCode() != 200)
                Log.e("Biocold", "Status HTTP : " + res.getStatusLine());
            else
                Log.i("Biocold", "Status HTTP : " + res.getStatusLine());
        } // Quelque chose ne s'est pas bien passé (erreur de chargement, le login n'éxiste pas...)
        catch (Exception e){}
    }

    /**
     * @return le code de retour de la requete http
     */
    public int getReturnCode() {
        return returnCodeHttp;
    }
}
