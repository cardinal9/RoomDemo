package com.example.room.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room.Model.User;
import com.example.room.R;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView userItemView;

        private UserViewHolder(View view) {
            super(view);
            userItemView = view.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater inflater;
    private List<User> users;

    public UserListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserListAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.UserViewHolder holder, int position) {
        if (users != null) {
            User current = users.get(position);
            holder.userItemView.setText(current.getmUser());
        } else {
            holder.userItemView.setText("No user found!");
        }
    }

    public void setUsers(List<User> mUsers) {
        users = mUsers;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (users != null)
        return users.size();
        else return 0;
    }
}
