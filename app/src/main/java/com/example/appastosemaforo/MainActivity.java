package com.example.appastosemaforo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private EditText nombrepotrero, cantidad, calidad;
//    private Button botonguardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (android.os.Build.VERSION.SDK_INT > 9) {
//            StrictMode.ThreadPolicy policy = new
//                    StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//        }


        nombrepotrero = (EditText) findViewById(R.id.et_nombre);
        cantidad = (EditText) findViewById(R.id.et_cantidad);
        calidad = (EditText) findViewById(R.id.et_calidad);


        final Button boton = findViewById(R.id.btn_guardar);

        boton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nombre = nombrepotrero.getText().toString();
                String cant = cantidad.getText().toString();
                String cal = calidad.getText().toString();

                new DescargarImagen(MainActivity.this).execute(nombre, cant, cal);

            }
        });

    }

    public static class DescargarImagen extends AsyncTask<String, Void, String> {

        private WeakReference<Context> context;

        public DescargarImagen(Context context) {
            this.context = new WeakReference<>(context);
        }

        @Override
        protected String doInBackground(String... params) {
            String registrar_url = "https://www.appsweb.dev/guardarpotrero.php";
            String resultado;


            try {

                URL url = new URL(registrar_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, Charset.forName("UTF-8")));

                String nombre = params[0];
                String cantidad = params[1];
                String calidad = params[2];

                String data = URLEncoder.encode("nombrepotrero", "UTF-8") + "=" + URLEncoder.encode(nombre, "UTF-8")
                        + "&" + URLEncoder.encode("cantidad", "UTF-8") + "=" + URLEncoder.encode(cantidad, "UTF-8")
                        + "&" + URLEncoder.encode("calidad", "UTF-8") + "=" + URLEncoder.encode(calidad, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();

                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();


                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                StringBuilder stringBuilder = new StringBuilder();

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                resultado = stringBuilder.toString();

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                Log.d("MiAPP", "Se ha utilizado una URL con formato incorrecto");
                resultado = "Se ha producido un ERROR";
            } catch (IOException e) {
                Log.d("MiAPP", "Error inesperado!, posibles problemas de conexion de red");
                resultado = "Se ha producido un ERROR, comprueba tu conexion a Internet";
            }
            return resultado;
        }

        public void onPostExecute(String resultado) {
            Toast.makeText(context.get(), resultado, Toast.LENGTH_LONG).show();
        }
    }
}
