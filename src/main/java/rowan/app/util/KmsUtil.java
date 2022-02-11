package rowan.app.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.GenerateDataKeyRequest;
import com.amazonaws.services.kms.model.GenerateDataKeyResult;
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


    public String generate(){

        GenerateDataKeyRequest request = new GenerateDataKeyRequest();

        request.setKeyId(KEY_ID);
        request.setKeySpec("AES_256");

        GenerateDataKeyResult dataKeyResult = kmsClient.generateDataKey(request);

        ByteBuffer plaintextKey = dataKeyResult.getPlaintext();

        return new String(Base64.encodeBase64(plaintextKey.array()));

    }

}
