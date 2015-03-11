package chris.com.slider;

/**
 * Created by Chris on 3/5/2015.
 */
public class Contact {
    private String _name, _description;


    public Contact(String name, String description){
        _name = name;
        _description = description;

    }
    public String getName(){
        return _name;
    }
    public String getDescription(){
        return _description;
    }
}
