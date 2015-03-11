package chris.com.slider;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 3/1/2015.
 */
public class MyMemoryBox_Fragment extends Fragment  {
    EditText nameTXT,descriptionTXT;
    List<Contact> Contacts = new ArrayList<>();
    GridView contactGridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        View rootView = inflater.inflate(R.layout.my_memory_box_layout, container, false);

        contactGridView = (GridView)rootView.findViewById(R.id.gridView);
    //Get the tabHost setup
       //Where they are stored
        TabHost tabHost = (TabHost) rootView.findViewById(R.id.tabHost);
        tabHost.setup();TabHost.TabSpec tabSpec= tabHost.newTabSpec("List");

        tabHost.setup();
        tabSpec.setContent(R.id.tabContactList);
        tabSpec.setIndicator("List");
        tabHost.addTab(tabSpec);


        //adding someone


        tabSpec = tabHost.newTabSpec("Creator");
        tabSpec.setContent(R.id.tabCreator);
        tabSpec.setIndicator("Creator");
        tabHost.addTab(tabSpec);


    //get the Editable texts
        nameTXT = (EditText) rootView.findViewById(R.id.theNameTXT);
        descriptionTXT = (EditText) rootView.findViewById(R.id.theDescriptionTXT);

        final Button addPerson = (Button) rootView.findViewById(R.id.addThePersonBTN);
        addPerson.setEnabled(false);
        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact(nameTXT.getText().toString(),descriptionTXT.getText().toString());
                populateGrid();
                Toast.makeText(getActivity(),nameTXT.getText().toString() +" has been added ",Toast.LENGTH_SHORT).show();
            }
        });

         //set The add button enabled if user adds data to edit text
             nameTXT.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
            addPerson.setEnabled(!nameTXT.getText().toString().trim().isEmpty());
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });

        return rootView;
    }
    private void populateGrid(){
        ArrayAdapter<Contact> adapter = new ContactListAdapter();
        contactGridView.setAdapter(adapter);
    }
    private void addContact(String name, String description){
        Contacts.add(new Contact(name, description));
    }

    private class ContactListAdapter extends ArrayAdapter<Contact>{
        public ContactListAdapter(){
            super(getActivity(),R.layout.listview_item, Contacts);
        }// End ContactListAdpter
        @Override
        public View getView(int position, View v, ViewGroup parent) {
            if (v == null)
                v = getActivity().getLayoutInflater().inflate(R.layout.listview_item, parent, false);

            Contact currentContact = Contacts.get(position);

            TextView name = (TextView) v.findViewById(R.id.contactName);
            name.setText(currentContact.getName());
            TextView description = (TextView) v.findViewById(R.id.contactDescription);
            description.setText(currentContact.getDescription());

            return v;
        }// End getView
    }// End ContactListAdapter Class


}



