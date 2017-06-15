package com.goldenictsolutions.win.jobready365_.employer.Empr_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.goldenictsolutions.win.jobready365_.R;
import com.goldenictsolutions.win.jobready365_.employer.Empr_datastore.Empr_Candidate_count;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zarni on 6/13/17.
 */

public class Candidate_adapter_employer extends RecyclerView.Adapter<Candidate_adapter_employer.ViewHolder> {

    private ArrayList<Empr_Candidate_count>candidates;
    private Context context;
    // private Movie movie;

    public Candidate_adapter_employer(Context applicationContext, ArrayList<Empr_Candidate_count> movieArrayList) {
        this.context =applicationContext;
        this.candidates=movieArrayList;
    }

    @Override
    public Candidate_adapter_employer.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.empr_dash_role, viewGroup, false);
        return new Candidate_adapter_employer.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(Candidate_adapter_employer.ViewHolder viewHolder, int position) {
        viewHolder.title.setText(candidates.get(position).getJob_tile());
        // viewHolder.actors.setText(String.valueOf(candidates.get(position).getJob_count()));//viewHolder.imageView.setImageURI(movies.get(i).getCover());
    }


    @Override
    public int getItemCount() {
        return candidates.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, year, actors;
        private ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.empr_dash_jobin);
            // year = (TextView) view.findViewById(R.id.textView_update_at);


            // on item click
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // get position
//                    int pos = getAdapterPosition();
//                    // check if item still exists
//                    if(pos != RecyclerView.NO_POSITION){
//                        Movie clickedDataItem = movies.get(pos);
//                        Intent intent = new Intent(context, DetailActivity.class);
//                        intent.putExtra("movie_title", movies.get(pos).getTitle());
//                        intent.putExtra("movie_actors", movies.get(pos).getActors());
//                        intent.putExtra("movie_cover", movies.get(pos).getCover());
//                        intent.putExtra("movie_director", movies.get(pos).getDirector());
//                        intent.putExtra("movie_year", movies.get(pos).getYear());
//                        intent.putExtra("movie_plot", movies.get(pos).getPlot());
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        context.startActivity(intent);
//                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getTitle(), Toast.LENGTH_SHORT).show();
//                    }
                }
            });
        }
    }

    /* Within the RecyclerView.Adapter class */
    // Clean all elements of the recycler
    public void clear() {
        candidates.clear();
        notifyDataSetChanged();
    }

    //RecyclerView mRecycler;
    // Add a list of ites
    public void addAll(int position, List<Empr_Candidate_count> mov) {
        candidates.addAll(0,mov);
        notifyItemInserted(0);
        //mRecycler.smoothScrollToPosition(0);
        notifyDataSetChanged();
    }
}