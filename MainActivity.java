package com.flendzzinterview.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import com.flendzzinterview.myapplication.domain.Address;
import com.flendzzinterview.myapplication.domain.Company;
import com.flendzzinterview.myapplication.domain.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    RecyclerView recyclerView;
    EmployeeAdapter adapter;
    List<Employee> employees;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        employees = new ArrayList<>();
        try {
            readDataFromServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        recyclerView = findViewById(R.id.flendzz_main_activity_recyclerview);




//        Employee e1 = new Employee();
//        e1.setEmployeeid(1);
//        e1.setName("Leanne Graham");
//        e1.setUserName("Bret");
//        e1.setEmail("Sincere@april.biz");
//        Address address = new Address();
//        address.setLongtitude(81.1496);
//        address.setLat(-37.3159);
//        address.setStreet("Kulas Light");
//        e1.setAddress(address);
//        Company company1 = new Company();
//        company1.setName("Romaguera-Crona");
//        company1.setCatchPhrase("Multi-layered client-server neural-net");
//        company1.setBs("harness real-time e-markets");
//        e1.setPhoneNumber("1-770-736-8031 x56442");
//        e1.setWebSite("hildegard.org");
//        e1.setCompanydetails(company1);
//
//        Employee e2 = new Employee();
//        e2.setEmployeeid(2);
//        e2.setName("Ervin Howell");
//        e2.setUserName("Antonette");
//        e2.setEmail("Shanna@melissa.tv");
//        address = new Address();
//        address.setLongtitude(38293892.3928);
//        address.setLat(3489489.4893);
//        address.setStreet("Victor Plains");
//        e2.setAddress(address);
//        Company company2 = new Company();
//        company2.setName("Deckow-Crist");
//        company2.setCatchPhrase("Proactive didactic contingency");
//        company2.setBs("synergize scalable supply-chains");
//        e2.setCompanydetails(company2);
//        e2.setPhoneNumber("010-692-6593 x09125");
//        e2.setWebSite("anastasia.net");


//
//        Employee e3 = new Employee();
//        e3.setEmployeeid(3);
//        e3.setName("Clementine Bauch");
//        e3.setUserName("Samantha");
//        e3.setEmail("Nathan@yesenia.net");
//        address = new Address();
//        address.setLongtitude(-47.0653);
//        address.setLat(-68.6102);
//        address.setStreet("Douglas Extension");
//        e3.setAddress("Kattie Turnpike", "suite 847",
//                "city McKenziehaven",
//                "zipcode 59590-4157");
//
//        Company company3 = new Company();
//        company3.setName("Deckow-Crist");
//        company3.setCatchPhrase( "Proactive didactic contingency");
//        company3.setBs( "synergize scalable supply-chains");
//        e3.setPhoneNumber("010-692-6593 x09125");
//        e3.setWebSite("anastasia.net");
//
//
//        Employee e4 = new Employee();
//        e4.setEmployeeid(4);
//        e4.setName("Patricia Lebsack");
//        e4.setUserName("Karianne");
//        e4.setEmail("Julianne.OConner@kory.org");
//        address = new Address();
//        address.setLongtitude(-164.2990);
//        address.setLat(29.4572);
//        address.setStreet("Hoeger Mall");
//        e4.setAddress("Kattie Turnpike", "suiteApt. 692",
//                "city South Elvis",
//                "zipcode 53919-4257");
//
//        Company company4 = new Company();
//        company4.setName("Robel-Corkery");
//        company4.setCatchPhrase("Multi-tiered zero tolerance productivity");
//        company4.setBs("transition cutting-edge web services");
//        e4.setPhoneNumber("493-170-9623 x156");
//        e4.setWebSite("kale.biz");
//
//
//
//
//        Employee e5 = new Employee();
//        e5.setEmployeeid(5);
//        e5.setName("Chelsey Dietrich");
//        e5.setUserName("Kamren");
//        e5.setEmail("Lucio_Hettinger@annie.ca");
//        address = new Address();
//        address.setLongtitude(62.5342);
//        address.setLat(-31.8129);
//        address.setStreet("Skiles Walks");
//        e5.setAddress("Kattie Turnpike", "suite Suite 351",
//                "city  Roscoeview",
//                "zipcode 33263");
//
//        Company company5 = new Company();
//        company5.setName("Keebler LLC");
//        company5.setCatchPhrase("User-centric fault-tolerant solution");
//        company5.setBs("revolutionize end-to-end systems");
//        e5.setPhoneNumber("(254)954-1289");
//        e5.setWebSite("demarco.info");
//
//        Employee e6 = new Employee();
//        e6.setEmployeeid(6);
//        e6.setName("Mrs. Dennis Schulist");
//        e6.setUserName("Leopoldo_Corkery");
//        e6.setEmail("Karley_Dach@jasper.info");
//        address = new Address();
//        address.setLongtitude(71.7478);
//        address.setLat(-71.4197);
//        address.setStreet( "Norberto Crossing");
//        e6.setAddress("Kattie Turnpike", "suite Apt. 950",
//                "city  South Christy",
//                "zipcode 23505-1337");
//
//        Company company6 = new Company();
//        company6.setName("Considine-Lockman");
//        company6.setCatchPhrase("Synchronised bottom-line interface");
//        company6.setBs("e-enable innovative applications");
//        e6.setPhoneNumber("1-477-935-8478 x6430");
//        e6.setWebSite("ola.org");
//
//
//        Employee e7 = new Employee();
//        e7.setEmployeeid(7);
//        e7.setName("Kurtis Weissnat");
//        e7.setUserName("Elwyn.Skiles");
//        e7.setEmail("Telly.Hoeger@billy.biz");
//        address = new Address();
//        address.setLongtitude(21.8984);
//        address.setLat(24.8918);
//        address.setStreet( "Rex Trail");
//        e7.setAddress("Kattie Turnpike", "Suite 280",
//                "city Howemouth",
//                "zipcode 58804-1099");
//
//        Company company7 = new Company();
//        company7.setName("Johns Group");
//        company7.setCatchPhrase("Configurable multimedia task-force");
//        company7.setBs("generate enterprise e-tailers");
//        e7.setPhoneNumber("210.067.6132");
//        e7.setWebSite("elvis.io");
//
//
//
//        Employee e8 = new Employee();
//        e8.setEmployeeid(8);
//        e8.setName("Nicholas Runolfsdottir V");
//        e8.setUserName("Maxime_Nienow");
//        e8.setEmail("Sherwood@rosamond.me");
//        address = new Address();
//        address.setLongtitude(-20.7677);
//        address.setLat(-14.3990);
//        address.setStreet( "Ellsworth Summit");
//        e8.setAddress("Kattie Turnpike", "Suite 729",
//                "city Aliyaview",
//                "zipcode 45169");
//
//        Company company8 = new Company();
//        company8.setName("Abernathy Group");
//        company8.setCatchPhrase("Implemented secondary concept");
//        company8.setBs("e-enable extensible e-tailers");
//        e8.setPhoneNumber("586.493.6943 x140");
//        e8.setWebSite("jacynthe.com");
//
//
//        Employee e9 = new Employee();
//        e9.setEmployeeid(9);
//        e9.setName("Glenna Reichert");
//        e9.setUserName("Delphine");
//        e9.setEmail("Chaim_McDermott@dana.io");
//        address = new Address();
//        address.setLongtitude(-168.8889);
//        address.setLat(24.6463);
//        address.setStreet( "Dayna Park");
//        e9.setAddress("Kattie Turnpike", "Suite 449",
//                "city Bartholomebury",
//                "zipcode 76495-3109");
//        Company company9 = new Company();
//        company9.setName( "Yost and Sons");
//        company9.setCatchPhrase("Switchable contextually-based project");
//        company9.setBs("aggregate real-time technologies");
//        e9.setPhoneNumber("(775)976-6794 x41206");
//        e9.setWebSite("conrad.com");
//
//        Employee e10 = new Employee();
//        e10.setEmployeeid(10);
//        e10.setName("Clementina DuBuque");
//        e10.setUserName("Moriah.Stanton");
//        e10.setEmail("Rey.Padberg@karina.biz");
//        address = new Address();
//        address.setLongtitude(57.2232);
//        address.setLat(-38.2386);
//        address.setStreet("Kattie Turnpike");
//        e10.setAddress(     "Kattie Turnpike",
//                "Suite 198",
//                "city Lebsackbury",
//                "zipcode 31428-2261");
//
//        Company company10 = new Company();
//        company10.setName( "Hoeger LLC");
//        company10.setCatchPhrase("Centralized empowering task-force");
//        company10.setBs("target end-to-end models");
//        e10.setPhoneNumber("024-648-3804");
//        e10.setWebSite("ambrose.net");


      //  employees.add(e1);
      //  employees.add(e2);
//        employees.add(e3);
//        employees.add(e4);
//        employees.add(e5);
//        employees.add(e6);
//        employees.add(e7);
//        employees.add(e8);
//        employees.add(e9);
//        employees.add(e10);

        intRecyclerview();

    }

    private void intRecyclerview() {
        adapter = new EmployeeAdapter(employees, MainActivity.this);
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

    }


    private void readDataFromServer() throws IOException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Gson gson = new GsonBuilder().create();
        Type REVIEW_TYPE = new TypeToken<List<Employee>>() {}.getType();


        URL githubEndpoint = new URL("https://jsonplaceholder.typicode.com/users");
        HttpsURLConnection myConnection =
                (HttpsURLConnection) githubEndpoint.openConnection();

        if (myConnection.getResponseCode() == 200) {
            Log.i(TAG, "readDataFromServer: Response code : " + myConnection.getResponseCode());
            InputStream responseBody = myConnection.getInputStream();
            InputStreamReader responseBodyReader =
                    new InputStreamReader(responseBody, "UTF-8");
            JsonReader jsonReader = new JsonReader(responseBodyReader);
            List<Employee> data = gson.fromJson(jsonReader,REVIEW_TYPE);
            Log.i(TAG, "readDataFromServer: size of employees : "+data.toString());
            employees.addAll(data);

        } else {
            Log.i(TAG, "readDataFromServer: Not successful to retrieve data");
        }


    }
}
