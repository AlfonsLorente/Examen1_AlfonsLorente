package com.example.examen1_alfonslorente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.fragment.app.FragmentActivity;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrainingSeriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrainingSeriesFragment extends ListFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrainingSeriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrainingSeriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrainingSeriesFragment newInstance(String param1, String param2) {
        TrainingSeriesFragment fragment = new TrainingSeriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    ListView listView;
    private String[] seriesFragmentList = new String[Entrenament.entrenaments.length];


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        fillSeriesFragmentList();



    }

    @Override
    public void onStart() {
        super.onStart();
        listView = (ListView) getActivity().findViewById(android.R.id.list);
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.text_view_training_series, seriesFragmentList);
        listView.setAdapter(adapter);
    }

    private void fillSeriesFragmentList() {
        for(int i = 0; i < Entrenament.entrenaments.length; i++){
            seriesFragmentList[i] = Entrenament.entrenaments[i].getNom();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_training_series, container, false);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        MainActivity activity = (MainActivity) getActivity();
        activity.itemClicked(id);
    }

    static interface Listener {
        void itemClicked(long id);
    };

}