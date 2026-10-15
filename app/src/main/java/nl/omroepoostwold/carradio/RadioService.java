package nl.omroepoostwold.carradio;
import android.app.*;import android.content.*;import android.media.*;import android.os.*;
public class RadioService extends Service {
 public static final String URL="https://omroep-oostwold.nl:5995/stream?user=twinky";
 private MediaPlayer player; private boolean preparing=false;
 @Override public void onCreate(){super.onCreate(); Notification.Builder b=new Notification.Builder(this).setContentTitle("Omroep Oostwold").setContentText("Radio speelt af").setSmallIcon(android.R.drawable.ic_media_play);if(Build.VERSION.SDK_INT>=26){NotificationChannel c=new NotificationChannel("radio","Radio",NotificationManager.IMPORTANCE_LOW);getSystemService(NotificationManager.class).createNotificationChannel(c);b.setChannelId("radio");}startForeground(1,b.build());}
 @Override public int onStartCommand(Intent intent,int flags,int id){String action=intent==null?"PLAY":intent.getStringExtra("action");if("STOP".equals(action)){stopSelf();return START_NOT_STICKY;}play();return START_STICKY;}
 private void play(){if(player!=null||preparing)return;preparing=true;try{player=new MediaPlayer();player.setAudioStreamType(AudioManager.STREAM_MUSIC);player.setWakeMode(this,PowerManager.PARTIAL_WAKE_LOCK);player.setDataSource(URL);player.setOnPreparedListener(p->{preparing=false;p.start();});player.setOnErrorListener((p,a,b)->{release();return true;});player.prepareAsync();}catch(Exception e){release();}}
 private void release(){preparing=false;if(player!=null){try{player.reset();player.release();}catch(Exception ignored){}player=null;}}
 @Override public void onDestroy(){release();super.onDestroy();} @Override public IBinder onBind(Intent i){return null;}
}
