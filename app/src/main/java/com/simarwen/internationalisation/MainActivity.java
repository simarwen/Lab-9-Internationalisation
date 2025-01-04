package com.simarwen.internationalisation;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ListView countryListView;
    private MaterialButton languageButton;
    private ArrayAdapter<String> countryAdapter;
    private String currentLanguage = "en";
    private String[] languageOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        countryListView = findViewById(R.id.countryListView);
        languageButton = findViewById(R.id.languageButton);
        languageOptions = getResources().getStringArray(R.array.language_options);

        setupLanguageButton();
        loadCountryList();

    }

    private void setupLanguageButton() {
        languageButton.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, languageButton);
            popupMenu.getMenu().add(0, 0, 0, languageOptions[0]);
            popupMenu.getMenu().add(0, 1, 0, languageOptions[1]);
            popupMenu.getMenu().add(0, 2, 0, languageOptions[2]);



            popupMenu.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();
                switch (id) {
                    case 0:
                        setAppLocale("en");
                        currentLanguage = "en";
                        break;
                    case 1:
                        setAppLocale("fr");
                        currentLanguage = "fr";
                        break;
                    case 2:
                        setAppLocale("ar");
                        currentLanguage = "ar";
                        break;
                }
                languageButton.setText(getLanguageName());
                loadCountryList();
                return true;
            });
            popupMenu.show();
        });


    }
    private String getLanguageName() {
        switch (currentLanguage) {
            case "en":
                return languageOptions[0];
            case "fr":
                return languageOptions[1];
            case "ar":
                return languageOptions[2];
            default:
                return languageOptions[0];
        }
    }

    private void loadCountryList() {
        String[] countryArray = getResources().getStringArray(R.array.country_names);
        countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countryArray);
        countryListView.setAdapter(countryAdapter);
    }
    private void setAppLocale(String localeCode){
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        Locale newLocale = new Locale(localeCode);
        Locale.setDefault(newLocale);
        config.setLocale(newLocale);
        resources.updateConfiguration(config, displayMetrics);
        onConfigurationChanged(config);


    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        languageButton.setText(getLanguageName());
    }

}