package digitalhouse.android.trumpada;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Aca inicialzo el sdk de Facebook para poder utilizarlo en la aplicacion
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        setContentView(R.layout.activity_main);

        //Aca creo un callbackManager que es el que va a escuchar el resultado del logueo
        callbackManager = CallbackManager.Factory.create();

        //Aca obtengo el boton de login y le seteo los permisos que le voy a pedir al usuario al conectarme con facabook
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");


        //Al boton le doy un callbackManager y le seteo el listener de cuando el usuario se loguea
        //Este codigo se va a ejecutar si es que logra loguearse, si falla o si el mismo usuario cancelo el logueo.
        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Toast.makeText(MainActivity.this, "Se logueo", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                // App code
            }
        });
        setearCompartir();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    //Aca es donde voy a armar el contenido que quiero compartir y se lo adhiero al button de share de facebook.
    public void setearCompartir(){
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentTitle("Titulo")
                .setContentDescription("Descripcion")
                .setContentUrl(Uri.parse("http://www.infobae.com/america/eeuu/2016/11/09/impacto-mundial-donald-trump-gano-las-elecciones-y-sera-presidente-de-los-estados-unidos-hasta-el-2021/"))
                .build();
        ShareButton shareButton = (ShareButton) findViewById(R.id.shareButton);
        shareButton.setShareContent(content);

    }

    //Aca armo el pedido para consular la api de facebook para poder pedirle informacion del usuario
    public void requestGraph(View view){
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response) {
                        //Aca es donde me llega la respuesta a la consulta y obtengo la inforrmacion del object de json
                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                        try {
                            String name = object.getString("name");
                            String link = object.getString("link");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        // Application code
                    }
                });
        //Aca armo un bundle con la informacion que le voy a pedir
        Bundle parameters = new Bundle();

        //Agrego "fields" para indicarle que quiero los campos "id", "name" y "link"
        parameters.putString("fields", "id,name,link");

        //Agrego el bundle de informacion del request al request
        request.setParameters(parameters);

        //Lo ejecuto, una vez finalizado se va a ejecutar el codigo del onCompleted
        request.executeAsync();
    }
}


















