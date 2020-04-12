package com.example.thejopipedia.RecylclerViewAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.thejopipedia.Perfil_Apuntes_Fragment;
import com.example.thejopipedia.Perfil_Puntos_Fragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    int cantidad;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int cantidad) {
        super(fm, cantidad);
        this.cantidad = cantidad;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position == 0){
            return new Perfil_Puntos_Fragment();
            }
        else if (position ==1) {
            return new Perfil_Apuntes_Fragment();
        }
        else return null;
    }

    @Override
    public int getCount() {
        return cantidad;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
