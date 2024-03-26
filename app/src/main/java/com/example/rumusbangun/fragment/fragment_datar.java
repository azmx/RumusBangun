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
import com.example.rumusbangun.modelbangun;

import java.util.ArrayList;
import java.util.List;

public class fragment_datar extends Fragment implements AdapterBangun.ItemClickListener {

    RecyclerView rvBangunDatar;
    List<modelbangun> listDataBangunDatar;
    AdapterBangun adapter;

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
        return inflater.inflate(R.layout.fragment_datar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBangunDatar = view.findViewById(R.id.rvBangun);
        listDataBangunDatar = new ArrayList<>();

        modelbangun persegi = new modelbangun();
        persegi.setNamaBangun("Persegi");
        persegi.setDesc("S x S ");
        persegi.setImageBangun("https://awsimages.detik.net.id/community/media/visual/2022/08/16/bujur-sangkar.jpeg?w=1037");
        listDataBangunDatar.add(persegi);

        modelbangun segitiga = new modelbangun();
        segitiga.setNamaBangun("Segitiga");
        segitiga.setDesc("L = 1/2 x a x t");
        segitiga.setImageBangun("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Green_equilateral_triangle_point_up.svg/200px-Green_equilateral_triangle_point_up.svg.png");
        listDataBangunDatar.add(segitiga);

        modelbangun PersegiPanjang = new modelbangun();
        PersegiPanjang.setNamaBangun("Persegi Panjang");
        PersegiPanjang.setDesc("P x L x T");
        PersegiPanjang.setImageBangun("https://imgx.sonora.id/crop/0x0:0x0/x/photo/2022/10/07/1jpg-20221007101405.jpg");
        listDataBangunDatar.add(PersegiPanjang);

        modelbangun lingkaran = new modelbangun();
        lingkaran.setNamaBangun("Lingkaran");
        lingkaran.setDesc("Phi x r x r");
        lingkaran.setImageBangun("https://mamatematika.files.wordpress.com/2016/11/179.png");
        listDataBangunDatar.add(lingkaran);

        rvBangunDatar.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AdapterBangun(listDataBangunDatar, getContext());
        rvBangunDatar.setAdapter(adapter);
        adapter.setClickListener(this);


    }

    @Override
    public void onItemClick(View view, int position) {
        if (adapter.getItem(position).getNamaBangun().equals("Lingkaran")) {
            Intent intent = new Intent(getActivity(), lingkaran.class);
            startActivity(intent);
        }else if (adapter.getItem(position).getNamaBangun().equals("Persegi")) {
            Intent intent = new Intent(getActivity(), persegi.class);
            startActivity(intent);
        }else if (adapter.getItem(position).getNamaBangun().equals("Persegi Panjang")) {
            Intent intent = new Intent(getActivity(), persegiPanjang.class);
            startActivity(intent);
        }else if (adapter.getItem(position).getNamaBangun().equals("Segitiga")) {
            Intent intent = new Intent(getActivity(), segitiga.class);
            startActivity(intent);
        }
    }
}