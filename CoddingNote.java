// Start Intent
Intent activityStartIntent = new Intent(ProfileActivity.this, UserProfileSetting.class);
ProfileActivity.this.startActivity(activityStartIntent);

//get the spinner from the xml.
Spinner dropdown = findViewById(R.id.WeightGoalSpinner);
//create a list of items for the spinner.
String[] items = new String[]{"1", "2", "three"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
dropdown.setAdapter(adapter);

// Text View Title
<!-- Ideal Weight Title -->
<TextView
android:id="@+id/IdealWeightTitle"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:layout_marginTop="10dp"
android:layout_marginBottom="10dp"
android:text="Ideal Weight Range" />


