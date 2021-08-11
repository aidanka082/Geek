package com.example.geek.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.geek.databinding.FragmentHomeBinding;

import java.util.List;

import adapter.TaskAdapter;
import model.NoteModel;
import room.App;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TaskAdapter adapter;
    private NoteModel noteModel;
    List<NoteModel> list;

    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        intRecycler();
        getLayout();
        return binding.getRoot();

    }


    private void getLayout() {
        adapter = new TaskAdapter();
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void intRecycler() {
        getParentFragmentManager().setFragmentResultListener("title",getViewLifecycleOwner(),(requestKey, result) -> {
          noteModel = (NoteModel) result.get("not");
          adapter.addText(noteModel);


        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}