package m2i.formation.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class IPersisterFactory {


    private JSONPersister jsonP;
    private XMLPersister xmlP;
    
    private Gson gson = new GsonBuilder().create();

    public IPersister createFormOperation(String evidanceForm) {
        if (evidanceForm.equals("JSON")) 
             return jsonP;

        else if (evidanceForm.equals("XML")) 
             return xmlP;

        return null;
    }
}
