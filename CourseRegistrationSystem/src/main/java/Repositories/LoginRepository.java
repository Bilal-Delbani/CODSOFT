package Repositories;

import BackEnd.ConnectFirebase;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginRepository {
    private static ConnectFirebase conn;
    private static Firestore firestore;
    private static CollectionReference contracts;
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public LoginRepository() {
        try {
            conn = new ConnectFirebase();
            firestore = conn.getConn();
            contracts = firestore.collection("Contract");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CompletableFuture<Boolean> checkUser(String enteredUsername, String enteredPassword) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                ApiFuture<QuerySnapshot> querySnapshot = contracts.get();
                List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
                for (QueryDocumentSnapshot document : documents) {
                    String username = document.getString("EMAIL").split("@")[0];
                    String password = document.getString("PASSWORD");
                    if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }, executorService);
    }
}
