-optimizationpasses 5
-keepattributes SourceFile,LineNumberTable

##--------------- Begin: proguard configuration for logging ----------
-assumenosideeffects class android.util.Log {
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}

-assumenosideeffects public class java.lang.Throwable {
    public void printStackTrace();
}
##--------------- End: proguard configuration for logging ----------

##--------------- Begin: proguard configuration for greenrobot event bus  ----------
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
##--------------- End: proguard configuration for greenrobot event bus  ----------
