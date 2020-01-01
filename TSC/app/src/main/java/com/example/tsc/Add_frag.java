package com.example.tsc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Add_frag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Add_frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Add_frag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final int IMG_PICK_REQ = 55;
    private ImageView img;
    private HashMap<String,String> map;
    TextView key;
    TextView val;
    TextView name;
    TextView price;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Add_frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Add_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Add_frag newInstance(String param1, String param2) {
        Add_frag fragment = new Add_frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_lay, container, false);
        img = v.findViewById(R.id.add_img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(in,IMG_PICK_REQ);
            }
        });
        map = new HashMap<>();
        key = v.findViewById(R.id.add_field);
        val = v.findViewById(R.id.add_spec);
        name = v.findViewById(R.id.add_name);
        price = v.findViewById(R.id.add_price);
        Button add_to_map = v.findViewById(R.id.add_map_isert);
        add_to_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (key.getText().length() > 0 && val.getText().length() > 0){
                String k = key.getText().toString();
                String va = val.getText().toString();
                map.put(key.getText().toString(),val.getText().toString());
                } else
                    Toast.makeText(getContext(), "Fill both fields before adding to the spec", Toast.LENGTH_SHORT).show();
            }
        });
        Button ad = v.findViewById(R.id.add_item);
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().length()>0 || price.getText().length()>0){
                    String na = name.getText().toString();
                    String pr = price.getText().toString();
                    Item i = new Item(na,pr,map,"");
                    HashMap<String,Object> mm = new HashMap<>();
                    mm.put("name",na);
                    mm.put("price",pr);
                    mm.put("desc",map);
                    mm.put("img",null);

                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection("items")
                            .add(mm)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                                }
                            });
                    name.setText("");
                    price.setText("");
                    map.clear();
                    img.setImageResource(R.drawable.laptop_icon);
                } else
                    Toast.makeText(getContext(), "Fill Name and Price before adding new Item", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == IMG_PICK_REQ){
            if (resultCode == Activity.RESULT_OK){
                if (data.getData() != null){
                   Uri uri = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                        img.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                    } catch (IOException e) {
                    }
                }
            }
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
