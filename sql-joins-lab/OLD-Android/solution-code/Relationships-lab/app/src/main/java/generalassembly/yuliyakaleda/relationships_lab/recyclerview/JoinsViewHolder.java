package generalassembly.yuliyakaleda.relationships_lab.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by drewmahrt on 10/27/16.
 */

public class JoinsViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextView;


    public JoinsViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(android.R.id.text1);
    }
}
