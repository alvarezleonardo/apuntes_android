package digitalhouse.android.basededatosywebbaseintegrado.model;
import com.google.gson.annotations.SerializedName;

/**
 * Created by digitalhouse on 6/06/16.
 */
public class Post {

    //Solo incluimos aca las variables del JSON que queremos leer. Solo me interesa el ID, el titulo,el precio y la imagen.. Lo demás lo ignoramos.

    @SerializedName("id")
    private String ID;

    private String title;

    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
