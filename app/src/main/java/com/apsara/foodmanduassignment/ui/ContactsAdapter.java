package com.apsara.foodmanduassignment.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apsara.foodmanduassignment.R;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {
    Context mContext;
    List<Contacts> contactsList;
    private ContactsViewHolder holder;
    private int position;

    public ContactsAdapter(Context mContext, List<Contacts> contactsList) {
        this.mContext = mContext;
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_contacts, parent, false);
        return new ContactsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder contactsViewHolder, int i) {
//        Contacts contacts = contactsList.get(position);
//        holder.imgProfile.setImageResource(contacts.getimageId());
//        holder.tvName.setText(contacts.getName());
//        holder.tvPhoneNo.setText(contacts.getPhoneNo());
        final Contacts contacts=contactsList.get(i);
        contactsViewHolder.imglunch.setImageResource(contacts.getImageId());




    }
//


    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {

        ImageView imglunch;


        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            imglunch = itemView.findViewById(R.id.imglunch);






        }

    }
}
