MainActivity.User user = new MainActivity.User(dataOfBirth, Double.parseDouble(weight), Double.parseDouble(height));
GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());

DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

ref.child("users").child(account.getId()).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
    @Override
    public void onSuccess(Void aVoid) {
        Toast.makeText(UserInfoUpdate.this, "User Info Update Success!", Toast.LENGTH_SHORT).show();
    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {
        // Write failed
        // ...
        Toast.makeText(UserInfoUpdate.this, "User Info Update Failed!", Toast.LENGTH_SHORT).show();
    }
});


DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

// DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Users").child("Field 1");
Map<String, Object> updates = new HashMap<String,Object>();
updates.put("key", gender); // Values 

ref.child("users").child(account.getId()).updateChildren(updates).addOnSuccessListener(new OnSuccessListener<Void>() {
    @Override
    public void onSuccess(Void aVoid) {
        Toast.makeText(getApplicationContext(), "User Info Update Success!", Toast.LENGTH_SHORT).show();
    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {
        // Write failed
        Toast.makeText(getApplicationContext(), "User Info Update Failed!", Toast.LENGTH_SHORT).show();
    }
});
