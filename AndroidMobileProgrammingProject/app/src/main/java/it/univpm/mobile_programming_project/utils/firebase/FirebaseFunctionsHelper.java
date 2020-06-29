package it.univpm.mobile_programming_project.utils.firebase;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.functions.FirebaseFunctions;
import com.google.firebase.functions.HttpsCallableResult;

import java.util.HashMap;
import java.util.Map;

public class FirebaseFunctionsHelper {

    private FirebaseFunctions mFunctions;

    public FirebaseFunctionsHelper()
    {
        this.mFunctions = FirebaseFunctions.getInstance();
    }

    public Task< Boolean > isUserInitialized() {

        // Call the function and extract the result
        // exports.getUserInfo

        return this.mFunctions
            .getHttpsCallable("isUserInitialized")
            .call()
            .continueWith(new Continuation<HttpsCallableResult, Boolean>() {
                @Override
                public Boolean then(@NonNull Task<HttpsCallableResult> task) throws Exception {
                    HttpsCallableResult result = task.getResult();
                    Boolean resultData = (Boolean) result.getData();
                    return resultData;
                }
            });

    }

    public Task<Boolean> creaCasa(String nome, String indirizzo) {

        // Call the function and extract the result
        // exports.getUserInfo
        Map<String, Object> data = new HashMap<>();
        data.put("nome", nome);
        data.put("indirizzo", indirizzo);

        return this.mFunctions
            .getHttpsCallable("creaCasa")
            .call( data )
            .continueWith(new Continuation<HttpsCallableResult, Boolean>() {
                @Override
                public Boolean then(@NonNull Task<HttpsCallableResult> task) throws Exception {
                    HttpsCallableResult result = task.getResult();
                    Boolean resultData = (Boolean) result.getData();
                    return resultData;
                }
            });
    }


    public Task<Boolean> inserisciProprietario() {

        return this.mFunctions
            .getHttpsCallable("inserisciProprietario")
            .call(  )
            .continueWith(new Continuation<HttpsCallableResult, Boolean>() {
                @Override
                public Boolean then(@NonNull Task<HttpsCallableResult> task) throws Exception {
                    HttpsCallableResult result = task.getResult();
                    Boolean resultData = (Boolean) result.getData();
                    return resultData;
                }
            });
    }

    public Task<Boolean> partecipaCasa(String idCasa) {

        Map<String, Object> dataInput = new HashMap<>();
        dataInput.put("idCasa", idCasa);

        return this.mFunctions
            .getHttpsCallable("partecipaCasa")
            .call( dataInput )
            .continueWith(new Continuation<HttpsCallableResult, Boolean>() {
                @Override
                public Boolean then(@NonNull Task<HttpsCallableResult> task) throws Exception {
                    HttpsCallableResult result = task.getResult();
                    Boolean resultData = (Boolean) result.getData();
                    return resultData;
                }
            });
    }

    public Task<Boolean> inserisciAffittuario() {

        return this.mFunctions
                .getHttpsCallable("inserisciAffittuario")
                .call(  )
                .continueWith(new Continuation<HttpsCallableResult, Boolean>() {
                    @Override
                    public Boolean then(@NonNull Task<HttpsCallableResult> task) throws Exception {
                        HttpsCallableResult result = task.getResult();
                        Boolean resultData = (Boolean) result.getData();
                        return resultData;
                    }
                });
    }

    public Task<Boolean> registraUtente() {

        return this.mFunctions
                .getHttpsCallable("registraUtente")
                .call(  )
                .continueWith(new Continuation<HttpsCallableResult, Boolean>() {
                    @Override
                    public Boolean then(@NonNull Task<HttpsCallableResult> task) throws Exception {
                        HttpsCallableResult result = task.getResult();
                        Boolean resultData = (Boolean) result.getData();
                        return resultData;
                    }
                });
    }

}
