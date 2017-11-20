package za.co.codetribe.ukukhula.Groups;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import za.co.codetribe.ukukhula.R;
import za.co.codetribe.ukukhula.learner.LearnerProfile;

public class RegisteredLearnersAdapter extends ArrayAdapter<LearnerProfile> {

    private Context context;
    private List<LearnerProfile> profList;

    public RegisteredLearnersAdapter(Context context, int customprofilelist, List<LearnerProfile> profList) {
        super(context, 0 , profList);
        this.context = context;
        this.profList = profList;
    }



    @Override
    public int getCount()
    {
        return profList.size();
    }


    @Override
    public LearnerProfile getItem(int position)
    {
        return profList.get(position);
    }
    @Override
    public long getItemId(int position)
    {
        return position;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView ==null)
        {
            listItemView=  LayoutInflater.from(getContext()).inflate(R.layout.registeslearnerslist,parent,false);

        }
        LearnerProfile profList=this.getItem(position);

        TextView eName=(TextView)listItemView.findViewById(R.id.profileName);
        TextView eSurname=(TextView)listItemView.findViewById(R.id.profilesurname);
        TextView eDescription=(TextView)listItemView.findViewById(R.id.profileDob);
//        ImageView ePic = (ImageView)convertView.findViewById(R.id.pic);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);




//        eDescription.setText(profList.getChildsSurname());
//        eName.setText(profList.getChildsAge());
        eDescription.setText(profList.getNames());
        eName.setText(profList.getClassName());
        eSurname.setText(profList.getSurname());

//        eName.setText(profList.getChildsAddress());
//        eName.setText(profList.getChildsAllergies());
//        eName.setText(profList.getChildsFavmeal());
//        eName.setText(profList.getChildsPname());
//        eName.setText(profList.getChildsPcontact());

       /* convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context," My name is Khuthadzo Gundula", Toast.LENGTH_LONG).show();
            }
        });*/
        return listItemView;
    }
}
