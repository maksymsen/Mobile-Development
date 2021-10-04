package ca.gbc.comp3074.lab3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopBarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TopBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TopBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TopBarFragment newInstance(String param1, String param2) {
        TopBarFragment fragment = new TopBarFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_bar, container, false);

        Button left = view.findViewById(R.id.btnLeft);
        Button right = view.findViewById(R.id.btnRight);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // click left and get to frag 1
                // left button now needs to be disabled
                if (right.isEnabled()) {
                    requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentScreen, FirstFragment.class, null)
                        .commit();
                    left.setEnabled(false);
                } else {
                    requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentScreen, SecondFragment.class, null)
                        .commit();
                    right.setEnabled(true);
                }
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (left.isEnabled()) {
                    requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentScreen, ThirdFragment.class, null)
                        .commit();
                    right.setEnabled(false);
                } else {
                    requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentScreen, SecondFragment.class, null)
                        .commit();
                    left.setEnabled(true);
                }
            }
        });

        return view;
    }
}