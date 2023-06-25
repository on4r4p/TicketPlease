package com.on4r4p.TicketPlease.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.on4r4p.TicketPlease.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class MessageListActivity extends AppCompatActivity {
    RcAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.message_list_activity);

        int zero = 48;
        int zed = 90;
        int rndlen = 4;
        Random random = new Random();

        String nbrRnd = random.ints(zero,zed + 1)
                .filter(i -> (i <= 57 || i >= 65))
                .limit(rndlen)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();



        int rndlen2 = 6;
        Random random2 = new Random();

        String nbrRnd2 = random2.ints(zero,zed + 1)
                .filter(i -> (i <= 57 || i >= 65))
                .limit(rndlen2)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();




        int zd = 48;
        int ziro = 57;
        int stringLength = 12;
        StringBuilder buf1 = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            int randomLimitedInt = zd + (int)
                    (random.nextFloat() * (ziro - zd + 1));
            buf1.append((char) randomLimitedInt);
        }
        String codegensytral = buf1.toString().replaceAll("(.{4})", "$1-");
        codegensytral = codegensytral.substring(0,codegensytral.length() -2);

        //yeah i no but i suckatjava
        int zzLimit = 48;
        int nnLimit = 57;
        int phnLen = 8;
        StringBuilder buf = new StringBuilder(phnLen);
        for (int i = 0; i < phnLen; i++) {
            int randomLimitedInt = zzLimit + (int)
                    (random2.nextFloat() * (nnLimit - zzLimit + 1));
            buf.append((char) randomLimitedInt);
        }

        String rndphone = buf.toString();
        String phonenbr = String.format("\n06%s%s",rndphone,nbrRnd);


        int leftLimit = 48;
        int rightLimit = 57;
        int targetStringLength = 12;

        StringBuilder buf2 = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buf2.append((char) randomLimitedInt);
        }
        String codegen = buf2.toString().replaceAll("(.{2})", "$1'");
        codegen = codegen.substring(0,codegen.length() -1);

        SimpleDateFormat valtick = new SimpleDateFormat("HH:mm");
        SimpleDateFormat datetick = new SimpleDateFormat("dd.MM.yy");
        SimpleDateFormat datehead = new SimpleDateFormat("E dd MMMM - HH:mm");

        String dahead = datehead.format(new Date());
        String validity = valtick.format(new Date());
        String validity2 = valtick.format(new Date(System.currentTimeMillis() + 3600000));

        String date = datetick.format(new Date());

        EditText callText = (EditText) findViewById(R.id.callNbr);
        ImageView contactView = (ImageView) findViewById(R.id.contactPic);

        Intent intent = getIntent();

        String spintxt = intent.getStringExtra("getData");
        String splitspinxt = spintxt.replaceAll("BUS","bus ");
        String identity = intent.getStringExtra("entreprise");

        EditText editText = (EditText)findViewById(R.id.bustype);
        editText.setText(spintxt, TextView.BufferType.EDITABLE);

        EditText headText = (EditText)findViewById(R.id.headerdate);
        headText.setText(dahead, TextView.BufferType.EDITABLE);


        String chronotxthead = String.format("TXIK TXAK - 1.5H30min CHRONOPLUS\n" +
                "avec corresp. / loturarekin\n" +
                "Validité / Balio : %s - %s\n" +
                "%s\n" +
                "1.20€\n\n"+
                "%s\n\n" +
                "%s\n\n" +
                "Bon voyage\nBidaia on",validity,validity2,date,phonenbr,codegen);


        String ticetxthead = String.format("TICE\n" +
                "Ticket SMS 2 euros\n" +
                "\nValable 1h\n"+
                "%s à %s\n" +
                "%s\n" +
                "\nSMS A PRESENTER\nAU CONDUCTEUR\n"+
                "%s\n\n" +
                "Bon voyage",validity,validity2,date,codegen);

        String keolistxthead = String.format("%s\n" +
                "Ticket SMS 2 euros\n" +
                "\nValable 1h\n"+
                "%s à %s\n" +
                "%s\n" +
                "\nSMS A PRESENTER\nAU CONDUCTEUR\n"+
                "%s\n\n" +
                "Bon voyage",spintxt,validity,validity2,date,codegen);

        String ratptxthead = String.format("RATP - Ticket SMS %s\n" +
                "2 euros TTC\n" +
                "\n1 trajet sans corresp.\n"+
                "le %s de %s à %s\n" +
                "\nA PRESENTER AU CONDUCTEUR\n\n"+
                "%s\n\n" +
                "tab-sms.fr",splitspinxt,date,validity,validity2,codegen);


        ArrayList<String> gchatArray = new ArrayList<>();

        if (identity.equals("Chronoplus")){
            gchatArray.add(chronotxthead);
            callText.setText("93064",TextView.BufferType.EDITABLE);
            contactView.setImageResource(R.drawable.logo_chronoplusround);}

        if (identity.equals("Tice")){
            gchatArray.add(ticetxthead);
            callText.setText("93100",TextView.BufferType.EDITABLE);
            contactView.setImageResource(R.drawable.tice);}

        if (identity.equals("Keolis")){
            gchatArray.add(keolistxthead);
            callText.setText("93100",TextView.BufferType.EDITABLE);
            contactView.setImageResource(R.drawable.keolis);}

        if (identity.equals("Transdev")){
            gchatArray.add(keolistxthead);
            callText.setText("93100",TextView.BufferType.EDITABLE);
            contactView.setImageResource(R.drawable.transdev);}

        if (identity.equals("Ratp")){
            gchatArray.add(ratptxthead);
            callText.setText("93100",TextView.BufferType.EDITABLE);
            contactView.setImageResource(R.drawable.ratp);}

        if (identity.equals("Sytral")){

            if(spintxt.equals("BUS")){
                String Sytraltxthead = String.format("TCL\n" +
                        "\nTicket tcl unité bus 1.90€\n" +
                        "\nValable le %s de\n"+
                        "%s à %s\n" +
                        "\n%s\n" +
                        "\njustificatif : http://a.hcnx.eu/%s",date,validity,validity2,codegensytral,nbrRnd2);
                gchatArray.add(Sytraltxthead);

            }

            if(spintxt.equals("CAR")){
                String Sytraltxthead = String.format("CARS DU RHONE\n" +
                        "\nTicket unité car 2.10€\n" +
                        "\nValable le %s de\n"+
                        "%s à %s\n" +
                        "\n%s\n" +
                        "\njustificatif : http://a.hcnx.eu/%s",date,validity,validity2,codegensytral,nbrRnd2);
                gchatArray.add(Sytraltxthead);

            }

            if(spintxt.equals("LIB")){
                String Sytraltxthead = String.format("LIBELLULE\n" +
                        "\nTicket unité bus 1.30€\n" +
                        "\nValable le %s de\n"+
                        "%s à %s\n" +
                        "\n%s\n" +
                        "\njustificatif : http://a.hcnx.eu/%s",date,validity,validity2,codegensytral,nbrRnd2);
                gchatArray.add(Sytraltxthead);

            }


            callText.setText("93069",TextView.BufferType.EDITABLE);
            contactView.setImageResource(R.drawable.sytral);}

        RecyclerView recyclerView = findViewById(R.id.recycler_gchat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RcAdapter(this,gchatArray);
        recyclerView.setAdapter(adapter);
    }
}