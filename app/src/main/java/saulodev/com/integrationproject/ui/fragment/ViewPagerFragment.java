package saulodev.com.integrationproject.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentViewPagerBinding;

public class ViewPagerFragment extends Fragment {

    private FragmentViewPagerBinding binding = null;
   // private List<CardOffers> listCards = new ArrayList<>();
    private ViewPager2 viewPager2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addList();

        viewPager2 = binding.container;

        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        //ListAdapter adapter = new ListAdapter(listCards);
        //viewPager2.setAdapter(adapter);

        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);

        viewPager2.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {

                float ref = 1 - Math.abs(position);
                page.setScaleY(0.85f + ref * 0.15f);
            }
        });

    }

    public void addList(){
        //CardOffers card = new Card();
        //card.setBackgorund(getActivity().getDrawable(R.drawable.imagem);
        //listCards.add(card);
    }
}
