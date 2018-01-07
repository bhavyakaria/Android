package sampleapplication.parzival.com.sampleapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Parzival on 07-01-2018.
 */

public class ModelClass {

    private String userName;
    private long id;

    public String getUserName() {
        return userName;
    }


    public long getId() {
        return id;
    }

    public static ModelClass fromJsonOjectToModel(JSONObject jsonObject) {
        ModelClass m = new ModelClass();

        try {
            m.userName = jsonObject.getString("login");
            m.id = jsonObject.getInt("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return m;
    }

    public static ArrayList<ModelClass> fromJsonArrayToJsonObject(JSONArray jsonArray) {

        JSONObject dataJson;
        ArrayList<ModelClass> data = new ArrayList<>(jsonArray.length());

        for (int i=0; i < jsonArray.length(); i++) {
            try {
                dataJson = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }

            ModelClass business = ModelClass.fromJsonOjectToModel(dataJson);
            if (business != null) {
                data.add(business);
            }
        }
        return data;
    }


}
