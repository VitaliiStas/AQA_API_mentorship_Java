package org.eleks.api.trello.data_provider;

import org.testng.annotations.DataProvider;

public class UserCredentialsDataProvider {
//todo fix to using object user
    @DataProvider(name = "userCredentials")
    public Object[][] userCredentials(){
        Object[][] obj= {{"tt8397519@gmail.com", "2596225962"}};

        return obj;
    }
}
