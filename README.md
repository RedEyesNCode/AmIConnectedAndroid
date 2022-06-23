# AmIConnectedAndroid
Studied about Broadcast Receivers (Implicit &amp; Explicit ) it's changes experienced in Android 12.

##### So in order to implement a simple Implicit Broadcast reciever we need to
 1. Create a class of the broadcast and overide onReceive method of it
 2. Declare it in the manifest file and also mention the action of our receiver will listen to
 3. We are statically telling the receiver to listen for this event that's why it is called as the implicit broadcast receiver

##### Types of Broadcast receiver.

- STATIC --> DECLARED IN MANIFEST (CONSUMES BATTERY UNSAFE , WILL RUN EVEN IF THE APP IS CLOSED)
- DYNAMIC --> DECLARED AT RUNTIME (CONSUMES LESS BATTERY SAFE, WILL NOT RUN IF THE APP IS CLOSED)
- FOR Some reason the manifest declared broadcast receiver are not working in android 12 will look into it.

##### Understanding the Change in android 12 and Why's it's important

1. The reason behind this is from android 7.0 (n) The implicit receiver which are declared in the
2. Manifest file are depcrecated so we are left with only dynamic reciever which i have described below.
3. On start and onStop will run our receiver only when our app is in the foreground
4. if you want to runn the Receiver in background use register in onCreate and unregister in oNDestroy.