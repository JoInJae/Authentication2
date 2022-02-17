package rowan.app.utils;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class S3Util {

    private static final BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAWPDUVMWFL4WSCONE", "MLwxEUHbHCuJK0+SvsAZlU8Hv9K02vDLzU6Sw0ga");

    private static final AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion(Regions.AP_NORTHEAST_2)
            .build();

    private static final String jwt_key_bucket = "sb-data-key-manage";

    public String getJwtKey(){

        try{

            ListObjectsV2Request listObjectsV2Request = new ListObjectsV2Request().withBucketName(jwt_key_bucket).withPrefix("jwt/key");

            ListObjectsV2Result listObjectsV2Result = s3Client.listObjectsV2(listObjectsV2Request);

            int index = listObjectsV2Result.getObjectSummaries().size() - 1;

            String key = listObjectsV2Result.getObjectSummaries().get(index).getKey();

            S3Object s3object = s3Client.getObject(new GetObjectRequest(jwt_key_bucket, key));

            BufferedReader reader = new BufferedReader(new InputStreamReader(s3object.getObjectContent()));

            return reader.readLine();

        }catch (Exception e){

            return "";

        }

    }

}
