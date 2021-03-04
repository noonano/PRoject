package app.dev.project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter <NotesAdapter.ViewHolder> {

    private ArrayList<Notes> notesArrayList;
    ItemClicked activity;

    public interface ItemClicked{
        void onItemClick(int index);
        void onItemDelete(int index);
    }

    public NotesAdapter(Context context, ArrayList<Notes> list){
        notesArrayList = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView displayName, displayContent;
        ImageView delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            displayName = itemView.findViewById(R.id.displayName);
            displayContent = itemView.findViewById(R.id.displayContent);
            delete = itemView.findViewById(R.id.delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClick(getAdapterPosition());
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(v.getContext())
                            .setIcon(R.drawable.warning)
                            .setTitle("Are You Sure? ")
                            .setMessage("Do you want to delete this item")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    activity.onItemDelete(getAdapterPosition());
                                }
                            })
                            .setNegativeButton("No", null)
                            .show();
                }
            });
        }
    }

    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.ViewHolder holder, int position) {
        holder.displayName.setText(notesArrayList.get(position).getName());
        holder.displayContent.setText(notesArrayList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return notesArrayList.size();
    }
}
