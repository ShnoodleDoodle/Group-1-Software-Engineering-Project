How to Download and Run the App in Android Studio
1)	Install Android Studio
   
1.	To develop and run the app, you need to install Android Studio, which is an integrated development environment (IDE) provided by Google for Android app development.
2.	Visit the official Android Studio website(https://developer.android.com/studio) to download the latest version of Android Studio. The specific version is Android Studio Jellyfish, which is located at the top of their website.
3.	Choose the appropriate version for your operating system (Windows, macOS, or Linux).
4.	Follow the installation instructions provided on the website to install Android Studio on your computer.
   
2)	Download the ZIP File from GitHub
   
1.	To work with the app's source code, you first need to download the ZIP file from GitHub.
2.	Visit (https://github.com/ShnoodleDoodle/Group-1-Software-Engineering-Project) where the app's source code is hosted.
3.	Locate and click on the green "Code" button, which will give you several download options.
4.	Select the "Download ZIP" option to download the source code as a ZIP file to your computer.
   
3)	Extract the ZIP File
   
1.	After downloading the ZIP file, you need to extract it to access the app's source code.
2.	Navigate to the location where the ZIP file was downloaded.
3.	Right-click the ZIP file and select "Extract All" or "Unzip" depending on your operating system.
4.	Choose a location to extract the contents of the ZIP file.
   
4)	Open the Project in Android Studio
   
1.	Once you have extracted the ZIP file, you can open the app's project in Android Studio.
2.	Launch Android Studio.
3.	On the welcome screen, click "Open" and navigate to the directory where you extracted the app's source code.
4.	Select the root folder of the extracted project (it should contain the build.gradle file).
5.	Click "OK" to open the project in Android Studio.
   
5)	Run the App
   
1.	Once the project is open in Android Studio, you can run the app.
2.	If I brings up an error message about the wrong version of gradle file.
3.	Open your versions file, located on the left, and change your version to match what it tells you to.
4.	Click the "Run" button (a green play icon) in the toolbar.
5.	Android Studio will compile the app in the virtual phone.
6.	For the application to run correctly, please use the Pixel 7 pro Emulator as well as the API UpsideDownCakePrivacySandbox
   
   These are the versions we are using :
  	
  	[versions]
agp = "8.4.0-alpha12"
artifactid = "version"
kotlin = "1.9.0"
coreKtx = "1.12.0"
junit = "4.13.2"
junitVersion = "1.1.5"
espressoCore = "3.5.1"
appcompat = "1.6.1"
material = "1.11.0"
activity = "1.8.2"
constraintlayout = "2.1.4"
firebaseFirestoreKtx = "24.10.3"
recyclerview = "1.3.2"
googleGmsGoogleServices = "4.4.1"
firebaseDatabase = "20.3.1"
firebaseAuth = "22.3.1"
firebaseStorageKtx = "20.3.0"
firebaseStorage = "20.3.0"

as well as the implementations we are using which should already be included inside the provided .gradle file :

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.androidx.recyclerview)
    implementation(libs.firebase.database)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.storage.ktx)
    implementation(libs.firebase.storage)
    implementation("com.joanzapata.pdfview:android-pdfview:1.0.4@aar")
    implementation ("com.tom-roush:pdfbox-android:2.0.27.0")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("com.github.bumptech.glide:glide:4.14.2")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")


