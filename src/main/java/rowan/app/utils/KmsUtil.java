package rowan.app.utils;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.DecryptResult;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;
import java.nio.ByteBuffer;

@Component
public class KmsUtil {

    private static final String KEY_ID = "c26441eb-6664-492b-a4a1-e652655a9f7d";

    private static final BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAWPDUVMWFG3FYURN6", "NoBA5VGhQRuKe/oANYpjwHeRnFJCrGumFjgX6uVw");

    private static final AWSKMS kmsClient = AWSKMSClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .withRegion(Regions.AP_NORTHEAST_2)
            .build();

    public String decrypt(String input){

        DecryptRequest decryptRequest = new DecryptRequest();

        decryptRequest.setKeyId(KEY_ID);
        decryptRequest.setCiphertextBlob(ByteBuffer.wrap(Base64.decodeBase64(input)));

        try{

            DecryptResult decryptResult = kmsClient.decrypt(decryptRequest);

            ByteBuffer plaintextKey = decryptResult.getPlaintext();

            return new String(Base64.encodeBase64(plaintextKey.array()));

        }catch (Exception e) {

            System.out.println("Here");
            return "";
        }
    }

}
