package com.poc.yml.newarchcomponentdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by diptika.shukla on 2/8/18.
 */
public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater layoutInflater;
    private List<Employee> employeeList; // Cached copy of words

    EmployeeListAdapter(Context context) { layoutInflater = LayoutInflater.from(context); }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (employeeList != null) {
            Employee current = employeeList.get(position);
            holder.wordItemView.setText(current.getEmployee());
        } else {
            holder.wordItemView.setText("No Employee");
        }
    }

    void setWords(List<Employee> employees){
        employeeList = employees;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (employeeList != null)
            return employeeList.size();
        else return 0;
    }
}
