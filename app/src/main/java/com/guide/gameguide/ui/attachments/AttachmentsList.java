package com.guide.gameguide.ui.attachments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guide.gameguide.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AttachmentsList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AttachmentsList extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AttachmentsList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment attachmentsrecyler.
     */
    // TODO: Rename and change types and number of parameters
    public static AttachmentsList newInstance(String param1, String param2) {
        AttachmentsList fragment = new AttachmentsList();
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
    RecyclerView recyclerView;
    List<Integer> img;
    List<String> l1,l2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView;
         img=new ArrayList<Integer>();
         l1 = new ArrayList<String>();
         l2 = new ArrayList<String>();

        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_attachmentsrecyler, container, false);
        AttachmentAdapter attachmentAdapter = new AttachmentAdapter(container.getContext(),img.stream().mapToInt(i->i).toArray(),l1.toArray(new String[l1.size()]),l2.toArray(new String[l1.size()]));
        recyclerView = (RecyclerView) rootView.findViewById(R.id.attachmentslist);

        return rootView;
    }
}