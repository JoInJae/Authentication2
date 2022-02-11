package rowan.app.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class S3Util {

    private static final BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAWPDUVMWFL4WSCONE", "MLwxEUHbHCuJK0+SvsAZlU8Hv9K02vDLzU6Sw0ga");

    private static final AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion(Regions.AP_NORTHEAST_2)
            .build();

    private static final String jwt_key_bucket = "sb-data-key-manage";

    public String getJsonWebTokenKey() throws IOException {

        S3Object s3object = s3Client.getObject(new GetObjectRequest(jwt_key_bucket, "jwt/secret/key.txt"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(s3object.getObjectContent()));

        return reader.readLine();

    }

}
