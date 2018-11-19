package com.example.souka.projet;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TakePhoto extends Fragment {

    private TakePhotoViewModel mViewModel;
    public static final int REQUEST_PERMISSION = 200;
    private static final int REQUEST_CAPTURE_IMAGE = 100;
    private String imageFilePath = "";
    private Button button;
    private ImageView imageView;

    InputStream inStream = null;
    OutputStream outStream = null;

    final String GalleryPath;

    {
        GalleryPath = Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DCIM + "/" + "Images/Camera";

        //don't want to create the directory why ?
        //GalleryPath = Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DCIM + "/" + "Images/Camera/lutinsApplications";
    }


    public static TakePhoto newInstance() {
        return new TakePhoto();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.content_photos, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
     //   mViewModel = ViewModelProviders.of(this).get(TakePhotoViewModel.class);
        // TODO: Use the ViewModel

    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        button = view.findViewById(R.id.button);
        imageView = view.findViewById(R.id.image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCameraIntent();
            }
        });

    }


    private void openCameraIntent() {
        Intent pictureIntent = new Intent(
                MediaStore.ACTION_IMAGE_CAPTURE);


        if(pictureIntent.resolveActivity(getActivity().getPackageManager()) != null){


            //Create a file to store the image
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            if (photoFile != null) {
                //take a photo
                //Uri photoURI = FileProvider.getUriForFile(this, "com.example.alexandre.applicamera2.provider", photoFile);

                Uri photoURI = FileProvider.getUriForFile(getActivity().getApplicationContext(), "com.example.alexandre.projectdrawermenubytemplate.provider", photoFile);

                //com.example.alexandre.applicamera2
                pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        photoURI);
                startActivityForResult(pictureIntent,
                        REQUEST_CAPTURE_IMAGE);
            }
        }

    }



    /**
     *
     * @return
     * @throws IOException
     */
    private File createImageFile() throws IOException {
        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss",
                        Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp + "_";
        //File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File storageDir = getActivity().getExternalFilesDir(null);

        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        imageFilePath = image.getAbsolutePath();
        return image;
    }


    /**
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        imageView.setImageURI(Uri.parse(imageFilePath));

        System.out.println("under RESULT_OK : ");

        File imagesFolder = new File(Environment.getExternalStorageDirectory() + "/" );

        imagesFolder.mkdirs();

        System.out.println("imagesFolder : " + imagesFolder);

        //------ camera stuff
        Intent imageIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        File image = new File(imagesFolder, "QR_" + timeStamp + ".jpg");

        Uri uriSavedImage = Uri.fromFile(image);

        System.out.println("imageFilePath : " + imageFilePath);

        //final directory
        System.out.println("GalleryPath : " + GalleryPath);
        String photoDir = Environment.getExternalStorageDirectory() + "/" ;


        System.out.println("photoDir : " + photoDir);

        try{

            File afile =new File(imageFilePath);
            File bfile =new File(GalleryPath, afile.getName());

            inStream = new FileInputStream(afile);

            System.out.println("inStream,  : " + inStream);


            System.out.println("here b. outStream  : " + outStream);

            outStream = new FileOutputStream(bfile);

            System.out.println("outStream before the while : " + outStream);

            System.out.println("File is copied successful!");


            byte[] buffer = new byte[1024];

            int length=0;

            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0){

                outStream.write(buffer, 0, length);
                System.out.println("outStream : " + outStream);
            }

            System.out.println("outStream after the while : " + outStream);

            inStream.close();
            outStream.close();
            System.out.println("File is copied successful!");

        }catch(Exception e){

            System.out.println("capture de la StackTrace : " );
            //no System.out use Log !!!
            Log.e("photo", "error", e);

        }
    }








}
