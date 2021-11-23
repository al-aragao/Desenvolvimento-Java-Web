package br.edu.infnet.app.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;



@Service
public class AmazonService {
	
	private AmazonS3 s3client;
	@Value("${aws.key}")
	private String key;
	@Value("${aws.secret}")
	private String secret;
	@Value("${aws.region}")
	private String region;
	@Value("${aws.bucketName}")
	private String bucket;

	@PostConstruct
	private void initializeAmazon() {
		s3client = AmazonS3ClientBuilder.standard().withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(key, secret))).build();
	}
	
	public List<String> getAllFileNames(){
		List<String> fileNames = new ArrayList<String>();
		
		ObjectListing objects = s3client.listObjects(bucket);
		
		List<S3ObjectSummary> summaries = objects.getObjectSummaries();
		
		if(summaries !=null) {
			for (S3ObjectSummary object : summaries) {				
				fileNames.add(object.getKey());
			}
		}
		
		return fileNames;
	}
	
	public void save(File file) {
		s3client.putObject(new PutObjectRequest(bucket, file.getName() + "_Api", file));
	}
	
	public void delete(String fileName) {
		s3client.deleteObject(bucket, fileName);
	}
	
	public File getFile(String fileName) throws IOException {
		S3Object object = s3client.getObject(bucket, fileName);
		S3ObjectInputStream stream = object.getObjectContent();
		byte[] bytes = stream.readAllBytes();
		File file = File.createTempFile("temp", fileName);
		FileOutputStream outputStream = new FileOutputStream(file);
		outputStream.write(bytes);
		stream.close();
		outputStream.close();
		return file;
	}
	
	public void save(MultipartFile multipartFile) {
		try {
			File file = convertMultiPartToFile(multipartFile);
			save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File finalFile = new File(file.getOriginalFilename());
		FileOutputStream outputStream = new FileOutputStream(finalFile);
		outputStream.write(file.getBytes());
		outputStream.close();
		return finalFile;
	}
}

