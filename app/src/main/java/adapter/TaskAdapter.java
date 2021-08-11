package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.geek.R;

import java.util.ArrayList;
import java.util.List;

import model.NoteModel;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    List<NoteModel> list ;

    public void addText (NoteModel text){
        list.add(text);
    }
    public void setList (List<NoteModel> models){
        list.clear();
        list.addAll(models);
        notifyDataSetChanged();
    }
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskAdapter.ViewHolder holder, int position) {
        holder.title.setText((CharSequence) list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tit);
        }

    }
}
