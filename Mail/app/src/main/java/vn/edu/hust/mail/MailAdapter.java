package vn.edu.hust.mail;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MailAdapter extends BaseAdapter {

    List<ItemModel> itemModelList;

    public MailAdapter(List<ItemModel> itemModelList){
        this.itemModelList = itemModelList;
    }

    @Override
    public int getCount() {
        return itemModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemModelList.get(position);
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

        final ItemModel itemModel = itemModelList.get(position);

        viewHolder.txtBackground.setText(itemModel.name.substring(0, 1));
        viewHolder.timeStamp.setText(itemModel.timeStamp);
        viewHolder.name.setText(itemModel.name);
        viewHolder.header.setText(itemModel.header);
        viewHolder.content.setText(itemModel.content);

        if(itemModel.favorite) viewHolder.imageFavorite.setImageResource(R.drawable.favorite);
        else viewHolder.imageFavorite.setImageResource(R.drawable.normal);

        viewHolder.imageFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isFavorite = itemModelList.get(position).favorite;
                itemModelList.get(position).favorite = !isFavorite;
                notifyDataSetChanged();
            }
        });

        viewHolder.txtBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isSelected = itemModelList.get(position).choosen;
                itemModelList.get(position).choosen = !isSelected;
                viewHolder.imageAvatar.setVisibility(View.VISIBLE);
                viewHolder.txtBackground.setVisibility(View.INVISIBLE);
                viewHolder.name.setBackgroundColor(0x0000BBBB);
                notifyDataSetChanged();
            }
        });

        viewHolder.imageAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isSelected = itemModelList.get(position).choosen;
                itemModelList.get(position).choosen = !isSelected;
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
