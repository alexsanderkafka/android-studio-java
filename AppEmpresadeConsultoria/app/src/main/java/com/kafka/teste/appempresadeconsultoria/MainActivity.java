package com.kafka.teste.appempresadeconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servico, R.id.nav_clientes, R.id.nav_contato, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){
        String celular = "tel:11997632995";
        String imagem = "https://spacetoday.com.br/wp-content/uploads/2023/01/textura_lua_01.jpg";
        String endereco = "https://www.google.com.br/maps/place/Parque+Estadual+da+Ilha+Anchieta/@-23.5499993,-45.0769882,15z/data=!3m1!4b1!4m6!3m5!1s0x94cd55faf39ae6e7:0x52ec58d54508a680!8m2!3d-23.55!4d-45.066667!16s%2Fg%2F1hb_d_gnz?entry=ttu";
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        //intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automática");

        intent.setType("message/rfc822");
        //intent.setType("text/plain");
        //intent.setType("image/*");
        //intent.setType("application/pdf");

        startActivity(Intent.createChooser(intent, "Compartilhar"));

    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
