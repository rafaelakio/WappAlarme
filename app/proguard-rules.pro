# Regras ProGuard para WappAlarme

# Manter modelos Room
-keep class br.com.wappalarme.data.model.** { *; }

# Manter classes Hilt
-keep class dagger.hilt.** { *; }
-keep @dagger.hilt.android.lifecycle.HiltViewModel class * { *; }

# Manter Workers
-keep class * extends androidx.work.Worker
-keep class * extends androidx.work.CoroutineWorker

# Manter Receivers
-keep class * extends android.content.BroadcastReceiver

# Manter AccessibilityService
-keep class * extends android.accessibilityservice.AccessibilityService

# Retrofit
-keepattributes Signature
-keepattributes Exceptions
-keep class retrofit2.** { *; }
-keep interface retrofit2.** { *; }

# Gson
-keep class com.google.gson.** { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
