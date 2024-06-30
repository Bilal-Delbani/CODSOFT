package BackEnd;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import java.io.FileInputStream;

public class ConnectFirebase {
    private String serviceAccountKeyFile;
    private FileInputStream serviceAccount;
    private FirestoreOptions firestoreOptions;
    private Firestore firestore;

    public ConnectFirebase() {
        try {
            // Path to your service account key file
            serviceAccountKeyFile = "C:\\Users\\HES\\IdeaProjects\\CODSOFT\\CourseRegistrationSystem\\serviceAccount.json";

            // Initialize Firestore using the service account credentials
            serviceAccount = new FileInputStream(serviceAccountKeyFile);
            firestoreOptions = FirestoreOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            firestore = firestoreOptions.getService();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public Firestore getConn(){
        return firestore;
    }
}