JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, openweatherInclude7days, null, new Response.Listener<JSONObject>() {
    @Override
    public void onResponse(JSONObject Response) {
        // TODO Auto-generated method stub

        Log.i("JSON" , "" + "findWeather onResponse");

        try {

            JSONObject getWeatherCurrent = Response.getJSONObject("current");
            Double getWeatherTemp = getWeatherCurrent.getDouble("temp");

            JSONArray getWeatherDetails = getWeatherCurrent.getJSONArray("weather");
            JSONObject getWeatherDetailsObject = getWeatherDetails.getJSONObject(0);

            String weatherDescription = getWeatherDetailsObject.getString("description");
            String weatherIcon = getWeatherDetailsObject.getString("icon");

            textViewTemp_C.setText(getWeatherTemp.toString());
            textViewWx_desc.setText(weatherDescription);
            setWeatherIcon(weatherIcon);

        } catch (JSONException e) {
            Log.i("JSON" , "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError arg0) {
        // TODO Auto-generated method stub
        Log.i("JSON" , "Error: " + arg0);
    }
});

 RequestQueue queue = Volley.newRequestQueue(getContext());
queue.add(request);
queue.add(request_7days_weather);
