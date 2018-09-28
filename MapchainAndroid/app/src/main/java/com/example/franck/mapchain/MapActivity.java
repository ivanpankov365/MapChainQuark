package com.example.franck.mapchain;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franck.mapchain.maps.untils.GetDirectionsData;
import com.example.franck.mapchain.models.ContractModel;
import com.example.franck.mapchain.models.CoordinateModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static android.support.v4.content.PermissionChecker.PERMISSION_GRANTED;

public class MapActivity extends AppCompatActivity implements GoogleMap.OnMyLocationButtonClickListener, OnMapReadyCallback {

    private static final int LOCATION_REQUEST_CODE = 1;
    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private NaviParser firstNavi = new NaviParser();
    private NaviParser secondNavi = new NaviParser();
    private NaviParser thirdNavi = new NaviParser();
    private static int countQuest = 0;
    private NaviParser parser = new NaviParser();
    private final static float DEFAULT_ZOOM = 12f;
    private ImageView imageView;
    private boolean ethContract = false;
    private String line;
    private TextView textView;
    private ContractModel person;
    private Marker marker;

    private Button nxtBtn;
    private Button stopBtn;
    private final static int PROXIMITY_RADIUS = 1000_00000;
    private double latitude = 1d, longitude = 2d;
    private Object dataTransfer[];
    private Circle mCircle;
    private double end_latitude = 4d, end_longitude = 6d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_map);

        nxtBtn = findViewById(R.id.nexBtn);
        stopBtn = findViewById(R.id.infoBtn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageView = findViewById(R.id.place_info);
        textView = findViewById(R.id.infoPoint);
        firstNavi.setAddresss("703498");
        secondNavi.setAddresss("703499");
        thirdNavi.setAddresss("703500");
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        person = (ContractModel)getIntent().getSerializableExtra("MyClass");
        Log.d("tag",person.getAddress());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (savedInstanceState == null) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.setRetainInstance(true);
            mapFragment.getMapAsync(this);
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!ethContract) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MapActivity.this).create();
                    alertDialog.setTitle("Here description quest");
                    alertDialog.setMessage(person.getDescription());
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();

                                }
                            });
                    alertDialog.show();
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(MapActivity.this).create();
                    alertDialog.setTitle("Here description quest");
                    alertDialog.setMessage(parser.parserRes(line).getDescription());
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();

                                }
                            });
                    alertDialog.show();
                }
                try {
                    if(marker.isInfoWindowShown()) {
                        marker.hideInfoWindow();
                    } else {
                        marker.showInfoWindow();
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                //drawDirection(null,null);
            }
        });

        nxtBtn.setText("Start and pay");
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MapActivity.this).create();
                alertDialog.setTitle("Do you want to stop this game ?");
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                onBackPressed();
                            }
                        });
                alertDialog.show();
            }
        });
        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ethContract) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MapActivity.this).create();
                    alertDialog.setTitle("Do you want pay " + person.getPrice() + " wey ?");
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    ethContract = true;
                                    nxtBtn.setText("Next");
                                    stopBtn.setVisibility(View.VISIBLE);
                                    stopBtn.setText("Stop");
                                    nxtBtn.callOnClick();
                                }
                            });
                    alertDialog.show();
                }
                if(ethContract) {
                    countQuest++;
                    switch (countQuest) {
                        case 1:
                            parser = firstNavi;
                            break;
                        case 2:
                            parser = secondNavi;
                            break;
                        case 3:
                            parser = thirdNavi;
                            break;
                            default: countQuest = 0;
                    }

                    if(countQuest == 0) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MapActivity.this).create();
                        alertDialog.setTitle("Quest Complete!");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        onBackPressed();
                                    }
                                });
                        alertDialog.show();
                    }
                    nextStep(parser);

                }
            }
        });
    }

    public void nextStep(NaviParser parser) {
        line = "";
        try {
            line = new AsyncTaskP().execute(NaviParser.URL+parser.getContainer()+"/"+parser.getAddresss()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        String title = parser.parserRes(line).getName();
        moveCamera(new CoordinateModel( parser.parserCoordinates(line).getLatitude(), parser.parserCoordinates(line).getLongitute()), DEFAULT_ZOOM, title);
        textView.setText(textView.getText() + "\n" + title);
    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        initMap();

    }

    public void drawDirection(LatLng latLng1, LatLng latLng2) {
        dataTransfer = new Object[3];
        String url = getDirectionsUrl();
        GetDirectionsData getDirectionsData = new GetDirectionsData();
        dataTransfer[0] = mMap;
        dataTransfer[1] = url;
        dataTransfer[2] = new LatLng(end_latitude, end_longitude);
        getDirectionsData.execute(dataTransfer);
    }

    private void moveCamera(CoordinateModel coordinateModel, float zoom, String title) {
        LatLng latLng = new LatLng(coordinateModel.getLatitude(), coordinateModel.getLongitute());
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,zoom));

        mMap.clear();

//        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(MapActivity.this));


        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .title(title);
        marker = mMap.addMarker(markerOptions);
    }

    private void getDeviceLocation() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }

            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                // Logic to handle location object
                                String title = "Your first point";
                                moveCamera(new CoordinateModel(location.getLatitude(), location.getLongitude()),DEFAULT_ZOOM, title);
                                textView.setText(textView.getText() + "\n" + title);
                            } else {
                                String title = person.getDescription();
                                CoordinateModel coordinateModel = new CoordinateModel(Double.parseDouble(person.getLat()), Double.parseDouble(person.getLog()));
                                moveCamera(coordinateModel,DEFAULT_ZOOM, title);
                                LatLng latLng = new LatLng(coordinateModel.getLatitude(), coordinateModel.getLongitute());
                                if(mCircle == null || marker == null){
                                    drawMarkerWithCircle(latLng,1000.0);
                                }else{
                                    updateMarkerWithCircle(latLng);
                                }
                                textView.setText(textView.getText() + "\n" + title);
                            }
                        }
                    });

        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private String getDirectionsUrl()
    {
        StringBuilder googleDirectionsUrl = new StringBuilder("https://maps.googleapis.com/maps/api/directions/json?");
        googleDirectionsUrl.append("origin="+latitude+","+longitude);
        googleDirectionsUrl.append("&destination="+end_latitude+","+end_longitude);
        googleDirectionsUrl.append("&key="+"AIzaSyCAcfy-02UHSu2F6WeQ1rhQhkCr51eBL9g");

        return googleDirectionsUrl.toString();
    }

    private String getUrl(double latitude, double longitude, String nearbyPlace)
    {
        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + PROXIMITY_RADIUS);
        googlePlacesUrl.append("&type=" + nearbyPlace);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + "AIzaSyBj-cnmMUY21M0vnIKz0k3tD3bRdyZea-Y");
        return (googlePlacesUrl.toString());
    }


    private void updateMarkerWithCircle(LatLng position) {
        mCircle.setCenter(position);
        marker.setPosition(position);
    }


    private void drawMarkerWithCircle(LatLng position, double radiusInMeters){
        int strokeColor = 0xffff0000; //red outline
        int shadeColor = 0x44ff0000; //opaque red fill

        CircleOptions circleOptions = new CircleOptions().center(position).radius(radiusInMeters).fillColor(shadeColor).strokeColor(strokeColor).strokeWidth(8);
        mCircle = mMap.addCircle(circleOptions);

        MarkerOptions markerOptions = new MarkerOptions().position(position);
        marker = mMap.addMarker(markerOptions);
    }


    private void initMap() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PERMISSION_GRANTED) {
            Toast.makeText(this, "Разрешение получено", Toast.LENGTH_LONG).show();;
            mMap.setMyLocationEnabled(true);
            mMap.setOnMyLocationButtonClickListener(this);
            getDeviceLocation();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Запрос разрешений на получение местоположения")
                    .setMessage("Нам нужно знать ваше местоположение")
                    .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ActivityCompat.requestPermissions(MapActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
                        }
                    })
                    .create()
                    .show();
        }
    }

    private class AsyncTaskP extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... voids){  BufferedReader inputStream = null;
            String jsonResult = "";
            URL jsonUrl;
            try {
                jsonUrl = new URL(voids[0]);

                URLConnection dc = jsonUrl.openConnection();

                dc.setConnectTimeout(5000);
                dc.setReadTimeout(5000);

                inputStream = new BufferedReader(new InputStreamReader(
                        dc.getInputStream()));

                String line = "";
                while((line = inputStream.readLine()) != null)
                    jsonResult += line;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return jsonResult;
        }
    }

}
