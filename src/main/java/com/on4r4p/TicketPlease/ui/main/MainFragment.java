package com.on4r4p.TicketPlease.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.on4r4p.TicketPlease.R;

import java.io.IOException;

public class MainFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    ImageView imageView;

    public static String identity = "none";

    String[] Chrono_Lines = {"Bus T1","Bus T2","Bus 3","Bus 4","Bus 5","Bus 6","Bus 30",
            "Bus 32","Bus 34","Bus 36","Bus 38","Bus 40","Bus 42","Bus 44","Bus 46",
            "Bus 48","Bus 50","Bus 52","Bus Adour 1"};

    String[] Keolis_Lines = {"PHEBUS","CIF","CTOP","KMR","KOR","KSO","KSS",
            "KSVM","KVO","MEYER","ORMONT"};

    String[] Ratp_Lines = {"CEOBUS","CTVMI","DUNOIS","MOBICITE","SQYBUS","STILE","TIMBUS",
            "TVM","BUS20", "BUS21", "BUS22", "BUS23", "BUS24", "BUS25", "BUS26", "BUS27", "BUS28", "BUS29", "BUS30", "BUS31", "BUS32", "BUS33", "BUS34", "BUS35", "BUS36", "BUS37", "BUS38", "BUS39", "BUS40", "BUS41", "BUS42", "BUS43", "BUS44", "BUS45", "BUS46", "BUS47", "BUS48", "BUS49", "BUS50", "BUS51", "BUS52", "BUS53", "BUS54", "BUS55", "BUS56", "BUS57", "BUS58", "BUS59", "BUS60", "BUS61", "BUS62", "BUS63", "BUS64", "BUS65", "BUS66", "BUS67", "BUS68", "BUS69", "BUS70", "BUS71", "BUS72", "BUS73", "BUS74", "BUS75", "BUS76", "BUS77", "BUS78", "BUS79", "BUS80", "BUS81", "BUS82", "BUS83", "BUS84", "BUS85", "BUS86", "BUS87", "BUS88", "BUS89", "BUS90", "BUS91", "BUS92", "BUS93", "BUS94", "BUS95", "BUS96", "BUS97", "BUS98", "BUS99", "BUS100", "BUS101", "BUS102", "BUS103", "BUS104", "BUS105", "BUS106", "BUS107", "BUS108", "BUS109", "BUS110", "BUS111", "BUS112", "BUS113", "BUS114", "BUS115", "BUS116", "BUS117", "BUS118", "BUS119", "BUS120", "BUS121", "BUS122", "BUS123", "BUS124", "BUS125", "BUS126", "BUS127", "BUS128", "BUS129", "BUS130", "BUS131", "BUS132", "BUS133", "BUS134", "BUS135", "BUS136", "BUS137", "BUS138", "BUS139", "BUS140", "BUS141", "BUS142", "BUS143", "BUS144", "BUS145", "BUS146", "BUS147", "BUS148", "BUS149", "BUS150", "BUS151", "BUS152", "BUS153", "BUS154", "BUS155", "BUS156", "BUS157", "BUS158", "BUS159", "BUS160", "BUS161", "BUS162", "BUS163", "BUS164", "BUS165", "BUS166", "BUS167", "BUS168", "BUS169", "BUS170", "BUS171", "BUS172", "BUS173", "BUS174", "BUS175", "BUS176", "BUS177", "BUS178", "BUS179", "BUS180", "BUS181", "BUS182", "BUS183", "BUS184", "BUS185", "BUS186", "BUS187", "BUS188", "BUS189", "BUS190", "BUS191", "BUS192", "BUS193", "BUS194", "BUS195", "BUS196", "BUS197", "BUS198", "BUS199", "BUS200", "BUS201", "BUS202", "BUS203", "BUS204", "BUS205", "BUS206", "BUS207", "BUS208", "BUS209", "BUS210", "BUS211", "BUS212", "BUS213", "BUS214", "BUS215", "BUS216", "BUS217", "BUS218", "BUS219", "BUS220", "BUS221", "BUS222", "BUS223", "BUS224", "BUS225", "BUS226", "BUS227", "BUS228", "BUS229", "BUS230", "BUS231", "BUS232", "BUS233", "BUS234", "BUS235", "BUS236", "BUS237", "BUS238", "BUS239", "BUS240", "BUS241", "BUS242", "BUS243", "BUS244", "BUS245", "BUS246", "BUS247", "BUS248", "BUS249", "BUS250", "BUS251", "BUS252", "BUS253", "BUS254", "BUS255", "BUS256", "BUS257", "BUS258", "BUS259", "BUS260", "BUS261", "BUS262", "BUS263", "BUS264", "BUS265", "BUS266", "BUS267", "BUS268", "BUS269", "BUS270", "BUS271", "BUS272", "BUS273", "BUS274", "BUS275", "BUS276", "BUS277", "BUS278", "BUS279", "BUS280", "BUS281", "BUS282", "BUS283", "BUS284", "BUS285", "BUS286", "BUS287", "BUS288", "BUS289", "BUS290", "BUS291", "BUS292", "BUS293", "BUS294", "BUS295", "BUS296", "BUS297", "BUS298", "BUS299", "BUS300", "BUS301", "BUS302", "BUS303", "BUS304", "BUS305", "BUS306", "BUS307", "BUS308", "BUS309", "BUS310", "BUS311", "BUS312", "BUS313", "BUS314", "BUS315", "BUS316", "BUS317", "BUS318", "BUS319", "BUS320", "BUS321", "BUS322", "BUS323", "BUS324", "BUS325", "BUS326", "BUS327", "BUS328", "BUS329", "BUS330", "BUS331", "BUS332", "BUS333", "BUS334", "BUS335", "BUS336", "BUS337", "BUS338", "BUS339", "BUS340", "BUS341", "BUS342", "BUS343", "BUS344", "BUS345", "BUS346", "BUS347", "BUS348", "BUS349", "BUS350", "BUS351", "BUS352", "BUS353", "BUS354", "BUS355", "BUS356", "BUS357", "BUS358", "BUS359", "BUS360", "BUS361", "BUS362", "BUS363", "BUS364", "BUS365", "BUS366", "BUS367", "BUS368", "BUS369", "BUS370", "BUS371", "BUS372", "BUS373", "BUS374", "BUS375", "BUS376", "BUS377", "BUS378", "BUS379", "BUS380", "BUS381", "BUS382", "BUS383", "BUS384", "BUS385", "BUS386", "BUS387", "BUS388", "BUS389", "BUS390", "BUS391", "BUS392", "BUS393", "BUS394", "BUS395", "BUS396", "BUS397", "BUS398", "BUS399", "BUS400", "BUS401", "BUS402", "BUS403", "BUS404", "BUS405", "BUS406", "BUS407", "BUS408", "BUS409", "BUS410", "BUS411", "BUS412", "BUS413", "BUS414", "BUS415", "BUS416", "BUS417", "BUS418", "BUS419", "BUS420", "BUS421", "BUS422", "BUS423", "BUS424", "BUS425", "BUS426", "BUS427", "BUS428", "BUS429", "BUS430", "BUS431", "BUS432", "BUS433", "BUS434", "BUS435", "BUS436", "BUS437", "BUS438", "BUS439", "BUS440", "BUS441", "BUS442", "BUS443", "BUS444", "BUS445", "BUS446", "BUS447", "BUS448", "BUS449", "BUS450", "BUS451", "BUS452", "BUS453", "BUS454", "BUS455", "BUS456", "BUS457", "BUS458", "BUS459", "BUS460", "BUS461", "BUS462", "BUS463", "BUS464", "BUS465", "BUS466", "BUS467", "BUS468", "BUS469", "BUS470", "BUS471", "BUS472", "BUS473", "BUS474", "BUS475", "BUS476", "BUS477", "BUS478", "BUS479", "BUS480", "BUS481", "BUS482", "BUS483", "BUS484", "BUS485", "BUS486", "BUS487", "BUS488", "BUS489", "BUS490", "BUS491", "BUS492", "BUS493", "BUS494", "BUS495", "BUS496", "BUS497", "BUS498", "BUS499", "BUS500", "BUS501", "BUS502", "BUS503", "BUS504", "BUS505", "BUS506", "BUS507", "BUS508", "BUS509", "BUS510", "BUS511", "BUS512", "BUS513", "BUS514", "BUS515", "BUS516", "BUS517", "BUS518", "BUS519", "BUS520", "BUS521", "BUS522", "BUS523", "BUS524", "BUS525", "BUS526", "BUS527", "BUS528", "BUS529", "BUS530", "BUS531", "BUS532", "BUS533", "BUS534", "BUS535", "BUS536", "BUS537", "BUS538", "BUS539", "BUS540", "BUS541", "BUS542", "BUS543", "BUS544", "BUS545", "BUS546", "BUS547", "BUS548", "BUS549", "BUS550", "BUS551", "BUS552", "BUS553", "BUS554", "BUS555", "BUS556", "BUS557", "BUS558", "BUS559", "BUS560", "BUS561", "BUS562", "BUS563", "BUS564", "BUS565", "BUS566", "BUS567", "BUS568", "BUS569", "BUS570", "BUS571", "BUS572", "BUS573", "BUS574", "BUS575", "BUS576", "BUS577", "BUS578", "BUS579", "BUS580", "BUS581", "BUS582", "BUS583", "BUS584", "BUS585", "BUS586", "BUS587", "BUS588", "BUS589", "BUS590", "BUS591", "BUS592", "BUS593", "BUS594", "BUS595", "BUS596", "BUS597", "BUS598", "BUS599","BUSN01","BUSN02","BUSN11",
    "BUSN12","BUSN13","BUSN14","BUSN15","BUSN16","BUSN21","BUSN22","BUSN23","BUSN24","BUSN122",
    "BUSN31","BUSN32","BUSN33","BUSN34","BUSN35","BUSN41","BUSN43","BUSN44","BUSN45","BUSN51","BUSN52",
    "BUSN53","BUSN61","BUSN62","BUSN63","BUSN66","BUSN153","BUSN71","BUSN130","BUSN131","BUSN132",
    "BUSN133","BUSN134","BUSN135","BUSN140","BUSN141","BUSN142","BUSN143","BUSN144","BUSN145","BUSN150",
    "BUSN151","BUSN154"};

    String[] Tice_Lines = {"TICE"};

    String[] Transd_Lines = {"EXP34","STRAV","AMV","BBM","CEAT","CSO","INTERVAL","ORGEBUS","ORSAY",
    "N4","TIPS","TDV","SETRA","STBC","TRA","TVF","TVO","VEA","ALBA","MLV","SENART","STRAV","TOURNEUX",
    "V1"};

    String[] Sytral_Lines = {"BUS","CAR","LIB"};

    public static MainFragment newInstance() {


        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);
        imageView = (ImageView) rootView.findViewById(R.id.logotp);
        Spinner spin = (Spinner) rootView.findViewById(R.id.buspin);

        spin.setOnItemSelectedListener(this);


        ImageButton chronoImgBtn = (ImageButton) rootView.findViewById(R.id.chronoplus);
        chronoImgBtn.setOnClickListener(view -> {
            MainFragment.identity = "Chronoplus";
            ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Chrono_Lines);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spin.setAdapter(aa);


            Context context = getActivity();
            CharSequence text = "Chronoplus Buslines Loaded";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        });


        ImageButton keolisImgBtn = (ImageButton) rootView.findViewById(R.id.keolis);
        keolisImgBtn.setOnClickListener(view -> {
            MainFragment.identity = "Keolis";
            ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Keolis_Lines);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spin.setAdapter(aa);


            Context context = getActivity();
            CharSequence text = "Keolis Buslines Loaded";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        });


        ImageButton ticeImgBtn = (ImageButton) rootView.findViewById(R.id.tice);
        ticeImgBtn.setOnClickListener(view -> {
            MainFragment.identity = "Tice";
            ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Tice_Lines);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spin.setAdapter(aa);


            Context context = getActivity();
            CharSequence text = "Tice Buslines Loaded";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        });

        ImageButton ratpImgBtn = (ImageButton) rootView.findViewById(R.id.ratp);
        ratpImgBtn.setOnClickListener(view -> {
            MainFragment.identity = "Ratp";
            ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Ratp_Lines);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spin.setAdapter(aa);


            Context context = getActivity();
            CharSequence text = "Ratp Buslines Loaded";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        });

        ImageButton transdImgBtn = (ImageButton) rootView.findViewById(R.id.transdev);
        transdImgBtn.setOnClickListener(view -> {
            MainFragment.identity = "Transdev";
            ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Transd_Lines);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spin.setAdapter(aa);


            Context context = getActivity();
            CharSequence text = "Transdev Buslines Loaded";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        });


        ImageButton sytraldImgBtn = (ImageButton) rootView.findViewById(R.id.sytral);
        sytraldImgBtn.setOnClickListener(view -> {
            MainFragment.identity = "Sytral";
            ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Sytral_Lines);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spin.setAdapter(aa);


            Context context = getActivity();
            CharSequence text = "Sytral Buslines Loaded";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        });


        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinText = parent.getItemAtPosition(position).toString();
                ImageButton ticket = (ImageButton) rootView.findViewById(R.id.ticketplease);
                ticket.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(),MessageListActivity.class);
                        intent.putExtra("getData",spinText);
                        intent.putExtra("entreprise",MainFragment.identity);
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        loadGif(imageView);





        return rootView;
    }

    private void loadGif(ImageView iv){

        try {
            ImageDecoder.Source source =
                    ImageDecoder.createSource(getResources(),
                            R.drawable.paper);

            Drawable drawable = ImageDecoder.decodeDrawable(source);
            iv.setImageDrawable(drawable);

            if (drawable instanceof AnimatedImageDrawable) {
                ((AnimatedImageDrawable) drawable).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

    }
}