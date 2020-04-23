package vn.edu.hust.mail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import vn.edu.hust.mail.R;
import vn.edu.hust.mail.model.MailModel;

public class MailAdapter extends BaseAdapter {

    List<MailModel> mailModelList;

    public MailAdapter(List<MailModel> mailModelList){
        this.mailModelList = mailModelList;
    }

    @Override
    public int getCount() {
        return mailModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return mailModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {

        final ViewHolder viewHolder;

        if(view == null){
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_view_gmail,
                        viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.content = view.findViewById(R.id.content);
                viewHolder.header = view.findViewById(R.id.header);
                viewHolder.name = view.findViewById(R.id.txtName);
                viewHolder.txtBackground = view.findViewById(R.id.txtBackground);
                viewHolder.timeStamp = view.findViewById(R.id.timeStamp);
                viewHolder.imageFavorite = view.findViewById(R.id.image_favorite);
                viewHolder.imageAvatar = view.findViewById(R.id.imageAvatar);
                viewHolder.element = view.findViewById(R.id.element);
                view.setTag(viewHolder);
        } else {
                viewHolder = (ViewHolder) view.getTag();
        }

        final MailModel mailModel = mailModelList.get(position);

        viewHolder.txtBackground.setText(mailModel.getName().substring(0, 1));
        viewHolder.timeStamp.setText(mailModel.getTimeStamp());
        viewHolder.name.setText(mailModel.getName());
        viewHolder.header.setText(mailModel.getHeader());
        viewHolder.content.setText(mailModel.getContent());

        if(mailModel.isFavorite()) viewHolder.imageFavorite.setImageResource(R.drawable.favorite);
        else viewHolder.imageFavorite.setImageResource(R.drawable.normal);

        viewHolder.imageFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isFavorite = mailModelList.get(position).isFavorite();
                mailModelList.get(position).setFavorite(!isFavorite);
                notifyDataSetChanged();
            }
        });

        viewHolder.txtBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isSelected = mailModelList.get(position).isChoosen();
                mailModelList.get(position).setChoosen(!isSelected);
                viewHolder.imageAvatar.setVisibility(View.VISIBLE);
                viewHolder.txtBackground.setVisibility(View.INVISIBLE);
                viewHolder.name.setBackgroundColor(0x0000BBBB);
                notifyDataSetChanged();
            }
        });

        viewHolder.imageAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isSelected = mailModelList.get(position).isChoosen();
                mailModelList.get(position).setChoosen(!isSelected);
                viewHolder.imageAvatar.setVisibility(View.INVISIBLE);
                viewHolder.txtBackground.setVisibility(View.VISIBLE);
                viewHolder.name.setBackgroundColor(0x0000FFFF);
                notifyDataSetChanged();
            }
        });

        return view;
    }

    class ViewHolder{
        TextView txtBackground;
        TextView name;
        TextView header;
        TextView content;
        TextView timeStamp;
        ImageView imageFavorite;
        ImageView imageAvatar;
        LinearLayout element;
    }
}
