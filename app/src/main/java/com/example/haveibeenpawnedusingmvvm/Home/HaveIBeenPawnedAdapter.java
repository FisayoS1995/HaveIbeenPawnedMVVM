package com.example.haveibeenpawnedusingmvvm.Home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.haveibeenpawnedusingmvvm.Net.PawnedRepo;
import com.example.haveibeenpawnedusingmvvm.R;

import java.util.ArrayList;
import java.util.List;

public class PawnedAdapter extends RecyclerView.Adapter<PawnedAdapter.PawnedViewHolder> {

    private final List<PawnedRepo> PawnedRepos = new ArrayList<>();

    public void setData(List<PawnedRepo> data) {
        PawnedRepos.clear();
        PawnedRepos.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PawnedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootview = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view, viewGroup, false);
        return new PawnedViewHolder(rootview);
    }

    @Override
    public void onBindViewHolder(@NonNull PawnedViewHolder pawnedViewHolder, int position) {
        PawnedRepo PawnedRepo = PawnedRepos.get(position);
        pawnedViewHolder.tvName.setText(PawnedRepo.getName());
        pawnedViewHolder.tvTitle.setText(PawnedRepo.getTitle());
        pawnedViewHolder.tvDomain.setText(PawnedRepo.getDomain());
        pawnedViewHolder.tvBreachDate.setText(PawnedRepo.getBredachDate());
        pawnedViewHolder.tvAddedDate.setText(PawnedRepo.getAddeDate());
        pawnedViewHolder.tvModDate.setText(PawnedRepo.getModifiedDate());
    }

    @Override
    public int getItemCount() {
        return PawnedRepos.size();
    }

    static class PawnedViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvTitle;
        TextView tvDomain;
        TextView tvBreachDate;
        TextView tvDescription;
        TextView tvAddedDate;
        TextView tvModDate;

        public PawnedViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDomain = itemView.findViewById(R.id.tvDomain);
            tvBreachDate = itemView.findViewById(R.id.tvBreachDate);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvAddedDate = itemView.findViewById(R.id.tvAddDate);
            tvModDate = itemView.findViewById(R.id.tvModDate);
        }
    }
}