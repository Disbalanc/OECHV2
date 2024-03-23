package com.example.oech.Profile.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.oech.Adapters.AdsRecycler
import com.example.oech.Adapters.MyAds
import com.example.oech.R


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        val root = inflater.inflate(R.layout.fragment_home,container,false)
        val RecyclerViewAds: RecyclerView =root.findViewById(R.id.RecyclerViewAds)
        RecyclerViewAds.adapter = AdsRecycler(requireContext(), MyAds().list)

        return root
    }


}