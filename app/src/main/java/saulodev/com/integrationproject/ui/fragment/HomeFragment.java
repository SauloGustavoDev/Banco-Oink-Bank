package saulodev.com.integrationproject.ui.fragment;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentHomeBinding;
import saulodev.com.integrationproject.model.CardOffers;
import saulodev.com.integrationproject.ui.adapter.ListAdapter;
import saulodev.com.integrationproject.ui.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding bind = null;
    private HomeViewModel mViewModel;
    private List<CardOffers> listCards = new ArrayList<>();
    private ViewPager2 viewPager2;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        bind = FragmentHomeBinding.inflate(inflater, container,false);
        return bind.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        bind.homeLayout.setBackgroundColor(getThemeBackgroundColor());

        addList();

        viewPager2 = getView().findViewById(R.id.container);

        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        ListAdapter adapter = new ListAdapter(requireActivity(),listCards);
        viewPager2.setAdapter(adapter);

        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);

        viewPager2.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {

                float ref = 1 - Math.abs(position);
                page.setScaleY(0.90f + ref * 0.10f);
            }
        });

        int inputTypePass = bind.saldoUserTxt.getInputType();
        bind.saldoUserTxt.setInputType(inputTypePass);

        bind.hideBtn.setOnClickListener(view1 ->{
            int inputType = bind.saldoUserTxt.getInputType();

            if(inputType == inputTypePass){
                bind.hideBtn.setBackground(getResources().getDrawable(R.drawable.ic_eye_visibility));
                bind.saldoUserTxt.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
            }else {
                bind.saldoUserTxt.setInputType(inputTypePass);
                bind.hideBtn.setBackground(getResources().getDrawable(R.drawable.ic_eye_visibility_off));
            }
        });

        bind.editarDadosArea.setOnClickListener(view1 -> {
            replaceEditarFragment();
        });
/*
        bind.pixBtn.setOnClickListener(view1 -> {
            replacePixFragment();
        });

 */
    }


    private void replacePixFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new AreaPixFragment()).addToBackStack(null).commit();
    }

    private void replaceEditarFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new EditFragment()).addToBackStack(null).commit();
    }

    public int getThemeBackgroundColor() {
        TypedArray array = getActivity().getTheme().obtainStyledAttributes(
                new int[] { android.R.attr.colorBackground });
        int backgroundColor = array.getColor(0, 0xFF00FF);
        array.recycle();
        return backgroundColor;
    }

    public void addList(){
        CardOffers card = new CardOffers();
        card.setOffer(R.drawable.ic_offerimg);
        listCards.add(card);

        CardOffers card1 = new CardOffers();
        card1.setOffer(R.drawable.ic_offerimg);
        listCards.add(card1);

        CardOffers card2 = new CardOffers();
        card2.setOffer(R.drawable.ic_offerimg);
        listCards.add(card2);
    }


}