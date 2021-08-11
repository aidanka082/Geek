package noteFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geek.R;
import com.example.geek.databinding.FragmentNoteBinding;

import adapter.TaskAdapter;
import model.NoteModel;
import room.App;

public class NoteFragment extends Fragment {
    private FragmentNoteBinding binding;
    private NoteModel noteModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNoteBinding.inflate(getLayoutInflater(),container, false);
        save();
        return binding.getRoot();
    }

    private void save() {
        binding.save.setOnClickListener(v -> {
            String text = binding.etText.getText().toString().trim();
            noteModel = new NoteModel(text);
            Bundle bundle = new Bundle();
            bundle.putSerializable("not", noteModel);
            getParentFragmentManager().setFragmentResult("title", bundle);
            close();
        });
    }

    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
        navController.navigateUp();
    }

}