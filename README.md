# Persona Mobile Ads SDK
Persona Mobile Ads SDK enables android app developers to display digital advertisements on their android apps using Persona's ad network. This SDK provides seamless integration with Java and Kotlin based Android apps.

## Set up your app in your Persona publisher's account
Register your app in the Persona platform by completing the following steps:
1. Sign in or Sign up as a publisher on the Persona account.
2. Register your app and create ad units for the registered apps. You will get an API key which you will use in the later steps. You will also get adUnitId for each adUnit that you create.

## Configure your app
1. Add the dependencies for the Persona Mobile Ads SDK to your module's app-level Gradle file, normally **app/build.gradle**
   dependencies.

```
dependencies {
  implementation("io.persona3.android.pms:mobile-ad-sdk:0.0.2")
}
```

2. Add your API key and the environment(development or production) to your app's **AndroidManifest.xml** file. To do so, add a **\<meta-data\>** tag with **android:name="io.persona3.android.pms.ads.API_KEY"**.
   You will find your api key in the Persona UI. Use environment as **development** while integrating the SDK, change it to **production** before deploying it to live url.
   For example-
```
 <manifest>
    <application>
        <!--Sample apiKey: XXX_api_key_2_XXX-->
        <meta-data
            android:name="io.persona3.android.pms.ads.API_KEY"
            android:value="XXX_api_key_2_XXX"/>
        <meta-data
            android:name="io.persona3.android.pms.ads.ENVIRONMENT"
            android:value="development"/>
    </application>
 </manifest>
```


## Initialize the Persona Mobile Ads SDK

Before loading the ads make sure to initialize the Persona Ad SDK. It’s highly recommended to do this as early as possible in the app’s lifecycle. Here’s an example-



### Kotlin
```
import io.persona3.android.pms.ads.PersonaAdSDK

class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)

       PersonaAdSDK.initialize(this)
   }
 }
```
### Java
```
import io.persona3.android.pms.ads.PersonaAdSDK;

public class MainActivity extends ComponentActivity {
   @Override
   public void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

      PersonaAdSDK.Companion.initialize(this);
   }
}
```

## Display Banner Ad

**1. Add AdView to the layout-**
The first step toward displaying a banner is to place AdView in the layout for the Activity or Fragment in which you'd like to display it. The easiest way to do this is to add one to the corresponding XML layout file.
<br /><br />Here's an example that shows an activity's AdView:

```
<!--    Sample adUnitId: 4582921a-a66d-4e3c-b717-261b315371a7-->
    <io.persona3.android.pms.ads.AdView
        android:id="@+id/adView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:adUnitId="4582921a-a66d-4e3c-b717-261b315371a7"/>
```
You will find the adUnitId in Persona UI.

**2. Load an ad-**
Here's an example that shows how to load an ad in the onCreate() method of an Activity:

**Kotlin**
```
package …

import…
import io.persona3.android.pms.ads.AdRequest
import io.persona3.android.pms.ads.AdView
import io.persona3.android.pms.ads.PersonaAdSDK

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        PersonaAdSDK.initialize(this)

        val mAdView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}
```

**Java**
```
package …

import …

import io.persona3.android.pms.ads.AdRequest;
import io.persona3.android.pms.ads.AdView;
import io.persona3.android.pms.ads.PersonaAdSDK;

public class MainActivity extends ComponentActivity {
   @Override
   public void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       
       setContentView(R.layout.activity_main);

      PersonaAdSDK.Companion.initialize(this);

       AdView adView = findViewById(R.id.adView);
       AdRequest adRequest = new AdRequest.Builder().build();
       adView.loadAd(adRequest);
   }
}
```
## Troubleshooting Points

1. **Use physical devices:** It is recommended to use physical devices for testing the integration instead of emulators. Emulators may sometimes have issues related to caching or network connectivity.

2. **Resetting emulators:** If you are using emulators and facing issues, you can try wiping the data and cold booting the emulator. This can help resolve some problems related to cached data or system state.

3. **Check internet connectivity:** Ensure that your emulator or physical device has a stable internet connection. If the device is unable to connect to the internet, it may cause issues with ad loading. You can try restarting the device or connecting to a different network.

4. **Verify API key and adUnitId:** Double-check that you have correctly added your API key and adUnitId in the `AndroidManifest.xml` file. Make sure the values are accurate and match the ones provided by Persona's publisher account.

5. **Check initialization:** Ensure that you have properly initialized the Persona Mobile Ads SDK in your app's `onCreate()` method or at the appropriate place in your app's lifecycle. Confirm that you are calling the `PersonaAdSDK.initialize()` method with the correct context.

6. **Verify layout configuration:** Check your XML layout file where the `AdView` is placed. Make sure the `AdView` has the correct ID assigned and the `app:adUnitId` attribute is set to the appropriate adUnitId provided by Persona.

7. **Test on multiple devices:** Test your app integration on multiple devices with different screen sizes, resolutions, and Android versions. This can help identify any device-specific issues or layout problems that may arise.

8. **Check logs for errors:** Monitor the logs of your app while testing the integration. Look for any error messages or exceptions related to the Persona Mobile Ads SDK. These logs can provide valuable insights into the cause of the issue.

9. **Contact Persona support:** If you have followed all the troubleshooting steps and are still experiencing issues, reach out to Persona's support team for further assistance. They can provide specific guidance based on your integration and help resolve any technical difficulties you may be facing.
