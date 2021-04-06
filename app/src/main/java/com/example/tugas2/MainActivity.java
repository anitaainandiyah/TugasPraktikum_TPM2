package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, nim, ipk; //Deklarasi object bernama Name, nim, ipk yang merupakan EditText
    Button submit; //Deklarasi object bernama submit yang merupakan Button
    String name2, nim2, ipk2; //Deklarasi object bernama name2, nim2, ipk2 yang merupakan sebuah String


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);  //Menyambungkan elemen dengan id name yang ada di activity_main.xml kesini
        nim = findViewById(R.id.nim); //Menyambungkan elemen dengan id nim yang ada di activity_main.xml kesini
        ipk = findViewById(R.id.ipk); //Menyambungkan elemen dengan id ipk yang ada di activity_main.xml kesini
        submit = findViewById(R.id.submit); //Menyambungkan elemen dengan id submit yang ada di activity_main.xml kesini



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name2 = name.getText().toString(); //Mengambil value yang ada di EditText Name dan dimasukkan ke variabel Name2
                nim2 = nim.getText().toString(); //Mengambil value yang ada di EditText Nim dan dimasukkan ke variabel Nim2
                ipk2 = ipk.getText().toString(); //Mengambil value yang ada di EditText ipk dan dimasukkan ke variabel ipk2
                //Pada  baris code di atas, hasil yang didapatkan dari EditText adalah berbentuk STRING (defaultnya memang string)
                //Sedangkan yang kita butuhkan adalah berbentuk double, maka kita convert dulu  string tersebut ke tipe data double
                double nilai = Double.parseDouble(ipk2);


                if (nilai >= 3.66 && nilai <= 4.00) {
                    ipk2 = "A";
                } else if (nilai >= 3.33 && nilai <= 3.66) {
                    ipk2 = "A-";
                } else if (nilai >= 3.00 && nilai <= 3.33) {
                    ipk2 = "B+";
                } else if (nilai >= 2.66 && nilai <= 3.00) {
                    ipk2 = "B";
                } else if (nilai >= 2.33 && nilai <= 2.66) {
                    ipk2 = "B-";
                } else if (nilai >= 2.00 && nilai <= 2.33) {
                    ipk2 = "C+";
                } else if (nilai >= 1.66 && nilai <= 2.00) {
                    ipk2 = "C";
                } else if (nilai >= 1.33 && nilai <= 1.66) {
                    ipk2 = "C-";
                } else if (nilai >= 1.00 && nilai <= 1.33) {
                    ipk2 = "D+";
                } else if (nilai >= 0 && nilai <= 1.00) {
                    ipk2 = "D";
                }

                Intent i = new Intent(MainActivity.this, MainActivity2.class); //Untuk transfer data dari satu Activity ke Activity lain

                if (name2.equals("") || nim2.equals("") || ipk2.equals("")) {
                    Toast.makeText(MainActivity.this, "Nama ,Nim ,Ipk tidak boleh kosong !", Toast.LENGTH_LONG).show();
                } else {
                    i.putExtra("name", name2);
                    i.putExtra("nim", nim2);
                    i.putExtra("ipk", ipk2);
                    startActivity(i);
                }
            }
        });

    }
}