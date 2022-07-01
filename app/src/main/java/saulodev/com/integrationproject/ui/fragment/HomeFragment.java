package saulodev.com.integrationproject.ui.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.List;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentHomeBinding;
import saulodev.com.integrationproject.model.CardOffers;
import saulodev.com.integrationproject.ui.activity.AreaPixActivity;
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


        bind.btnVisibility.setOnClickListener(view1 -> {
            Animation animation_baixo = AnimationUtils.loadAnimation(getActivity(), R.anim.animation_baixo);
            Animation animation_cima = AnimationUtils.loadAnimation(getActivity(), R.anim.animation_cima);
            Animation animation_btn = AnimationUtils.loadAnimation(getActivity(), R.anim.animation_btn);

        if (bind.layoutGone.getVisibility() == View.GONE){
            bind.layoutGone.setVisibility(View.VISIBLE);
            bind.layoutGone.startAnimation(animation_baixo);
            bind.btnVisibility.startAnimation(animation_btn);
            bind.btnVisibility.setImageResource(R.drawable.ic_seta_cima);
        }else {
            bind.layoutGone.startAnimation(animation_cima);
            bind.layoutGone.setVisibility(View.GONE);
            bind.btnVisibility.startAnimation(animation_btn);
            bind.btnVisibility.setImageResource(R.drawable.ic_seta_baixo);
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

        bind.pixBtn.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), AreaPixActivity.class);
            startActivity(intent);
        });

    }


    private void replacePixFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new AreaPixFragment()).addToBackStack(null).commit();
    }

    private void replaceEditarFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new EditFragment()).addToBackStack(null).commit();
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