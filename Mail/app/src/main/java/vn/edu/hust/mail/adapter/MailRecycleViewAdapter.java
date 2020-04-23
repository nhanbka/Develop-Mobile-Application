package vn.edu.hust.mail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.hust.mail.MailItemClickListener;
import vn.edu.hust.mail.MainActivity;
import vn.edu.hust.mail.R;
import vn.edu.hust.mail.model.MailModel;

public class MailRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<MailModel> mailModelList;
    MailItemClickListener listener;

    public MailRecycleViewAdapter(List<MailModel> mailModelList){
        this.mailModelList = mailModelList;
    }

    public MailRecycleViewAdapter(List<MailModel> mailModelList, MailItemClickListener listener) {
        this.mailModelList = mailModelList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_gmail, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MailModel mailModel = mailModelList.get(position);
        ItemViewHolder viewHolder = (ItemViewHolder)holder;

        viewHolder.txtBackground.setText(mailModel.getName().substring(0, 1));
        viewHolder.timeStamp.setText(mailModel.getTimeStamp());
        viewHolder.name.setText(mailModel.getName());
        viewHolder.header.setText(mailModel.getHeader());
        viewHolder.content.setText(mailModel.getContent());

        if(mailModel.isFavorite()) viewHolder.imageFavorite.setImageResource(R.drawable.favorite);
        else viewHolder.imageFavorite.setImageResource(R.drawable.normal);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mailModelList.size();
    }

    public void filterList(ArrayList<MailModel> filterList){
        mailModelList = filterList;
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView txtBackground;
        TextView name;
        TextView header;
        TextView content;
        TextView timeStamp;
        ImageView imageFavorite;
        ImageView imageAvatar;
        LinearLayout element;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            content = itemView.findViewById(R.id.content);
            header = itemView.findViewById(R.id.header);
            name = itemView.findViewById(R.id.txtName);
            txtBackground = itemView.findViewById(R.id.txtBackground);
            timeStamp = itemView.findViewById(R.id.timeStamp);
            imageFavorite = itemView.findViewById(R.id.image_favorite);
            imageAvatar = itemView.findViewById(R.id.imageAvatar);
            element = itemView.findViewById(R.id.element);

            imageFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isFavorite = mailModelList.get(getAdapterPosition()).isFavorite();
                    mailModelList.get(getAdapterPosition()).setFavorite(!isFavorite);
                    notifyDataSetChanged();
                }
            });

            txtBackground.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isSelected = mailModelList.get(getAdapterPosition()).isChoosen();
                    mailModelList.get(getAdapterPosition()).setChoosen(!isSelected);
                    imageAvatar.setVisibility(View.VISIBLE);
                    txtBackground.setVisibility(View.INVISIBLE);
                    name.setBackgroundColor(0x0000BBBB);
                    notifyDataSetChanged();
                }
            });

            imageAvatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isSelected = mailModelList.get(getAdapterPosition()).isChoosen();
                    mailModelList.get(getAdapterPosition()).setChoosen(!isSelected);
                    imageAvatar.setVisibility(View.INVISIBLE);
                    txtBackground.setVisibility(View.VISIBLE);
                    name.setBackgroundColor(0x0000FFFF);
                    notifyDataSetChanged();
                }
            });

        }
    }
}
