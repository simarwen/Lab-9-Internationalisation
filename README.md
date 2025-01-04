# Multi-Language Country List App

This Android application demonstrates how to create a dynamic country list that supports multiple languages (English, French, and Arabic) using Android's resource management system. It provides a clear example of how to change the application language and update the UI accordingly.

## Features

-   **Multi-Language Support:** Supports English, French, and Arabic for both country names and language selection.
-   **Dynamic Language Switching:** Allows users to change the app language via a dropdown menu.
-   **Localized UI:** The UI updates automatically with the selected language, providing a consistent user experience.
-   **Clean and Maintainable Code:** Demonstrates good practices in Android development for managing string resources and multiple languages.
-   **Material Design:** Uses a `MaterialButton` for a more modern dropdown menu.


## How to Use

1.  Clone the repository to your local machine:

    ```bash
    git clone https://github.com/simarwen/Lab-9-Internationalisation.git
    ```

2.  Open the project in Android Studio.
3.  Run the application on an emulator or a physical device.
4.  Use the dropdown menu to select a language (English, French, or Arabic).
5.  Observe that the country list and the language options in dropdown will be displayed in the selected language.

## Technical Details

-   **Language Management:** The application uses the `Locale` class along with Android resource directories (`values-en`, `values-fr`, `values-ar`) to load appropriate string resources based on the app language.
-   **Dropdown Menu:** A `MaterialButton` is used to act as a dropdown language selector.
-   **List Display:** `ListView` is used for displaying a list of countries.
-   **Configuration change handling:** Handles `onConfigurationChanged` to update the UI elements when a language change is made.
