package com.udacity.sandwichclub.utils;

import android.widget.Toast;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich newSandwich;

    public static Sandwich parseSandwichJson(String json) throws JSONException
    {
        newSandwich = new Sandwich();
        JSONObject obj= new JSONObject(json);

        //length of JSON objects
        int length = obj.length();


        JSONObject name =obj.getJSONObject("name");
        newSandwich.setMainName(name.getString("mainName"));

        ArrayList<String> alsoKnownAs= new ArrayList<>();

        int lengthofknownas =name.getJSONArray("alsoKnownAs").length();

        if(lengthofknownas !=0)
        {
            for (int i = 0; i < lengthofknownas; i++)
            {
                String knownas = name.getJSONArray("alsoKnownAs").getString(i);
                alsoKnownAs.add(knownas);
            }
            newSandwich.setAlsoKnownAs(alsoKnownAs);
        }
        else
        {
            newSandwich.setAlsoKnownAs(null);
        }
        newSandwich.setPlaceOfOrigin(obj.getString("placeOfOrigin"));
        newSandwich.setDescription(obj.getString("description"));
        newSandwich.setImage(obj.getString("image"));

        ArrayList<String> ingredients= new ArrayList<>();

        int lengthofingredients =obj.getJSONArray("ingredients").length();

        if(lengthofingredients !=0)
        {
            for (int i = 0; i < lengthofingredients; i++)
            {
                String mingredients = obj.getJSONArray("ingredients").getString(i);
                ingredients.add(mingredients);
            }
            newSandwich.setIngredients(ingredients);
        }
        else
        {
            newSandwich.setIngredients(null);
        }


        return newSandwich;
    }
}
