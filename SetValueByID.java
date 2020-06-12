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
