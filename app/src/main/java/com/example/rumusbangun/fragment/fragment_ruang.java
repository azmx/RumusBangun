package com.example.rumusbangun.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rumusbangun.AdapterBangun;
import com.example.rumusbangun.R;
import com.example.rumusbangun.bangunDatar.lingkaran;
import com.example.rumusbangun.bangunDatar.persegi;
import com.example.rumusbangun.bangunDatar.persegiPanjang;
import com.example.rumusbangun.bangunDatar.segitiga;
import com.example.rumusbangun.bangunRuang.balok;
import com.example.rumusbangun.bangunRuang.bola;
import com.example.rumusbangun.bangunRuang.kubus;
import com.example.rumusbangun.bangunRuang.tabung;
import com.example.rumusbangun.modelbangun;

import java.util.ArrayList;
import java.util.List;

public class fragment_ruang extends Fragment implements AdapterBangun.ItemClickListener  {

    RecyclerView rvBangun;
    List<modelbangun> modelbangunList;
    AdapterBangun adapterBangun;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ruang, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBangun = view.findViewById(R.id.rvBangunRuang);
        modelbangunList = new ArrayList<>();

        modelbangun kubus = new modelbangun();
        kubus.setNamaBangun("Kubus");
        kubus.setDesc("6 x s²");
        kubus.setImageBangun("https://cilacapklik.com/wp-content/uploads/2020/09/Pengertian-Kubus-Dan-Rumus-Kubus.png");
        modelbangunList.add(kubus);

        modelbangun bola = new modelbangun();
        bola.setNamaBangun("Bola");
        bola.setDesc("Luas Permukaan Bola = 4 x Luas Lingkaran (π x r²)");
        bola.setImageBangun("https://mmc.tirto.id/image/2023/07/31/ilustrasi-bola-sepak-istock_ratio-16x9.jpg");
        modelbangunList.add(bola);

        modelbangun tabung = new modelbangun();
        tabung.setNamaBangun("Tabung");
        tabung.setDesc("Luas permukaan tabung = 2 x Luas alas + Luas selimut tabung");
        tabung.setImageBangun("https://cdn1.katadata.co.id/media/images/thumb/2021/11/03/Gambar_tabung-2021_11_03-08_48_47_0ead895159087694917096eeb63ba669_960x640_thumb.png");
       modelbangunList.add(tabung);

        modelbangun balok = new modelbangun();
        balok.setNamaBangun("Balok");
        balok.setDesc("L = 2 x [(p x l) + (p x t) + (l x t)]");
        balok.setImageBangun("https://cdn1.katadata.co.id/media/images/thumb/2021/11/03/Gambar_Balok-2021_11_03-12_04_16_9084e501300e5cfe36a3aae453f02009_960x640_thumb.jpg");
       modelbangunList.add(balok);

        rvBangun.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterBangun = new AdapterBangun(modelbangunList, getContext());
        rvBangun.setAdapter(adapterBangun);
        adapterBangun.setClickListener(this);


    }

    @Override
    public void onItemClick(View view, int position) {
        if (adapterBangun.getItem(position).getNamaBangun().equals("Balok")) {
            Intent intent = new Intent(getActivity(), balok.class);
            startActivity(intent);
        }else if (adapterBangun.getItem(position).getNamaBangun().equals("Bola")) {
            Intent intent = new Intent(getActivity(), bola.class);
            startActivity(intent);
        }else if (adapterBangun.getItem(position).getNamaBangun().equals("Kubus")) {
            Intent intent = new Intent(getActivity(), kubus.class);
            startActivity(intent);
        }else if (adapterBangun.getItem(position).getNamaBangun().equals("Tabung")) {
            Intent intent = new Intent(getActivity(), tabung.class);
            startActivity(intent);
        }

    }
}