userViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
    @Override
    public void onChanged(@Nullable String s) {
        // Google Auth Instant
        final GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getActivity());
        mDatabase = FirebaseDatabase.getInstance().getReference("users").child(account.getId());

        if(account != null){
            text_user_info_display_username.setText(account.getDisplayName());
            /*  Call Firebase Database */
            mDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    MainActivity.User userInfo = dataSnapshot.getValue(MainActivity.User.class);
                    textViewDOB.setText(userInfo.getDateOfbirth());
                    textViewWeight.setText(userInfo.getWeight().toString());
                    textViewHeight.setText(userInfo.getHeight().toString());
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
});
