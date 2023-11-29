package com.example.caloriestracker_2602141890;


import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class CustomDialogUtil {

    public interface FoodDialogListener {
        void onFoodAdded(String itemName, double itemCalories);
    }

    public static void showAddFoodDialog(Context context, FoodDialogListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.activity_add_food, null);

        EditText editItemName = dialogView.findViewById(R.id.et_foodName);
        EditText editItemCalories = dialogView.findViewById(R.id.et_foodcalories);

        builder.setView(dialogView)
                .setTitle("Add Item")
                .setPositiveButton("Add", (dialogInterface, i) -> {
                    String itemName = editItemName.getText().toString().trim();
                    String caloriesText = editItemCalories.getText().toString().trim();

                    if(TextUtils.isEmpty(itemName) || TextUtils.isEmpty(caloriesText)) {
                        Toast.makeText(context, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                    } else {
                        double itemCalories = Double.parseDouble(caloriesText);

                        if(listener != null) {
                            listener.onFoodAdded(itemName, itemCalories);
                        }
                    }

                })
                .setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.cancel());

        builder.create().show();
    }
}
