package com.example.caloriestracker_2602141890;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ArrayList<CustomFoodItem> foodItemList;
    private ArrayAdapter<CustomFoodItem> foodItemAdapter;
    private ListView foodItemListView;
    private TextView totalCaloriesTextView;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodItemList = new ArrayList<>();
        foodItemAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foodItemList);

        foodItemListView = findViewById(R.id.lv_foods);
        totalCaloriesTextView = findViewById(R.id.tv_calories);
        addButton = findViewById(R.id.btn_add);

        foodItemListView.setAdapter(foodItemAdapter);
        foodItemListView.setOnItemClickListener(this);
        addButton.setOnClickListener(this);
    }

    private void updateTotalCalories() {
        double totalCalories = 0.0;
        for (CustomFoodItem item : foodItemList) {
            totalCalories += item.getItemCalories();
        }
        totalCaloriesTextView.setText("Total Calories: " + totalCalories);
    }

    @Override
    public void onClick(View v) {
        if (v == addButton) {
            CustomDialogUtil.showAddFoodDialog(this, new CustomDialogUtil.FoodDialogListener() {
                @Override
                public void onFoodAdded(String itemName, double itemCalories) {
                    foodItemList.add(new CustomFoodItem(itemName, itemCalories));
                    foodItemAdapter.notifyDataSetChanged();
                    updateTotalCalories();
                }
            });
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent == foodItemListView) {
            CustomFoodItem selectedItem = foodItemList.get(position);
            Toast.makeText(MainActivity.this, selectedItem.getDetails(), Toast.LENGTH_SHORT).show();
        }
    }
}
