package com.example.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox football, basketball, tennisRacket, badmintonRacket;
    private TextView quantityTextView, priceTextView, ratingTextView;
    private RatingBar ratingBar;
    private Button incrementBtn, decrementBtn, orderBtn;

    private int quantity = 0;
    private final int pricePerItem = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        football = findViewById(R.id.football);
        basketball = findViewById(R.id.basketball);
        tennisRacket = findViewById(R.id.tennis_racket);
        badmintonRacket = findViewById(R.id.badminton_racket);
        quantityTextView = findViewById(R.id.quantityTextView);
        priceTextView = findViewById(R.id.priceTextView);
        ratingBar = findViewById(R.id.ratingBar);
        ratingTextView = findViewById(R.id.rating);
        incrementBtn = findViewById(R.id.increment);
        decrementBtn = findViewById(R.id.decrement);
        orderBtn = findViewById(R.id.order_btn);

        incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                updateQuantityAndPrice();
            }
        });

        decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 0) {
                    quantity--;
                } else {
                    Toast.makeText(MainActivity.this, "Quantity cannot be less than 0", Toast.LENGTH_SHORT).show();
                }
                updateQuantityAndPrice();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingTextView.setText("Rating: " + String.valueOf(rating));
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder selectedEquipment = new StringBuilder("Selected Equipment: ");

                if (football.isChecked()) {
                    selectedEquipment.append("Football ");
                }
                if (basketball.isChecked()) {
                    selectedEquipment.append("Basketball ");
                }
                if (tennisRacket.isChecked()) {
                    selectedEquipment.append("Tennis Racket ");
                }
                if (badmintonRacket.isChecked()) {
                    selectedEquipment.append("Badminton Racket ");
                }

                if (selectedEquipment.toString().equals("Selected Equipment: ")) {
                    Toast.makeText(MainActivity.this, "Please select at least one item!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, selectedEquipment.toString() + "\nTotal Price: BDT " + calculateTotalPrice(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void updateQuantityAndPrice() {
        quantityTextView.setText(String.valueOf(quantity));
        priceTextView.setText("BDT " + calculateTotalPrice());
    }

    private int calculateTotalPrice() {
        return quantity * pricePerItem;

    }
}